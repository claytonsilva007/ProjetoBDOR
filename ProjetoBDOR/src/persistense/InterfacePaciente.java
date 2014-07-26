package persistense;

import java.util.ArrayList;

import classesbasicas.Paciente;
import classesbasicas.Pessoa;

public interface InterfacePaciente {
	void atualizar(Pessoa pessoa);
	void deletar(Pessoa pessoa);
	ArrayList<Pessoa> consultarPessoa(Pessoa Pessoa);
	void cadastrarPaciente(Paciente paciente);
}
