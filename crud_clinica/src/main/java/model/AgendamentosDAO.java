package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;

public class AgendamentosDAO {
	BaseDAO baseDAO = new BaseDAO();
		
	//CREATE
	public void inserirAgendamento(AgendamentosJavaBeans agendamento) {
		String create = "INSERT INTO agendamentos (age_paciente_id, age_datahorainicio, age_datahorafim, age_valor, age_pago)" +
				" VALUES(?, ?, ?, ?, ?)";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(create);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, agendamento.getAge_paciente_id());
			pst.setString(2, agendamento.getAge_datahorainicio());
			pst.setString(3, agendamento.getAge_datahorafim());
			pst.setString(4, agendamento.getAge_valor());
			pst.setString(5, agendamento.getAge_pago());
			
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//READ
	public ArrayList<AgendamentosJavaBeans> listarAgendamentos(){
		ArrayList<AgendamentosJavaBeans> agendamentos = new ArrayList<>();
		String read = "SELECT age_id, pac_nome, age_datahorainicio, age_datahorafim, "+
				" age_valor, age_pago FROM agendamentos LEFT JOIN pacientes ON pac_id = age_paciente_id";
		
		try {
			Connection con = baseDAO.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String age_id = rs.getString(1);
				String age_paciente_id = rs.getString(2);
				String age_datahorainicio = formatarDataBR(rs.getString(3));
				String age_datahorafim = formatarDataBR(rs.getString(4));
				String age_valor = "R$"+rs.getString(5);
				String age_pago = "Pendente";
				//Defino o pagamento como Pago ou Pendente
				if(rs.getString(6).equals("1"))
					age_pago = "Pago";
				
				agendamentos.add(new AgendamentosJavaBeans(age_id, age_paciente_id, age_datahorainicio, age_datahorafim, age_valor, age_pago));
			}
			
			con.close();
			return agendamentos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//UPDATE
	public void selecionarAgendamento(AgendamentosJavaBeans agendamento) {
		String read2 = "SELECT * FROM agendamentos WHERE age_id = ?";
		
		try {
			Connection con = baseDAO.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, agendamento.getAge_id());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {							
				agendamento.setAge_paciente_id(rs.getString(2));
				agendamento.setAge_datahorainicio(formatarDataRFC3339(rs.getString(3)));
				agendamento.setAge_datahorafim(formatarDataRFC3339(rs.getString(4)));
				agendamento.setAge_valor(rs.getString(5));
				agendamento.setAge_pago(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarAgendamento(AgendamentosJavaBeans agendamento) {
		String update = "UPDATE agendamentos set age_paciente_id=?, age_datahorainicio=?, age_datahorafim=?, age_valor=?, age_pago=?" +
				" WHERE age_id=?";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(update);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, agendamento.getAge_paciente_id());
			pst.setString(2, agendamento.getAge_datahorainicio());
			pst.setString(3, agendamento.getAge_datahorafim());
			pst.setString(4, agendamento.getAge_valor());
			pst.setString(5, agendamento.getAge_pago());
			pst.setString(6, agendamento.getAge_id());
			
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//DELETE
	public void deletarAgendamento(AgendamentosJavaBeans agendamento) {
		String delete = "DELETE FROM agendamentos WHERE age_id=?";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(delete);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, agendamento.getAge_id());
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//pagar agendamento
	public void pagarAgendamento(AgendamentosJavaBeans agendamento) {
		String update = "UPDATE agendamentos set age_pago=?" +
				" WHERE age_id=?";
		
		try {
			//fazer conexao
			Connection con = baseDAO.conectar();
			
			//Prepara a query para executar no db
			PreparedStatement pst = con.prepareStatement(update);
			
			//troco os ? pelos dados que desejo inserir
			pst.setString(1, agendamento.getAge_pago());
			pst.setString(2, agendamento.getAge_id());
			
			//executar a query
			pst.executeUpdate();
			
			//fecha a conexao com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Funcoes auxiliares
	private String formatarDataRFC3339(String data) {
		String[] split = data.split(" ");
		return split[0]+"T"+split[1];	
	}
	
	private String formatarDataBR(String data) throws ParseException {
		return (new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data)));
	}
}
