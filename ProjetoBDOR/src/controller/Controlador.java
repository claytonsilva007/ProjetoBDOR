package controller;

import persistense.RepositorioPacienteBDR;
import classesbasicas.Pessoa;

public class Controlador {
	private RepositorioPacienteBDR repositorioPaciente; 
	private static Controlador controlador;
	
	public Controlador(){
		this.controlador = null;
		this.repositorioPaciente = new RepositorioPacienteBDR();
	}
	
	/**
	 * Implementa��o do padr�o de projeto Singleton
	 * M�todo que retorna uma �nica inst�ncia da classe controlador
	 * @return controlador
	 */
	
	public static synchronized Controlador getcontrolador(){
		if(controlador ==  null){
			controlador = new Controlador();
		}
		return controlador;
	}	
	
	public void cadastrar(Pessoa pessoa){
		this.repositorioPaciente.inserir(pessoa);
	}
}
