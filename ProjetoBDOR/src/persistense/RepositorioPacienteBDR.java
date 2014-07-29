package persistense;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp.ConnectionFactory;

import util.FabricaDeConexoes;
import classesbasicas.Paciente;
import classesbasicas.Pessoa;

public class RepositorioPacienteBDR implements InterfacePaciente{

	public void cadastrarPaciente(Paciente paciente) {
		Connection conexao = null;
		PreparedStatement stmt = null;
		StringBuffer sbi = new StringBuffer();

		sbi.append("INSERT INTO TB_PACIENTE");
		sbi.append("( "); //INÍCIO PARÊNTESIS INSERT
		sbi.append("CPF,");
		sbi.append("ESTADO_CIVIL,");
		sbi.append("NOME,");
		sbi.append("ENDERECO,");
		sbi.append("SEXO,");
		sbi.append("FONE,");
		sbi.append("FOTO,");
		sbi.append("COD_PACIENTE,");
		sbi.append("CONVENIO");
		sbi.append(" ) "); //FIM PARÊNTESIS INSERT
		sbi.append("VALUES");
		sbi.append("( "); // INÍCIO PARÊNTESIS VALUES
		sbi.append("? , "); // 1 - cpf 
		sbi.append("? , "); // 2 - estado civil
		sbi.append("? , "); // 3 - nome
		sbi.append("TP_ENDERECO");
		sbi.append("( ");  // INÍCIO PARÊNTESIS TP_ENDERECO
		sbi.append("? , "); // 4 - logradouro
		sbi.append("? , "); // 5 - numero
		sbi.append("? , "); // 6 - complemento
		sbi.append("? , "); // 7 - bairro
		sbi.append("? , "); // 8 - cidade
		sbi.append("? , "); // 9 - Estado
		sbi.append("? , "); // 10 - cep
		sbi.append("? ");   // 11 - país
		sbi.append(" ), ");   //FIM PARÊNTESIS TP_ENDERECO
		sbi.append("? ,");    // 12 - sexo
		sbi.append("TELEFONE_ARRAY");
		sbi.append("( "); //INÍCIO PARÊNTESIS TELEFONE_ARRAY
		sbi.append("? , "); // 13 - fixo
		sbi.append("? ");   // 14 - celular
		sbi.append("), "); //FIM PARÊNTESIS TELEFONE_ARRAY
		sbi.append("?, "); //  15 - foto
		sbi.append("seq_idPaciente.NEXTVAL, "); //código paciente 
		sbi.append("? "); // 16 - convênio
		sbi.append(")"); //FIM PARÊNTESIS VALUES
		
		int i = 1;
		
		try {
			conexao = FabricaDeConexoes.getConnection();

			stmt = conexao.prepareStatement(sbi.toString());
			
			stmt.setString(i++, paciente.getCpf());
			stmt.setString(i++, paciente.getEstadoCivil());
			stmt.setString(i++, paciente.getNome());
			stmt.setString(i++, paciente.getEndereco().getLogradouro());
			stmt.setInt(i++, paciente.getEndereco().getNumero());
			stmt.setString(i++, paciente.getEndereco().getComplemento());
			stmt.setString(i++, paciente.getEndereco().getBairro());
			stmt.setString(i++, paciente.getEndereco().getCidade());
			stmt.setString(i++, paciente.getEndereco().getEstado());
			stmt.setString(i++, paciente.getEndereco().getCep());
			stmt.setString(i++, "Brasil");
			stmt.setString(i++, paciente.getSexo());
			stmt.setString(i++, paciente.getTelefone().getNumero()); //verificar a inserção de mais de um número de telefones
			stmt.setNull(i++, java.sql.Types.VARCHAR); //fixo
			stmt.setNull(i++, java.sql.Types.BLOB); //foto
			stmt.setString(i++, paciente.getConvenio());

			stmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				this.inserirImagem(paciente.getFoto(), paciente.getCpf());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void inserirImagem(InputStream foto, String cpf){
		Connection conexao = null;
		PreparedStatement stmt = null;

		try {
			conexao = FabricaDeConexoes.getConnection();
			StringBuffer sbi = new StringBuffer();
			
			sbi.append("INSERT INTO TB_PACIENTE (foto) VALUES (?) WHERE cpf = ?");
			
			stmt = conexao.prepareStatement(sbi.toString());
			stmt.setBinaryStream(1, foto);
			stmt.setString(2, cpf);
			stmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public InputStream consultarImagem(int id){

		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		InputStream blob = null;

		try {
			conexao = FabricaDeConexoes.getConnection();
			stmt = conexao.prepareStatement("SELECT foto FROM foto WHERE id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while(rs.next()){
				blob =  rs.getBinaryStream("foto");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return blob;
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
	
	/*public void inserirFoto(InputStream data){
		
		Connection conexao = null;
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionFactory.getConnection();
			stmt = conexao.prepareStatement("INSERT INTO foto(id, foto) VALUES (?, ?)");

			//LEMBRAR DE TIRAR ESSE ID
			
			stmt.setInt(1, 1);
			stmt.setBinaryStream(2, data);
			stmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.consultarImagem(1);
	}*/
}
