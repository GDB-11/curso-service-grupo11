package cibertec.edu.pe.curso_service_grupo11.dto;

public record CursoDisponibilidadDTO(
		Long idCurso,
		String codigoCurso,
		String nombreCurso,
		Integer vacantesDisponibles,
		String prerrequisito,
		String estadoCurso) {

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private Long idCurso;
		private String codigoCurso;
		private String nombreCurso;
		private Integer vacantesDisponibles;
		private String prerrequisito;
		private String estadoCurso;

		public Builder idCurso(Long idCurso) {
			this.idCurso = idCurso;
			return this;
		}

		public Builder codigoCurso(String codigoCurso) {
			this.codigoCurso = codigoCurso;
			return this;
		}

		public Builder nombreCurso(String nombreCurso) {
			this.nombreCurso = nombreCurso;
			return this;
		}

		public Builder vacantesDisponibles(Integer vacantesDisponibles) {
			this.vacantesDisponibles = vacantesDisponibles;
			return this;
		}

		public Builder prerrequisito(String prerrequisito) {
			this.prerrequisito = prerrequisito;
			return this;
		}

		public Builder estadoCurso(String estadoCurso) {
			this.estadoCurso = estadoCurso;
			return this;
		}

		public CursoDisponibilidadDTO build() {
			return new CursoDisponibilidadDTO(idCurso, codigoCurso, nombreCurso, vacantesDisponibles, prerrequisito, estadoCurso);
		}
	}
}
