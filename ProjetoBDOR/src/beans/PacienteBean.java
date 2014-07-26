package beans;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import util.ValidaCPF;
import classesbasicas.Endereco;
import classesbasicas.Paciente;
import classesbasicas.Telefone;
import controller.Controlador;

public class PacienteBean {
	private String convenio;
	private String idPaciente;
	private String cpf;
	private String estadoCivil;
	private char sexo;
	private ArrayList<Endereco> listaDeEnderecos;
	private String telefone;
	private String ddd;
	private String numTel;
	private ArrayList<Telefone> listaDeTelefones;
	private String nome;
	private Date dataNasc;
	private Endereco endereco;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String complemento;
	private String cep;
	private String estado;
	
	@ManagedProperty(value="#{paciente}")
	private Paciente paciente;
	
	public void cadastrarPaciente(ActionEvent event) {
//		if(this.preencheuCamposObrigatorios()){
			
/*			Paciente paciente = new Paciente(); 
			Endereco endereco = new Endereco();
			
			paciente.setConvenio(this.convenio);
			paciente.setCpf(this.cpf);
			paciente.setEstadoCivil(this.estadoCivil);
			paciente.setIdPaciente(this.idPaciente);
			paciente.setNome(this.nome);
			paciente.setSexo(this.sexo);
			paciente.setListaDeEnderecos(this.listaDeEnderecos);
			this.setTelefone(this.ddd + this.numTel);
			paciente.setTelefones(this.listaDeTelefones);
			endereco.setBairro(this.bairro);
			
			endereco.setCep(this.cep);
			endereco.setCidade(this.cidade);
			endereco.setComplemento(this.complemento);
			endereco.setEstado(this.estado);
			endereco.setLogradouro(this.logradouro);
			
			paciente.setEndereco(endereco);
			
			Controlador.getcontrolador().cadastrarPaciente(paciente);
*/			
/*		} else {
			
			boolean cpfInvalido = ValidaCPF.validar(this.cpf); 
			
			if(cpfInvalido){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "",
								"Preecha os campos obrigatórios"));
			}else{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"CPF inválido!"));
			}
		}
*/	}
	
	public void alterarPaciente(Paciente paciente){
		System.out.println("Chamou o método alterar");
	}
	
	public void consultarPaciente(String cpf){
		System.out.println("Chamou o método consultar");
	}
	
	public void removerPaciente(String cpf){
		System.out.println("Chamou o método remover");
	}
	
	public boolean preencheuCamposObrigatorios(){
		boolean preencheu = false;
		boolean cpfValido = ValidaCPF.validar(this.cpf);
		if( (this.cpf != null && cpfValido) 
				&& (this.nome != null) 
				&& (this.logradouro != null)
				&&(this.cidade != null)
				&& (this.estado != null)
				&& (this.ddd != null)
				&& (this.numTel != null)){

			preencheu = true;
		} 
		return preencheu;
	}
	
	public void solicitarAgendamento(){
		//falta implementar
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

	public ArrayList<Telefone> getListaDeTelefones() {
		return listaDeTelefones;
	}

	public void setListaDeTelefones(ArrayList<Telefone> telefones) {
		this.listaDeTelefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}	
}
