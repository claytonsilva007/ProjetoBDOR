package persistense;

import java.util.ArrayList;

import classesbasicas.Pessoa;

public class RepositorioPacienteBDR implements InterfacePaciente{

	@Override
	public void inserir(Pessoa pessoa) {
		System.out.println("chamou o m�todo inserir");
		System.out.println(pessoa.getNome());
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		System.out.println("chamou o m�todo atualizar");
	}

	@Override
	public void deletar(Pessoa pessoa) {
		System.out.println("chamou o m�todo deletar");
	}

	@Override
	public ArrayList<Pessoa> consultarPessoa(Pessoa Pessoa) {
		return null;
	}
}
