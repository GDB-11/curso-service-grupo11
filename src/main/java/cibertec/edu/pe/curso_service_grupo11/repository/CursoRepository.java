package cibertec.edu.pe.curso_service_grupo11.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cibertec.edu.pe.curso_service_grupo11.model.Curso;

@Repository
public class CursoRepository {

	private static final List<Curso> CURSOS = List.of(
			new Curso(1L, "INF101", "Algoritmos y Estructuras de Datos", "A", 4, 150.0, 12, null),
			new Curso(2L, "INF202", "Base de Datos", "B", 3, 160.0, 5, "INF101"),
			new Curso(3L, "INF303", "Arquitectura de Microservicios", "A", 4, 180.0, 0, "INF202"),
			new Curso(4L, "MAT110", "Matematica Discreta", "C", 3, 140.0, 20, null),
			new Curso(5L, "INF404", "Desarrollo de Aplicaciones Moviles", "A", 3, 170.0, 8, "INF202"));

	private static final Map<Long, List<Long>> CURSOS_POR_ESTUDIANTE = Map.of(
			1L, List.of(1L, 2L, 4L),
			2L, List.of(1L, 3L, 5L),
			3L, List.of(2L, 4L));

	public Optional<Curso> buscarPorId(Long idCurso) {
		return CURSOS.stream().filter(curso -> curso.id().equals(idCurso)).findFirst();
	}

	public List<Curso> buscarPorEstudiante(Long estudianteId) {
		List<Long> ids = CURSOS_POR_ESTUDIANTE.get(estudianteId);
		if (ids == null) {
			return CURSOS.stream().filter(curso -> "ABIERTO".equals(curso.estado())).toList();
		}
		return CURSOS.stream().filter(curso -> ids.contains(curso.id())).toList();
	}
}
