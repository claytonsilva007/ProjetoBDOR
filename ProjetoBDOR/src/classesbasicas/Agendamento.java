package classesbasicas;

import java.util.Date;

public class Agendamento {
	private Date data;
	private boolean confimacao;
	private Medico medico;
	private Paciente paciente;
	private Atendente atendente;

	

	public Agendamento() {
		
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isConfimacao() {
		return confimacao;
	}
	public void setConfimacao(boolean confimacao) {
		this.confimacao = confimacao;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Atendente getAtendente() {
		return atendente;
	}
	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
}
