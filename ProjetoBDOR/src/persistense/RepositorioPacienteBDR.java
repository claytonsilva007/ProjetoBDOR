package persistense;

import java.util.ArrayList;

import classesbasicas.Pessoa;

public class RepositorioPacienteBDR implements InterfacePaciente{

	@Override
	public void inserir(Pessoa pessoa) {
		System.out.println("chamou o método inserir");
		System.out.println(pessoa.getNome());
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		System.out.println("chamou o método atualizar");
	}

	@Override
	public void deletar(Pessoa pessoa) {
		System.out.println("chamou o método deletar");
	}

	@Override
	public ArrayList<Pessoa> consultarPessoa(Pessoa Pessoa) {
		return null;
	}
}
