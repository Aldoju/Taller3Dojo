package com.trabfinal.dojo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.trabfinal.dojo.models.entity.Clase;
import com.trabfinal.dojo.models.entity.Horario;
import com.trabfinal.dojo.models.services.IClaseService;
import com.trabfinal.dojo.util.paginator.PageRender;

 @Controller
public class ClaseController {
    @Autowired
	private IClaseService claseService;
	
	@RequestMapping(value = {"/listarCla"},method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0")
    int page, Model model) {
		Pageable pageRequest = PageRequest.of(page,8);
        Page<Clase> clases=claseService.findAll(pageRequest);

		PageRender<Clase> pageRender=new PageRender<Clase>("/listar",clases);
		model.addAttribute("titulo","Listado de Clases");
		model.addAttribute("clase",claseService.findAll());
		model.addAttribute("page",pageRender);
		return "clase/listar";
	}
	@RequestMapping(value = "/formCla")
	public String formularioCliente(Map<String, Object> model) {
		Clase clase=new Clase();
		model.put("clase", clase);
		model.put("titulo", "Formulario del clase");
		return "clase/form";
	}
	@RequestMapping(value = "/formCla/{id}")
	public String editar(@PathVariable (value = "id") Long id,
			Map<String, Object> model) {
		Clase clase=null;
		if(id>0) {
			clase=claseService.findOne(id);
		}else {
		   return "redirect/listarCla";		   
		}
		model.put("clase", clase);
		model.put("titulo", "Editar clase");		
		return "clase/form";
	}
	@RequestMapping(value = "/formCla", method = RequestMethod.POST)
	public String registrar(@Validated Clase clase, BindingResult result,
			Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del clase");
			return "clase/form";
		}
		claseService.save(clase);
		status.setComplete();
		return "redirect:/listarCla";
	}
	
	@RequestMapping(value="/eliminarCla/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			claseService.delete(id);
		}
		return "redirect:/listarCla";
	}	


}
