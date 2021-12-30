package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PacientesDAO;
import model.PacientesJavaBeans;

@WebServlet(urlPatterns = {"/PacientesController", "/pacientes", "/insertP", "/selectP", "/updateP", "/deleteP"})
public class PacientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PacientesDAO pacienteDAO = new PacientesDAO();
	PacientesJavaBeans pacienteJavaBeans = new PacientesJavaBeans();
       
    public PacientesController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/pacientes")) {
			buscarPacientes(request, response);
		}else if(action.equals("/insertP")) {
			novoPaciente(request, response);
		}else if(action.equals("/selectP")) {
			listarPaciente(request, response);
		}else if(action.equals("/updateP")) {
			editarPaciente(request, response);
		}else  if(action.equals("/deleteP")) {
			deletarPaciente(request, response);
		}else{
			response.sendRedirect("index.html");
		}
	}
	
	//buscar os pacientes
	protected void buscarPacientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//busca lista de pacientes do DAO
		ArrayList<PacientesJavaBeans> lista = pacienteDAO.listarPacientes();
		
		//Envio a lista de pacientes
		request.setAttribute("pacientes", lista);
				
		RequestDispatcher rd = request.getRequestDispatcher("pacientes.jsp");
		rd.forward(request, response);
	}

	//adicionar um novo paciente CREATE
	protected void novoPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Seto as variaveis dentro do DAO usando os setters
		pacienteJavaBeans.setPac_nome(request.getParameter("nome"));
		pacienteJavaBeans.setPac_sexo(request.getParameter("sexo"));
		pacienteJavaBeans.setPac_datanascimento(request.getParameter("data-nascimento"));
		pacienteJavaBeans.setPac_telefone(request.getParameter("telefone"));
		pacienteJavaBeans.setPac_cpf(request.getParameter("cpf"));
		
		//inserir novo paciente
		pacienteDAO.inserirPaciente(pacienteJavaBeans);
		
		response.sendRedirect("pacientes");
	}
	
	//Editar paciente
	protected void listarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pac_id = request.getParameter("pac_id");
		pacienteJavaBeans.setPac_id(pac_id);
		pacienteDAO.selecionarPaciente(pacienteJavaBeans);	
		
		request.setAttribute("pac_id", pacienteJavaBeans.getPac_id());
		request.setAttribute("nome", pacienteJavaBeans.getPac_nome());
		request.setAttribute("sexo", pacienteJavaBeans.getPac_sexo());
		request.setAttribute("data-nascimento", pacienteJavaBeans.getPac_datanascimento());
		request.setAttribute("telefone", pacienteJavaBeans.getPac_telefone());
		request.setAttribute("cpf", pacienteJavaBeans.getPac_cpf());
		
		RequestDispatcher rd = request.getRequestDispatcher("EditarPaciente.jsp");
		rd.forward(request, response);
	}
	
	protected void editarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Seto as variaveis dentro do DAO usando os setters
		pacienteJavaBeans.setPac_id(request.getParameter("pac_id"));
		pacienteJavaBeans.setPac_nome(request.getParameter("nome"));
		pacienteJavaBeans.setPac_sexo(request.getParameter("sexo"));
		pacienteJavaBeans.setPac_datanascimento(request.getParameter("data-nascimento"));
		pacienteJavaBeans.setPac_telefone(request.getParameter("telefone"));
		pacienteJavaBeans.setPac_cpf(request.getParameter("cpf"));
		
		//inserir novo paciente
		pacienteDAO.alterarPaciente(pacienteJavaBeans);
		
		response.sendRedirect("pacientes");
	}
	
	//Deletar paciente
	protected void deletarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pac_id = request.getParameter("pac_id");
		pacienteJavaBeans.setPac_id(pac_id);
		
		//deletar paciente
		pacienteDAO.deletarPaciente(pacienteJavaBeans);
		
		response.sendRedirect("pacientes");
	}
}
