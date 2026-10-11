package cibertec.edu.pe.curso_service_grupo11.model;

public record Curso(
		Long id,
		String codigo,
		String nombre,
		String seccion,
		Integer creditos,
		Double costoPorCredito,
		Integer vacantes,
		String prerrequisito) {

	public String estado() {
		return vacantes > 0 ? "ABIERTO" : "CERRADO";
	}
}
