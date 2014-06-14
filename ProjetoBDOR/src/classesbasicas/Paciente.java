package classesbasicas;

public class Paciente extends Pessoa{
	private String convenio;
	private String idPaciente;
	
	public Paciente() {
		
	}

	public Paciente(String convenio, String idPaciente) {
		super();
		this.convenio = convenio;
		this.idPaciente = idPaciente;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
}
