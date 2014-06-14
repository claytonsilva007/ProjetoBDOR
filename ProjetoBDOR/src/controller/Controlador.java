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
	
	public void cadastrar(Pessoa pessoa){
		this.repositorioPaciente.inserir(pessoa);
	}
}
