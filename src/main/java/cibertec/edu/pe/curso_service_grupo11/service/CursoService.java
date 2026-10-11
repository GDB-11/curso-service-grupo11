package cibertec.edu.pe.curso_service_grupo11.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cibertec.edu.pe.curso_service_grupo11.dto.CursoDisponibilidadDTO;
import cibertec.edu.pe.curso_service_grupo11.model.Curso;
import cibertec.edu.pe.curso_service_grupo11.repository.CursoRepository;

@Service
public class CursoService {

	private final CursoRepository cursoRepository;

	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public CursoDisponibilidadDTO obtenerCurso(Long idCurso) {
		return cursoRepository.buscarPorId(idCurso)
				.map(this::aDisponibilidad)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado: " + idCurso));
	}

	public List<CursoDisponibilidadDTO> obtenerCursosPorEstudiante(Long estudianteId) {
		return cursoRepository.buscarPorEstudiante(estudianteId).stream().map(this::aDisponibilidad).toList();
	}

	private CursoDisponibilidadDTO aDisponibilidad(Curso curso) {
		return CursoDisponibilidadDTO.builder()
				.idCurso(curso.id())
				.codigoCurso(curso.codigo())
				.nombreCurso(curso.nombre())
				.vacantesDisponibles(curso.vacantes())
				.prerrequisito(curso.prerrequisito())
				.estadoCurso(curso.estado())
				.build();
	}
}
