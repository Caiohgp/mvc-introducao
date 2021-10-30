package br.com.caiohenriquedev.controller;

import br.com.caiohenriquedev.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioDAO dao;
    @RequestMapping(value = "/todos",method = RequestMethod.GET)
    public ModelAndView listaTodos(ModelMap model){
        model.addAttribute("usuarios",dao.getTodos());
        return new ModelAndView("/user/list",model);
    }
}
