package com.trabfinal.dojo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.trabfinal.dojo.models.entity.Alumno;
import com.trabfinal.dojo.models.entity.Clase;
import com.trabfinal.dojo.models.entity.Matricula;
import com.trabfinal.dojo.models.entity.Sensei;
import com.trabfinal.dojo.models.services.IAlumnoService;
import com.trabfinal.dojo.models.services.IClaseService;
import com.trabfinal.dojo.models.services.IHorarioService;
import com.trabfinal.dojo.models.services.ISenseiService;
import com.trabfinal.dojo.models.services.MatriculaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;



@Controller
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IClaseService claseService;

	@Autowired
	private IHorarioService horarioService;

	@Autowired
	private ISenseiService senseiService;

	@Autowired
	private MatriculaService matriculaService;

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

	// @GetMapping("/consultaHorarios")
    // public String ejecutarConsultaJPA(@RequestParam("selectedValue") Long claseId) {
    //     String queryString = "SELECT s.nombres FROM Clase c JOIN c.senseis s";
    //     TypedQuery<String> query = entityManager.createQuery(queryString, String.class);
	// 	query.setMaxResults(1); // Limitar los resultados a 1
	// 	List<String> results = query.getResultList();
	// 	if (!results.isEmpty()) {
	// 		String primerRegistro = results.get(0);
	// 		return primerRegistro;
	// 	} else {
	// 		return "No se encontraron registros";
    // 	}
    // }


	//-----------------------------------------------------
	@RequestMapping(value = "/listarM",method = RequestMethod.GET)
	public String listarM(Model model) {
		model.addAttribute("titulo","Listado de alumnos");
		model.addAttribute("alumnos",matriculaService.findAll());
		return "matricula/listar";
	}

	@GetMapping(value = "/formM/{id}")
	public String formularioMatricula(@PathVariable(value="id")Long id,Map<String, Object> model,Model mod) {
		Matricula matricula=new Matricula();
		Alumno alumno=null;
		if(id>0) {
			alumno=alumnoService.findOne(id);
			matricula.setAlumno(alumno);
		}else {
		   return "redirect:alumno/listar";		   
		}
		model.put("matricula", matricula);
		model.put("titulo", "Formulario de Matricula");
		mod.addAttribute("clases", claseService.findAll());
		mod.addAttribute("senseis", senseiService.findAll());
		return "alumno/formMatricula";
	}
	
	@RequestMapping(value = "/formM", method = RequestMethod.POST)
	public String registrarMatricula(@Validated Matricula matricula,BindingResult result,
			Model model, SessionStatus status) {
		Long idal=matricula.getAlumno().getId();
		Long id= matricula.getClase().getId();
		Long idsen=matricula.getSensei().getIdSensei();
		Alumno alumno=entityManager.find(Alumno.class,idal);
		Clase clase = entityManager.find(Clase.class, id);
		Sensei sensei=entityManager.find(Sensei.class,idsen);
		matricula.setAlumno(alumno);
		matricula.setClase(clase);
		matricula.setSensei(sensei);
		matriculaService.save(matricula);
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Matricula");
			return "alumno/formMatricula";
		}
		matriculaService.save(matricula);
		status.setComplete();
		return "redirect:/listarAl";
	}


	// @GetMapping("/consultaSensei/{claseId}")
	// public ResponseEntity<List<String>> ejecutarConsultaJPA(@RequestParam("claseId") Long claseId) {
	// 	String queryString = "SELECT s.nombres FROM Sensei s WHERE s.claseId = :claseId";
	// 	TypedQuery<String> query = entityManager.createQuery(queryString, String.class);
	// 	query.setParameter("claseId", claseId);
	// 	List<String> results = query.getResultList();

	// 	return ResponseEntity.ok(results);
	// }
}




