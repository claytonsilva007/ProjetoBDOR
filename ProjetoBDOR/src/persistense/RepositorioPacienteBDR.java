package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.FabricaDeConexoes;
import classesbasicas.Endereco;
import classesbasicas.Paciente;
import classesbasicas.Pessoa;
import classesbasicas.Telefone;

public class RepositorioPacienteBDR implements InterfacePaciente{

	public void cadastrarPaciente(Paciente paciente) {

		Connection conexao = null;
		PreparedStatement stmt = null;
		StringBuffer sbi = new StringBuffer();

		sbi.append("INSERT INTO TB_PACIENTE");
		sbi.append("( "); //IN�CIO PAR�NTESIS INSERT
		sbi.append("CPF,");
		sbi.append("ESTADO_CIVIL,");
		sbi.append("NOME,");
		sbi.append("ENDERECO,");
		sbi.append("SEXO,");
		sbi.append("FONE,");
		sbi.append("FOTO,");
		sbi.append("COD_PACIENTE,");
		sbi.append("CONVENIO");
		sbi.append(" ) "); //FIM PAR�NTESIS INSERT
		sbi.append("VALUES");
		sbi.append("( "); // IN�CIO PAR�NTESIS VALUES
		sbi.append("? , "); // 1 - cpf 
		sbi.append("? , "); // 2 - estado civil
		sbi.append("? , "); // 3 - nome
		sbi.append("TP_ENDERECO");
		sbi.append("( ");  // IN�CIO PAR�NTESIS TP_ENDERECO
		sbi.append("? , "); // 4 - logradouro
		sbi.append("? , "); // 5 - numero
		sbi.append("? , "); // 6 - complemento
		sbi.append("? , "); // 7 - bairro
		sbi.append("? , "); // 8 - cidade
		sbi.append("? , "); // 9 - Estado
		sbi.append("? , "); // 10 - cep
		sbi.append("? ");   // 11 - pa�s
		sbi.append(" ), ");   //FIM PAR�NTESIS TP_ENDERECO
		sbi.append("? ,");    // 12 - sexo
		sbi.append("TELEFONE_ARRAY");
		sbi.append("( "); //IN�CIO PAR�NTESIS TELEFONE_ARRAY
		sbi.append("? , "); // 13 - fixo
		sbi.append("? ");   // 14 - celular
		sbi.append("), "); //FIM PAR�NTESIS TELEFONE_ARRAY
		sbi.append("?, "); //  15 - foto
		sbi.append("seq_idPaciente.NEXTVAL, "); //c�digo paciente 
		sbi.append("? "); // 16 - conv�nio
		sbi.append(")"); //FIM PAR�NTESIS VALUES
		
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
			stmt.setString(i++, paciente.getTelefone().getNumero()); //verificar a inser��o de mais de um n�mero de telefones
			stmt.setNull(i++, java.sql.Types.VARCHAR); //fixo
			stmt.setBinaryStream(i++, paciente.getFoto()); //foto
			stmt.setString(i++, paciente.getConvenio());

			stmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Paciente consultarPaciente(String cpf){
		Connection conexao = null;
		PreparedStatement stmt = null;
		StringBuffer sbi = new StringBuffer();
		ResultSet rs = null;
		Paciente paciente = null;
		int i = 1;

		sbi.append("SELECT ");
		sbi.append("CPF,");
		sbi.append("ESTADO_CIVIL,");
		sbi.append("NOME,");
		sbi.append("ENDERECO,");
		sbi.append("SEXO,");
		sbi.append("FONE,");
		sbi.append("FOTO,");
		sbi.append("COD_PACIENTE,");
		sbi.append("CONVENIO ");
		sbi.append("FROM ");
		sbi.append("tb_paciente ");
		sbi.append("WHERE ");
		sbi.append("cpf = ?");
		
		try {
			conexao = FabricaDeConexoes.getConnection();
			stmt = conexao.prepareStatement(sbi.toString());
			stmt.setString(i, cpf);

			paciente = new Paciente();

			rs = stmt.executeQuery();
			

			while(rs.next()){
				paciente = this.carregarPaciente(rs);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return paciente;
	}
	
	public final Paciente carregarPaciente(ResultSet rs){
		Paciente paciente = new Paciente();
		Endereco endereco = new Endereco();
		Telefone telefone = new Telefone();
		try {
			paciente.setConvenio(rs.getString("convenio"));
			paciente.setCpf(rs.getString("cpf"));
			paciente.setEstadoCivil(rs.getString("estado_civil"));
			paciente.setIdPaciente(rs.getString("cod_paciente"));
			paciente.setNome(rs.getString("nome"));
			paciente.setSexo(rs.getString("sexo"));
			paciente.setFoto(rs.getBinaryStream("foto"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}

/*
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
*/	
	
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
