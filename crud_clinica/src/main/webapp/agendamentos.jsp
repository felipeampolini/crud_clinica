<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.AgendamentosJavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<AgendamentosJavaBeans> lista = (ArrayList<AgendamentosJavaBeans>) request.getAttribute("agendamentos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Agendamentos</title>
</head>
<body>
	<div class="container col-md-10">
		<h1>Agendamentos</h1>
		<a class="btn btn-primary mt-2 mb-2" href="novoAgendamento">Adicionar agendamento</a>
		<a class="btn btn-secondary mt-2 mb-2" href="index.html">Voltar</a>
		<table id="tbPacientes" class="table table-striped table-bordered" style="width:100%"> 
			<thead>
		        <tr>
		            <th>Paciente</th>
		            <th>Data-Hora Inicio</th>
		            <th>Data-Hora Fim</th>
		            <th>Valor</th>
		            <th>Status do pagamento</th>
		            <th>Ações</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<% for(int i=0; i<lista.size(); i++){ %>
		    		<tr>
		    			<td><%= lista.get(i).getAge_paciente_id() %></td>
		    			<td><%= lista.get(i).getAge_datahorainicio() %></td>
		    			<td><%= lista.get(i).getAge_datahorafim() %></td>
		    			<td><%= lista.get(i).getAge_valor() %></td>
		    			<td><%= lista.get(i).getAge_pago() %></td>
		    			<td style="text-align: end">
		    				<% if(lista.get(i).getAge_pago().equals("Pendente")){ %>
							<a href="pagar?age_id=<%=lista.get(i).getAge_id()%>"><i title="Pagar" class="fas fa-money-bill text-success float-right"></i></a>
							<% } %>
		    				<a href="selectA?age_id=<%=lista.get(i).getAge_id()%>"><i title="Editar" class="fas fa-edit"></i></a>
		    				<a onclick="javascript: confirmarExclusaoAgendamento(<%=lista.get(i).getAge_id()%>)"><i title="Excluir" class="fas fa-trash text-danger"></i></a>
		    			</td>    			
		    		</tr>
		    	<% } %>
		    </tbody>
		</table>
	</div>
	<script src="scripts/main.js" type="text/javascript"></script>
   	<script src="scripts/jquery-3.6.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   	<script src="scripts/main.js" type="text/javascript"></script>
   	<script src="scripts/pacientes.js" type="text/javascript"></script>
</body>
</html>