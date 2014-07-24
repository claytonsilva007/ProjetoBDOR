package beans;

import java.util.ArrayList;

import classesbasicas.Endereco;
import classesbasicas.Paciente;
import classesbasicas.Telefone;

public class PacienteBean {
	private String convenio;
	private String idPaciente;
	private String cpf;
	private String estadoCivil;
	private char sexo;
	private ArrayList<Endereco> listaDeEnderecos;
	private ArrayList<Telefone> telefones;
	private String foto;
	private String nome;

	/**
	 * Método utilizado para inicializar as variáveis
	 * sempre que a tela for recarregada.
	 */
	public String getCarregar(){
		this.idPaciente = null;
		this.cpf = null;
		nome = null;
		this.estadoCivil = null;
		foto = null;
		this.sexo = ' ';
		this.convenio = null;
		this.listaDeEnderecos = null;
		this.telefones = null;
		return "";
	}

	public String cadastrarPaciente(Paciente paciente){
		System.out.println("Chamou o método cadastrar");
		return "sucesso";
	}
	
	public String alterarPaciente(Paciente paciente){
		System.out.println("Chamou o método alterar");
		return "sucesso";
	}
	
	public String consultarPaciente(String cpf){
		System.out.println("Chamou o método consultar");
		return "sucesso";
	}
	
	public String removerPaciente(String cpf){
		System.out.println("Chamou o método remover");
		return "sucesso";
	}
	
	public String solicitarAgendamento(){
		//falta implementar
		return "sucesso";
	}
	
	public String solicitarCancelamento(){
		//falta implementar
		return "sucesso";
	}
	
	public void consultarResultadoExames(){
		//falta implementar
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
