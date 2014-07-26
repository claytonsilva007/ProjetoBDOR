package persistense;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.ConnectionFactory;
import classesbasicas.Paciente;
import classesbasicas.Pessoa;

public class RepositorioPacienteBDR implements InterfacePaciente{

	
	public void inserirFoto(InputStream data){
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionFactory.getConnection();
			stmt = conexao.prepareStatement("INSERT INTO foto VALUES ('?, ?')");

			stmt.setInt(1, 1);
			stmt.setBinaryStream(2, data);
			stmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
			System.out.println("chamou o m�todo inserir");
			System.out.println(paciente.getNome());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
