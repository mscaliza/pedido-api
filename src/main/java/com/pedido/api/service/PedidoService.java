package com.pedido.api.service;

import com.pedido.api.model.*;
import com.pedido.api.model.dto.LancheDTO;
import com.pedido.api.model.dto.PedidoCobrancaDTO;
import com.pedido.api.model.dto.PromocaoDTO;
import com.pedido.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private ItemIngredienteRepository itemIngredienteRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private LancheIngredienteRepository lancheIngredienteRepository;

    @Autowired
    private LancheRepository lancheRepository;

    @Autowired
    private PedidoItemPromocaoRepository pedidoItemPromocaoRepository;

    @Autowired
    private PromocaoRepository promocaoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public PedidoCobrancaDTO cadastrar(Pedido pedido) {

        pedidoRepository.save(pedido);

            pedido.getPedidoItem().forEach(pedidoItem -> {
            pedidoItem.setPedido_id(pedido.getId());
            pedidoItemRepository.save(pedidoItem);

            List<LancheIngrediente> li = (List<LancheIngrediente>) lancheIngredienteRepository.findByLanche(lancheRepository.getById(pedidoItem.getLanche_id()));
            li.forEach(i -> {
                ItemIngrediente ig = new ItemIngrediente(i.getIngrediente_id(), "", 1L);
                pedidoItem.getItemIngredientes().add(ig);
                    });

            List<Promocao> promocoes = new ArrayList<>();
            pedidoItem.setPromocoes(promocoes);

            AnalisarPromocaoService service = new AnalisarPromocaoService();
            service.analisarPromocaoLight(pedidoItem);
            service.analisarPromocaoMuitaCarne(pedidoItem);
            service.analisarPromocaoMuitoQueijo(pedidoItem);

            pedidoItem.getItemIngredientes().forEach(ingredientesItem -> {

                ingredientesItem.setPedidoItemId(pedidoItem.getId());

                Ingrediente i = ingredienteRepository.getById(ingredientesItem.getIngrediente_id());

                ingredientesItem.setValorUnitario(i.getValor());
                ingredientesItem.setValor(ingredientesItem.getValorUnitario().multiply(BigDecimal.valueOf(ingredientesItem.getQuantidade())));

                //(VALOR_UNITARIO * (QTDE_PROMO/QTDE))
                ingredientesItem.setValorFinal(
                        ingredientesItem.getValorUnitario().multiply(
                                BigDecimal.valueOf((ingredientesItem.getQuantidadePromocional() > 0 ? ingredientesItem.getQuantidadePromocional() : ingredientesItem.getQuantidade()))
                        )
                );

                //VALOR - (VALOR * DESC/100)
                ingredientesItem.setValorFinal(ingredientesItem.getValorFinal()
                        .subtract(ingredientesItem.getValorFinal()
                                .multiply(ingredientesItem.getDescontoPromocional().divide(BigDecimal.valueOf(100)))));

                itemIngredienteRepository.save(ingredientesItem);

            });

            pedidoItem.getItemPromocoes().forEach(promocao -> pedidoItemPromocaoRepository.save(promocao));
        });

        //Montar o PedidoCobrancaDTO para retornar
        PedidoCobrancaDTO pedidoCobrancaDTO = new PedidoCobrancaDTO();
        pedidoCobrancaDTO.setPedidoId(pedido.getId());
        pedidoCobrancaDTO.setData(pedido.getData());

        List<LancheDTO> lanches = new ArrayList<>();

        pedido.getPedidoItem().forEach(pedidoItem -> {
            Lanche lanche = lancheRepository.getById(pedidoItem.getLanche_id());
            LancheDTO lancheDTO = new LancheDTO();
            lancheDTO.setId(lanche.getId());
            lancheDTO.setDescricao(lanche.getDescricao());
            lancheDTO.setQuantidade(1L);
            lancheDTO.setValor(BigDecimal.valueOf(pedidoItem.getItemIngredientes().stream().mapToDouble(ii -> ii.getValor().doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP));
            lancheDTO.setValorPromocional(BigDecimal.valueOf(pedidoItem.getItemIngredientes().stream().mapToDouble(ii -> ii.getValorFinal().doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP));

            if (pedidoItem.getItemPromocoes().stream().count() > 0) {
                pedidoItem.getItemPromocoes().forEach(p -> {
                    PromocaoDTO promocao = new PromocaoDTO();
                    promocao.setPromocao(promocaoRepository.getById(p.getPromocaoId()).getDescricao());
                    lancheDTO.addPromocao(promocao);
                });
                lancheDTO.setValorFinal(lancheDTO.getValorPromocional());
            } else {
                lancheDTO.setValorPromocional(BigDecimal.valueOf(0));
                lancheDTO.setValorFinal(lancheDTO.getValor());
            }

            lanches.add(lancheDTO);
        });
        pedidoCobrancaDTO.setLanches(lanches);
        pedidoCobrancaDTO.setValor(BigDecimal.valueOf(pedidoCobrancaDTO.getLanches().stream().mapToDouble(pi -> pi.getValor().doubleValue()).sum()).setScale(2, RoundingMode.HALF_UP));
        pedidoCobrancaDTO.setValorFinal(BigDecimal.valueOf(pedidoCobrancaDTO.getLanches().stream().mapToDouble(pi ->
                (pi.getValorPromocional().doubleValue() == 0) ? pi.getValor().doubleValue() : pi.getValorPromocional().doubleValue()
        ).sum()).setScale(2, RoundingMode.HALF_UP));
        pedidoCobrancaDTO.setDescontoPromocional(pedidoCobrancaDTO.getValorFinal().compareTo(BigDecimal.valueOf(0)) == 0 ? BigDecimal.valueOf(0) : pedidoCobrancaDTO.getValor().subtract(pedidoCobrancaDTO.getValorFinal()).setScale(2, RoundingMode.HALF_UP));

        return pedidoCobrancaDTO;
    }

}



