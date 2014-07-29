package beans;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CaptureEvent;

import util.ValidaCPF;
import classesbasicas.Endereco;
import classesbasicas.Funcionario;
import classesbasicas.Medico;
import classesbasicas.Paciente;
import classesbasicas.Telefone;
import controller.Controlador;

public class PacienteBean {
	private String convenio;
	private String idPaciente;
	private String cpf;
	private String estadoCivil;
	private String sexo;
	private ArrayList<Endereco> listaDeEnderecos;
	private String telefone;
	private String ddd;
	private String numTel;
	private String nome;
	private Date dataNasc;
	private Endereco endereco;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String complemento;
	private String cep;
	private String estado;
	private Paciente paciente;
	private Medico medico;
	private Funcionario funcionario;
	private Telefone tel;
	private String crm;
	private String especialidade;
	private String matricula;

	private boolean exibirCrm = false;
	private boolean exibirMatricula = false;

	private String tipoCadastroSelecionado;  
	private Map<String,String> tiposCadastro = new HashMap<String, String>();
	private ByteArrayInputStream foto;
	
	public PacienteBean(){
		tiposCadastro = new HashMap<String, String>();
		tiposCadastro.put(" ", " ");
		tiposCadastro.put("Paciente", "Paciente");
		tiposCadastro.put("Medico","Medico");
		tiposCadastro.put("Atendente","Atendente");
	}
	
	public void cadastrar(ActionEvent event) {
		if(this.preencheuCamposObrigatorios()){
			if(this.tipoCadastroSelecionado.equalsIgnoreCase("Paciente")){
				this.cadastrarPaciente();
			}else if(this.tipoCadastroSelecionado.equalsIgnoreCase("Medico")){
				this.cadastrarMedico();
			}else if(this.tipoCadastroSelecionado.equalsIgnoreCase("Funcionario")){
				this.cadastrarFuncionario();
			}
		} else {
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
	}
	
	public void cadastrarPaciente(){
		
		this.paciente = new Paciente();
		this.endereco = new Endereco();
		this.tel = new Telefone();
		this.paciente.setConvenio(this.convenio);
		this.paciente.setCpf(this.cpf);
		this.paciente.setEstadoCivil(this.estadoCivil);
		this.paciente.setNome(this.nome);
		this.paciente.setSexo(this.sexo);
		this.paciente.setListaDeEnderecos(this.listaDeEnderecos);
		this.tel.setDdd(this.ddd);
		this.tel.setNumero(this.telefone);
		this.tel.adicionarTelefone(tel);
		this.paciente.setTelefone(tel);
		this.endereco.setBairro(this.bairro);
		this.endereco.setCep(this.cep);
		this.endereco.setCidade(this.cidade);
		this.endereco.setComplemento(this.complemento);
		this.endereco.setEstado(this.estado);
		this.endereco.setLogradouro(this.logradouro);
		this.paciente.setEndereco(endereco);
		this.paciente.setFoto(foto);
		
		Controlador.getcontrolador().cadastrarPaciente(paciente);
	}
	
	public void cadastrarMedico(){
		this.medico = new Medico();
		this.endereco = new Endereco();
		this.tel = new Telefone();
		
		this.medico.setCpf(this.cpf);
		this.medico.setEstadoCivil(this.estadoCivil);
		this.medico.setNome(this.nome);
		this.medico.setSexo(this.sexo);
		this.medico.setListaDeEnderecos(this.listaDeEnderecos);
		this.tel.setDdd(this.ddd);
		this.tel.setNumero(this.telefone);
		this.tel.adicionarTelefone(tel);
		this.medico.setTelefone(tel);
		
		this.endereco.setBairro(this.bairro);
		this.endereco.setCep(this.cep);
		this.endereco.setCidade(this.cidade);
		this.endereco.setComplemento(this.complemento);
		this.endereco.setEstado(this.estado);
		this.endereco.setLogradouro(this.logradouro);
		this.medico.setEndereco(endereco);
		this.medico.setEspecialidade(this.especialidade);
		
		//Controlador.getcontrolador().cadastrarPaciente(paciente);
	}
	
	public void cadastrarFuncionario(){
		this.tel = new Telefone();
		this.funcionario = new Funcionario();
		this.funcionario.setCpf(this.cpf);
		this.funcionario.setEstadoCivil(this.estadoCivil);
		this.funcionario.setNome(this.nome);
		this.funcionario.setSexo(this.sexo);
		this.tel.setDdd(this.ddd);
		this.tel.setNumero(this.telefone);
		this.tel.adicionarTelefone(tel);
		this.funcionario.setTelefone(tel);
		this.funcionario.setListaDeEnderecos(this.listaDeEnderecos);
		this.endereco.setBairro(this.bairro);
		this.endereco.setCep(this.cep);
		this.endereco.setCidade(this.cidade);
		this.endereco.setComplemento(this.complemento);
		this.endereco.setEstado(this.estado);
		this.endereco.setLogradouro(this.logradouro);
		this.funcionario.setEndereco(endereco);
		
		//Controlador.getcontrolador().cadastrarPaciente(paciente);
		
	}
	
	public void renderizarComponentes(){
		if(this.tipoCadastroSelecionado.equalsIgnoreCase("Medico")){
			this.exibirCrm = true;
			this.exibirMatricula = false;
		}else if(this.tipoCadastroSelecionado.equalsIgnoreCase("Atendente")){
			this.exibirCrm = false;
			this.exibirMatricula = true;
		} else{
			this.exibirCrm = false;
			this.exibirMatricula = false;
		}
	}
	
	public void oncapture(CaptureEvent captureEvent) {
        
        byte[] data = captureEvent.getData();
        this.foto = new ByteArrayInputStream(data);
	}
	
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
				&& (this.numTel != null)
				&& (!this.tipoCadastroSelecionado.equalsIgnoreCase(""))){

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

	public ArrayList<Endereco> getListaDeEnderecos() {
		return listaDeEnderecos;
	}

	public void setListaDeEnderecos(ArrayList<Endereco> listaDeEnderecos) {
		this.listaDeEnderecos = listaDeEnderecos;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isExibirCrm() {
		return exibirCrm;
	}

	public void setExibirCrm(boolean exibirCrm) {
		this.exibirCrm = exibirCrm;
	}

	public boolean isExibirMatricula() {
		return exibirMatricula;
	}

	public void setExibirMatricula(boolean exibirMatricula) {
		this.exibirMatricula = exibirMatricula;
	}

	public String getTipoCadastroSelecionado() {
		return tipoCadastroSelecionado;
	}

	public void setTipoCadastroSelecionado(String tipoCadastroSelecionado) {
		this.tipoCadastroSelecionado = tipoCadastroSelecionado;
	}

	public Map<String, String> getTiposCadastro() {
		return tiposCadastro;
	}

	public void setTiposCadastro(Map<String, String> tiposCadastro) {
		this.tiposCadastro = tiposCadastro;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Telefone getTel() {
		return tel;
	}

	public void setTel(Telefone tel) {
		this.tel = tel;
	}

	public ByteArrayInputStream getFoto() {
		return foto;
	}

	public void setFoto(ByteArrayInputStream foto) {
		this.foto = foto;
	}	
}
