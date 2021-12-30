package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PacientesDAO {
	BaseDAO baseDAO = new BaseDAO();
		
	//CREATE
	public void inserirPaciente(PacientesJavaBeans paciente) {
		String create = "INSERT INTO pacientes (pac_nome, pac_sexo, pac_datanascimento, pac_telefone, pac_cpf)" +
				" VALUES(?, ?, ?, ?, ?)";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(create);
			
			//troco os ? pelos dados que desejo inserir
			if(paciente.getPac_datanascimento() == "")
				paciente.setPac_datanascimento("0000-00-00");
			
			pst.setString(1, paciente.getPac_nome());
			pst.setString(2, paciente.getPac_sexo());
			pst.setString(3, paciente.getPac_datanascimento());
			pst.setString(4, paciente.getPac_telefone());
			pst.setString(5, paciente.getPac_cpf());
			
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//READ
	public ArrayList<PacientesJavaBeans> listarPacientes(){
		ArrayList<PacientesJavaBeans> pacientes = new ArrayList<>();
		String read = "SELECT * FROM pacientes";
		
		try {
			Connection con = baseDAO.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String pac_id = rs.getString(1);
				String pac_nome = rs.getString(2);
				String pac_sexo = rs.getString(3);
				String pac_datanascimento = formatarDataBR(rs.getString(4));
				String pac_telefone = rs.getString(5);
				String pac_cpf = rs.getString(6);
				
				pacientes.add(new PacientesJavaBeans(pac_id, pac_nome, pac_sexo, pac_datanascimento, pac_telefone, pac_cpf));
			}
			
			con.close();
			return pacientes;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//UPDATE
	public void selecionarPaciente(PacientesJavaBeans paciente) {
		String read2 = "SELECT * FROM pacientes WHERE pac_id = ?";
		
		try {
			Connection con = baseDAO.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, paciente.getPac_id());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(2));
				paciente.setPac_id(rs.getString(1));
				paciente.setPac_nome(rs.getString(2));
				paciente.setPac_sexo(rs.getString(3));
				paciente.setPac_datanascimento(rs.getString(4));
				paciente.setPac_telefone(rs.getString(5));
				paciente.setPac_cpf(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarPaciente(PacientesJavaBeans paciente) {
		String update = "UPDATE pacientes set pac_nome=?, pac_sexo=?, pac_datanascimento=?, pac_telefone=?, pac_cpf=?" +
				" WHERE pac_id=?";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(update);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, paciente.getPac_nome());
			pst.setString(2, paciente.getPac_sexo());
			pst.setString(3, paciente.getPac_datanascimento());
			pst.setString(4, paciente.getPac_telefone());
			pst.setString(5, paciente.getPac_cpf());
			pst.setString(6, paciente.getPac_id());
			
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//DELETE
	public void deletarPaciente(PacientesJavaBeans paciente) {
		String delete = "DELETE FROM pacientes WHERE pac_id=?";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(delete);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, paciente.getPac_id());
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Funcoes auxiliares
		
	private String formatarDataBR(String data) throws ParseException {
		return (new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(data)));
	}
}
