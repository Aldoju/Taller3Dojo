package com.trabfinal.dojo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.trabfinal.dojo.models.entity.Alumno;
import com.trabfinal.dojo.models.services.IAlumnoService;
import com.trabfinal.dojo.models.services.IClaseService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;



@Controller
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IClaseService claseService;

	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping(value = "/listarAl",method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de alumnos");
		model.addAttribute("alumnos",alumnoService.findAll());
		return "alumno/listar";
	}

	@RequestMapping(value = "/formAl")
	public String formularioAlumno(Map<String, Object> model,Model mod) {
		Alumno alumno=new Alumno();
		model.put("alumno", alumno);
		model.put("titulo", "Formulario del Alumno");
		mod.addAttribute("clases", claseService.findAll());
		return "alumno/frmAlumno";
	}
	
	@RequestMapping(value = "/formAl/{id}")
	public String editar(@PathVariable (value = "id") Long id,
			Map<String, Object> model,Model mod) {
		Alumno alumno=null;
		if(id>0) {
			alumno=alumnoService.findOne(id);
		}else {
		   return "redirect:alumno/listar";		   
		}
		model.put("alumno", alumno);
		mod.addAttribute("clases", claseService.findAll());
		model.put("titulo", "Editar Alumno");		
		return "alumno/editar";
	}
	
	// @RequestMapping(value = "/obtesen/{id}")
	// public Long obteSensei(@Validated Alumno alumno,@PathVariable (value = "id") Long id) {
	// 	alumno.setSensei(senseiService.findOne(id));
	// 	return alumno.getSensei().getIdSensei();
	// }


	// @RequestMapping(value = "/editAl", method = RequestMethod.POST)
	// public String editar(@Validated Alumno alumno,BindingResult result,
	// 	Model model, SessionStatus status) {
	// 	Long codsen=alumno.getSensei().getIdSensei();
	// 	alumno.setSensei(senseiService.findOne(codsen));
	// 	alumnoService.save(alumno);

	// 	if(result.hasErrors()) {
	// 		model.addAttribute("titulo", "Formulario del Alumno");
	// 		return "alumno/frmAlumno";
	// 	}
		
	// 	status.setComplete();
	// 	return "redirect:/listarAl";
	// }


	@RequestMapping(value = "/formAl", method = RequestMethod.POST)
	public String registrar(@Validated Alumno alumno, BindingResult result,
			Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Alumno");
			return "alumno/frmAlumno";
		}
		alumnoService.save(alumno);
		status.setComplete();
		return "redirect:/listarAl";
	}
	
	@RequestMapping(value="/eliminarAl/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id>0) {
			alumnoService.delete(id);
		}
		return "redirect:/listarAl";
	}	

	@GetMapping("/consultaHorarios")
    public List<Object> ejecutarConsultaJPA() {
        String queryString = "Select s.nombre from Sensei s join Clase c on s.idClase=c.idClase"; // Tu consulta JPA aquí
        //"SELECT h.dias from horario h inner join Sensei s on h.senseiId=s.idSensei inner join Clase c on s.idClase=c.idClase where c.nombre=Karate"
        TypedQuery<Object> query = entityManager.createQuery(queryString, Object.class);
        List<Object> results = query.getResultList();
        
        return results;
    }
}




