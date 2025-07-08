package com.dev.batismoDeJava.cadastroNinja.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    @GetMapping("/todos")
    //Model model,vem da biblioteca ui do java
    public String listarNinjas(Model model) {
        List<NinjaDTO>ninjas = ninjaService.listarNinjas();
        //metodo do model addAttribute(object)
        model.addAttribute("ninjas",ninjas);
        return "listarNinjas";//tem que retornar o html,no caso listarNinjas
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
        return "redirect:/ninjas/ui/todos";
    }
    @GetMapping("/todos/{id}")
    public String listarNinjaId(@PathVariable Long id,Model model){
        if (id != null) {
            NinjaDTO ninja = ninjaService.NinjaPorID(id);
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        }
        return "redirect:/ninjas/ui/todos";
    }
    @PostMapping("/criar")
    public String criarNinja(@ModelAttribute NinjaDTO ninjaDTO,Model model){
    ninjaService.criarNinja(ninjaDTO);
        model.addAttribute("ninja",ninjaDTO);
        return "redirect:/ninjas/ui/todos";
    }
    @GetMapping("/criar")
    public String mostrarFormulario(@ModelAttribute NinjaDTO ninjaDTO,Model model){
        model.addAttribute("ninja",new NinjaDTO());
        return "formularioNinja";
    }

    @GetMapping("/alterar/id/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.NinjaPorID(id);
        model.addAttribute("ninja", ninja);
        return "formularioNinja";
    }
    @PostMapping("/alterar/id/{id}")
    public String salvarNinja(@PathVariable Long id,@ModelAttribute NinjaDTO ninjaDTO) {
        ninjaService.atualizarNinja(id, ninjaDTO);
        return "redirect:/ninjas/ui/todos";
    }
}
