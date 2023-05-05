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

import com.trabfinal.dojo.models.entity.Alumno;
import com.trabfinal.dojo.models.services.IAlumnoService;


@Controller
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@RequestMapping(value = "/listarAl",method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de alumnos");
		model.addAttribute("alumnos",alumnoService.findAll());
		return "alumno/listar";
	}
	@RequestMapping(value = "/formAl")
	public String formularioAlumno(Map<String, Object> model) {
		Alumno alumno=new Alumno();
		model.put("alumno", alumno);
		model.put("titulo", "Formulario del Alumno");
		return "alumno/frmAlumno";
	}
	@RequestMapping(value = "/formAl/{id}")
	public String editar(@PathVariable (value = "id") Long id,
			Map<String, Object> model) {
		Alumno alumno=null;
		if(id>0) {
			alumno=alumnoService.findOne(id);
		}else {
		   return "redirect:alumno/listar";		   
		}
		model.put("alumno", alumno);
		model.put("titulo", "Editar Alumno");		
		return "alumno/frmAlumno";
	}
	@RequestMapping(value = "/formAl", method = RequestMethod.POST)
	public String registrar(@Validated Alumno alumno, BindingResult result,
			Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Alumno");
			return "alumno/frmAlumno";
		}
		alumnoService.save(alumno);
		status.setComplete();
		return "redirect:alumno/listar";
		//return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminarAl/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			alumnoService.delete(id);
		}
		return "redirect:alumno/listar";
	}	
}




