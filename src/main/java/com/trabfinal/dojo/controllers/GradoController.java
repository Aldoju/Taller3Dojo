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

import com.trabfinal.dojo.models.entity.Grado;
import com.trabfinal.dojo.models.services.IGradoService;
import com.trabfinal.dojo.util.paginator.PageRender;


@Controller
public class GradoController {
    @Autowired
	private IGradoService gradoService;
	
	@RequestMapping(value = {"listarGra"},method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0")
    int page, Model model)
	{	
		Pageable pageRequest = PageRequest.of(page,8);
        Page<Grado> grados=gradoService.findAll(pageRequest);

		PageRender<Grado> pageRender=new PageRender<Grado>("/listar",grados);
		model.addAttribute("titulo","Listado de grado");
		model.addAttribute("grado",gradoService.findAll());
		model.addAttribute("page",pageRender);
		return "grado/listar";
	}
	@RequestMapping(value = "/formGra")
	public String formularioGrado(Map<String, Object> model) {
		Grado grado=new Grado();
		model.put("grado", grado);
		model.put("titulo", "Formulario del grado");
		return "grado/form";
	}
	@RequestMapping(value = "/formGra/{id}")
	public String editar(@PathVariable (value = "id") Long id,
			Map<String, Object> model) {
		Grado grado=null;
		if(id>0) {
			grado=gradoService.findOne(id);
		}else {
		   return "redirect/listarGra";		   
		}
		model.put("grado", grado);
		model.put("titulo", "Editar grado");		
		return "grado/form";
	}
	@RequestMapping(value = "/formGra", method = RequestMethod.POST)
	public String registrar(@Validated Grado grado, BindingResult result,
			Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del grado");
			return "grado/form";
		}
		gradoService.save(grado);
		status.setComplete();
		return "redirect:/listarGra";
	}
	
	@RequestMapping(value="/eliminarGra/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			gradoService.delete(id);
		}
		return "redirect:/listarGra";
	}	

   
}
