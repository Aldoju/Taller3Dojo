package com.trabfinal.dojo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.trabfinal.dojo.models.entity.Sensei;
import com.trabfinal.dojo.models.services.ISenseiService;

@Controller
@SessionAttributes("sensei")
public class SenseiController {

    @Autowired
	private ISenseiService senseiService;
	
	@RequestMapping(value = "/listar",method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",senseiService.findAll());
		return "listar";
	}
	@RequestMapping(value = "/form")
	public String formularioCliente(Map<String, Object> model) {
		Sensei sensei=new Sensei();
		model.put("sensei", sensei);
		model.put("titulo", "Formulario del Sensei");
		return "frmSensei";
	}
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable (value = "id") Long id,
			Map<String, Object> model) {
		Sensei sensei=null;
		if(id>0) {
			sensei=senseiService.findOne(id);
		}else {
		   return "redirect:/listar";		   
		}
		model.put("sensei", sensei);
		model.put("titulo", "Editar Sensei");		
		return "frmSensei";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String registrar(@Validated Sensei sensei, BindingResult result,
			Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Sensei");
			return "frmSensei";
		}
		senseiService.save(sensei);
		status.setComplete();
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			senseiService.delete(id);
		}
		return "redirect:/listar";
	}	
    
}
