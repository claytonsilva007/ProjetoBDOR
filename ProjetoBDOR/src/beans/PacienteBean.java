package beans;

import classesbasicas.Paciente;
import controller.Controlador;

public class PacienteBean extends Paciente{
	
	public void getCarregar(){
		this.setNome("clayton rodrigues da silva");
		this.setConvenio("");
		this.setFoto("");
		this.setEstadoCivil("");
		this.setCpf("");
		this.setListaDeEnderecos(null);
		this.setTelefones(null);
	}
	
	
	public void cadastrarPaciente(){
		Controlador.getcontrolador().cadastrar(this);
	}
	
	public static void main (String args[]){
		PacienteBean paciente = new PacienteBean();
		paciente.getCarregar();
		paciente.cadastrarPaciente();
	
	}

}
