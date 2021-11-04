package br.com.caiohenriquedev.controller;

import br.com.caiohenriquedev.dao.UsuarioDAO;
import br.com.caiohenriquedev.domain.TipoSexo;
import br.com.caiohenriquedev.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/cadastro")
    public String cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap model){
        model.addAttribute("sexos", TipoSexo.values());
        return "/user/add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "/user/add";
        }
        dao.salvar(usuario);
        redirectAttributes.addFlashAttribute("message","Usuário salvo com sucesso");
        return "redirect:/usuario/todos";
    }

    @GetMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){
        Usuario usuario = dao.getById(id);
        model.addAttribute("usuario",usuario);
        return new ModelAndView("/user/add",model);
    }

    @PostMapping("/update")
    public ModelAndView preUpdate(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return new ModelAndView("/user/add");
        }
        dao.editar(usuario);
        redirectAttributes.addFlashAttribute("message","Usuário editado com sucesso");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){

        dao.excluir(id);
        redirectAttributes.addFlashAttribute("message","Usuário excluído com sucesso");

        return new ModelAndView("redirect:/usuario/todos");
    }
}
