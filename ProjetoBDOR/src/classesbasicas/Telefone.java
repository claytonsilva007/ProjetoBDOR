package classesbasicas;

import java.util.ArrayList;

public class Telefone {
	
	private String ddd;
	private String codigoPais;
	private String numero;
	private ArrayList<Telefone> listaDeTelefones;
	
	public Telefone() {
		this.listaDeTelefones = new ArrayList<Telefone>();
	}
	
	public void adicionarTelefone(Telefone telefone){
		this.listaDeTelefones.add(telefone);
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Telefone> getListaDeTelefones() {
		return listaDeTelefones;
	}

	public void setListaDeTelefones(ArrayList<Telefone> listaDeTelefones) {
		this.listaDeTelefones = listaDeTelefones;
	}
}
