package classesbasicas;

import java.util.ArrayList;

public abstract class Pessoa {
	private String cpf;
	private String estadoCivil;
	private char sexo;
	private ArrayList<Endereco> listaDeEnderecos;
	private ArrayList<Telefone> telefones;
	private String foto;
	private String nome;

	
	
	public Pessoa() {
	
	}
	
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public ArrayList<Endereco> getListaDeEnderecos() {
		return listaDeEnderecos;
	}
	public void setListaDeEnderecos(ArrayList<Endereco> listaDeEnderecos) {
		this.listaDeEnderecos = listaDeEnderecos;
	}
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}