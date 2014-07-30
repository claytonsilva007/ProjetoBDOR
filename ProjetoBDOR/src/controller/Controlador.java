package controller;

import java.io.InputStream;

import persistense.RepositorioPacienteBDR;
import classesbasicas.Paciente;


public class Controlador {
	private RepositorioPacienteBDR repositorioPaciente; 
	private static Controlador controlador;
	
	public Controlador(){
		this.controlador = null;
		this.repositorioPaciente = new RepositorioPacienteBDR();
	}
	
	/**
	 * Implementação do padrão de projeto Singleton
	 * Método que retorna uma única instância da classe controlador
	 * @return controlador
	 */
	
	public static synchronized Controlador getcontrolador(){
		if(controlador ==  null){
			controlador = new Controlador();
		}
		return controlador;
	}	
	
	public void cadastrarPaciente(Paciente paciente){
		this.repositorioPaciente.cadastrarPaciente(paciente);
	}
	
	public Paciente consultarPaciente(String cpf){
		return this.repositorioPaciente.consultarPaciente(cpf);
	}
}
