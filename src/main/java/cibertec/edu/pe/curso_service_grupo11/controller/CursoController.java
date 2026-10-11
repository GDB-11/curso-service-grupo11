package cibertec.edu.pe.curso_service_grupo11.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.edu.pe.curso_service_grupo11.dto.CursoDisponibilidadDTO;
import cibertec.edu.pe.curso_service_grupo11.service.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

	private final CursoService cursoService;

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@GetMapping("/{idCurso}")
	public CursoDisponibilidadDTO obtenerCurso(@PathVariable Long idCurso) {
		return cursoService.obtenerCurso(idCurso);
	}

	@GetMapping("/estudiante/{estudianteId}")
	public List<CursoDisponibilidadDTO> obtenerCursosPorEstudiante(@PathVariable Long estudianteId) {
		return cursoService.obtenerCursosPorEstudiante(estudianteId);
	}
}
