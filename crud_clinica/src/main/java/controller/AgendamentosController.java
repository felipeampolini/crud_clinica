package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AgendamentosDAO;
import model.AgendamentosJavaBeans;
import model.PacientesDAO;
import model.PacientesJavaBeans;

@WebServlet(urlPatterns = {"/AgendamentosController", "/agendamentos", "/insertA", "/selectA", "/updateA", "/deleteA", "/novoAgendamento", "/pagar"})
public class AgendamentosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PacientesDAO pacienteDAO = new PacientesDAO();
	AgendamentosDAO agendamentoDAO = new AgendamentosDAO();
	AgendamentosJavaBeans agendamentoJavaBeans = new AgendamentosJavaBeans();
       
    public AgendamentosController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/agendamentos")) {
			buscarAgendamentos(request, response);
		}else if(action.equals("/insertA")) {
			novoAgendamento(request, response);
		}else if(action.equals("/selectA")) {
			listarAgendamento(request, response);
		}else if(action.equals("/updateA")) {
			editarAgendamento(request, response);
		}else if(action.equals("/deleteA")) {
			deletarAgendamento(request, response);
		}else if(action.equals("/novoAgendamento")) {
			carregarPacientes(request, response);
		}else if(action.equals("/pagar")) {
			pagarAgendamento(request, response);
		}else{
			response.sendRedirect("index.html");
		}
	}
	
	//buscar os agendamentos
	protected void buscarAgendamentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//busca lista de agendamentos do DAO
		ArrayList<AgendamentosJavaBeans> lista = agendamentoDAO.listarAgendamentos();
		
		//Envio a lista de agendamentos
		request.setAttribute("agendamentos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("agendamentos.jsp");
		rd.forward(request, response);
	}

	//adicionar um novo agendamento CREATE
	protected void novoAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Seto as variaveis dentro do DAO usando os setters
		agendamentoJavaBeans.setAge_paciente_id(request.getParameter("paciente"));
		agendamentoJavaBeans.setAge_datahorainicio(request.getParameter("data-inicio"));
		agendamentoJavaBeans.setAge_datahorafim(request.getParameter("data-fim"));
		agendamentoJavaBeans.setAge_valor(request.getParameter("valor"));
		agendamentoJavaBeans.setAge_pago(request.getParameter("pagamento"));
		
		//inserir novo paciente
		agendamentoDAO.inserirAgendamento(agendamentoJavaBeans);
		
		response.sendRedirect("agendamentos");
	}
	
	//Editar agendamento
	protected void listarAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age_id = request.getParameter("age_id");
		agendamentoJavaBeans.setAge_id(age_id);
		agendamentoDAO.selecionarAgendamento(agendamentoJavaBeans);	
		
		ArrayList<PacientesJavaBeans> lista = pacienteDAO.listarPacientes();
		
		//Envio a lista de pacientes
		request.setAttribute("pacientes", lista);
		
		request.setAttribute("age_id", agendamentoJavaBeans.getAge_id());
		request.setAttribute("paciente", agendamentoJavaBeans.getAge_paciente_id());
		request.setAttribute("data-inicio", agendamentoJavaBeans.getAge_datahorainicio());
		request.setAttribute("data-fim", agendamentoJavaBeans.getAge_datahorafim());
		request.setAttribute("valor", agendamentoJavaBeans.getAge_valor());
		request.setAttribute("pagamento", agendamentoJavaBeans.getAge_pago());
		//busca lista de pacientes do DAO

		
		RequestDispatcher rd = request.getRequestDispatcher("EditarAgendamento.jsp");
		rd.forward(request, response);
	}
	
	protected void editarAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Seto as variaveis dentro do DAO usando os setters
		agendamentoJavaBeans.setAge_id(request.getParameter("age_id"));
		agendamentoJavaBeans.setAge_paciente_id(request.getParameter("paciente"));
		agendamentoJavaBeans.setAge_datahorainicio(request.getParameter("data-inicio"));
		agendamentoJavaBeans.setAge_datahorafim(request.getParameter("data-fim"));
		agendamentoJavaBeans.setAge_valor(request.getParameter("valor"));
		agendamentoJavaBeans.setAge_pago(request.getParameter("pagamento"));
		
		//inserir novo paciente
		agendamentoDAO.alterarAgendamento(agendamentoJavaBeans);
		
		response.sendRedirect("agendamentos");
	}
	
	//Deletar paciente
	protected void deletarAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age_id = request.getParameter("age_id");
		agendamentoJavaBeans.setAge_id(age_id);
		
		//deletar paciente
		agendamentoDAO.deletarAgendamento(agendamentoJavaBeans);
		
		response.sendRedirect("agendamentos");
	}

	//Carregar pacientes para o select
	protected void carregarPacientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//busca lista de pacientes do DAO
		ArrayList<PacientesJavaBeans> lista = pacienteDAO.listarPacientes();
		
		//Envio a lista de pacientes
		request.setAttribute("pacientes", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("novoAgendamento.jsp");
		rd.forward(request, response);
	}
	
	protected void pagarAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Seto as variaveis dentro do DAO usando os setters
		agendamentoJavaBeans.setAge_id(request.getParameter("age_id"));
		agendamentoJavaBeans.setAge_pago("1");
		
		//inserir novo paciente
		agendamentoDAO.pagarAgendamento(agendamentoJavaBeans);
		
		response.sendRedirect("agendamentos");
	}
}
