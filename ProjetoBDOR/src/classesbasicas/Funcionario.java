package classesbasicas;

import java.util.ArrayList;

public class Funcionario {
	private String convenio;
	private String idPaciente;
	private String cpf;
	private String estadoCivil;
	private String sexo;
	private String nome;
	private ArrayList<Endereco> listaDeEnderecos;
	private Endereco endereco;
	private Telefone telefone;
	private String matricula;
	private Telefone tel;
	
	public Funcionario(){
		
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

	public String getCpf() {
		return cpf;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public ArrayList<Endereco> getListaDeEnderecos() {
		return listaDeEnderecos;
	}

	public void setListaDeEnderecos(ArrayList<Endereco> listaDeEnderecos) {
		this.listaDeEnderecos = listaDeEnderecos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Telefone getTel() {
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}
	
}
