package persistense;

import java.util.ArrayList;

import classesbasicas.Pessoa;

public interface InterfaceMedico {
	void inserir(Pessoa pessoa);
	void atualizar(Pessoa pessoa);
	void deletar(Pessoa pessoa);
	ArrayList<Pessoa> consultarPessoa(Pessoa Pessoa);
}
