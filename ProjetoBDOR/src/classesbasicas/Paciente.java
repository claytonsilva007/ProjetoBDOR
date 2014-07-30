package classesbasicas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class Paciente {
	private String convenio;
	private String idPaciente;
	private String cpf;
	private String estadoCivil;
	private String sexo;
	private ArrayList<Endereco> listaDeEnderecos;
	private ArrayList<Telefone> telefones;
	private InputStream foto;
	private String nome;
	private Endereco endereco;
	private Telefone telefone;
	private String numeroTelefone;
	private Date DataNasc;
	
	public Paciente() {
		this.telefones = new ArrayList<Telefone>();
	}
	
	public void adicionarTelefone(Telefone telefone){
		this.telefones.add(telefone);
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
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
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

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Date getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		DataNasc = dataNasc;
	}
}
