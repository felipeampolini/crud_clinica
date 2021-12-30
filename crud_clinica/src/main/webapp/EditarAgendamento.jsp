<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.PacientesJavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<PacientesJavaBeans> lista = (ArrayList<PacientesJavaBeans>) request.getAttribute("pacientes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Editar agendamento</title>
</head>
<body>
	<div class="container col-md-4">
		<h1>Editar agendamento</h1>
		<form id="formAgendamento" name="fmAgendamento" action="updateA">
			<div class="form-group">
				<input hidden readonly type="text" class="form-control" id="fmId" name="age_id" value="<%out.print(request.getAttribute("age_id"));%>">
				
				<label for="fmPaciente" class="form-label">Paciente</label>
				<select required id="fmPaciente" class="form-select" name="paciente">
					<% for(int i=0; i<lista.size(); i++){ %>
		    		<option value=<%=lista.get(i).getPac_id()%>><%= lista.get(i).getPac_nome() %></option>
			    	<% } %>
				</select>
				<div class="invalid-feedback">
			      Por favor, selecione um paciente!
			    </div>
			</div>
			
			<div class="form-group">
				<label for="fmDataInicio" class="form-label">Início da consulta</label>
				<input required type="datetime-local" class="form-control" id="fmDataInicio" name="data-inicio" value="<%out.print(request.getAttribute("data-inicio"));%>">
				<div class="invalid-feedback">
			      Por favor, selecione uma data para o início da consulta!
			    </div>
			</div>
			
			<div class="form-group">
				<label for="fmDataFim" class="form-label">Fim da consulta</label>
				<input required type="datetime-local" class="form-control" id="fmDataFim" name="data-fim" value="<%out.print(request.getAttribute("data-fim"));%>">
				<div class="invalid-feedback">
			      Por favor, selecione uma data para o fim da consulta!
			    </div>
			</div>
			
			<div class="form-group">
				<label for="fmValor" class="form-label">Valor consulta</label>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">R$</span>
					</div>
					<input required type="text" class="form-control" id="fmValor" name="valor" value="<%out.print(request.getAttribute("valor"));%>">
				</div>
				<div class="invalid-feedback">
			      Por favor, preencha o valor da consulta!
			    </div>
			</div>
			
			<div class="form-group">
				<label for="fmPagamento" class="form-label">Status do pagamento</label>
				<select required id="fmPagamento" class="form-select" name="pagamento">
					<option value="" selected>selecione</option>
					<option value=1>Pago</option>
					<option value=2>Pendente</option>
				</select>
				<div class="invalid-feedback">
			      Por favor, selecione o status de pagamento!
			    </div>
			</div>
			
			<a class="btn btn-secondary mt-2" href="agendamentos">Voltar</a>
			<input id="btnSalvar" type="button" class="btn btn-primary mt-2" value="Salvar" onclick="validarNovoAgendamento()">
		</form>
	</div>
	<script src="scripts/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   	<script src="scripts/main.js" type="text/javascript"></script> 
</body>
</html>
<script>
$(document).ready(function(){	
	$('#fmPagamento').val('<%out.print(request.getAttribute("pagamento"));%>');
	$('#fmPaciente').val('<%out.print(request.getAttribute("paciente"));%>');
});

</script>