package com.trabfinal.dojo.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabfinal.dojo.models.entity.Horario;
import com.trabfinal.dojo.models.services.IHorarioService;
import com.trabfinal.dojo.util.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("horario")
public class HorarioController {
    @Autowired
    private IHorarioService horarioService;

   @RequestMapping(value="/listarHor", method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue="0")
    int page, Model model){
        Pageable pageRequest = PageRequest.of(page,8);
        Page<Horario> horarios=horarioService.findAll(pageRequest);

        PageRender<Horario> pageRender=new PageRender<Horario>("/listar",horarios);
        model.addAttribute("titulo","Listado de horarios");
        model.addAttribute("horarios",horarios);
        model.addAttribute("page",pageRender);
        return "horario/listar";
    }

    

    @RequestMapping(value="/formHor", method = RequestMethod.GET)
    public String crear(Map<String,Object> model){
        Horario horario=new Horario();
        model.put("horario",horario);
        model.put("titulo","Formulario de Horario");
        return "/horario/form";
    }

    @RequestMapping(value="/formHor/{id}")
    public String editar(@PathVariable(value="id") Long id,Map<String, Object> model,RedirectAttributes flash){
        Horario horario=null;
        if(id>0){
            horario=horarioService.findOne(id);
            if(horario==null){
                flash.addFlashAttribute("error","El ID del horario no pude ser cero");
                return "redirect:/listarHor";
            }
        }else{
            flash.addFlashAttribute("error","El ID del horario no puede ser cero");
            return "redirect:/listarHor";
        }
        model.put("horario",horario);
        model.put("titulo","Editar Horario");
        return "/horario/form";
    }


    @RequestMapping(value="/formHor", method=RequestMethod.POST)
    public String guardar(@Valid Horario horario, BindingResult result, Model model, RedirectAttributes flash,SessionStatus status){
        
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de Horario");
            return "/horario/form";
        }
        

        String mensajeFlash=(horario.getIdHorario()!=null)?
        "Horario editado con exito!": "Horario creado con exito";

        horarioService.save(horario);
        status.setComplete();
        flash.addFlashAttribute("success",mensajeFlash);
        return "redirect:listarHor";
    }



    @RequestMapping(value="/eliminarHor/{id}")
    public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash){
        if(id>0){
            // Horario horario=horarioService.findOne(id);
            horarioService.delete(id);
            // flash.addFlashAttribute("info", "Foto"+horario.getFoto()+"eliminada");
        }
    
        return "redirect:/listar";
    }
} 