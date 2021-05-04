package com.pedido;

import com.pedido.api.model.Lanche;
import com.pedido.api.model.LancheIngrediente;
import com.pedido.api.repository.LancheIngredienteRepository;
import com.pedido.api.repository.LancheRepository;
import com.pedido.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LanchesController {

    @Autowired
    private LancheRepository lancheRepository;

    @Autowired
    private LancheIngredienteRepository lancheIngredienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @RequestMapping(value = "/cadastrarlanche", method = RequestMethod.GET)
    public String cadastrarLanche() {
        return "lancheCadastro";
    }

    @RequestMapping(value = "/cadastrarlanche", method = RequestMethod.POST)
    public String cadastrarLanche(Lanche lanche) {
        
        lancheRepository.save(lanche);
        return "redirect:/listarlanches";
    }

    @RequestMapping("/listarlanches")
    public ModelAndView listarLanches() {

        ModelAndView mv = new ModelAndView("lancheLista");
        Iterable<Lanche> lanches = lancheRepository.findAll();
        mv.addObject("lanches", lanches);
        return mv;
    }

    @RequestMapping("/detalhesLanche/{lanche_id}")
    public ModelAndView detalhesLanche(@PathVariable("lanche_id") Long id) {
        Lanche lanche = lancheRepository.getById(id);
        ModelAndView mv = new ModelAndView("detalhesLanche");
        mv.addObject("lanche", lanche);

        Iterable<LancheIngrediente> lancheIngredientes = lancheIngredienteRepository.findByLanche(lanche);
        mv.addObject("lancheIngredientes", lancheIngredientes);

        return mv;

    }
}
