package persistense;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.ConnectionFactory;
import classesbasicas.Paciente;
import classesbasicas.Pessoa;

public class RepositorioPacienteBDR implements InterfacePaciente{

	public void cadastrarPaciente(Paciente paciente) {
		Connection conexao = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionFactory.getConnection();
			
			stmt = conexao.createStatement();
			rs = stmt.executeQuery("INSERT INTO foto (name) VALUES ('maria')");

			while(rs.next()) {
				System.out.print(rs.getString(1) + "\t");
			}
			System.out.println("chamou o método inserir");
			System.out.println(paciente.getNome());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
