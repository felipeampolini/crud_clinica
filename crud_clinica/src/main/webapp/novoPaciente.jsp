<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Novo paciente</title>
</head>
<body>
	<div class="container col-md-4">
		<h1>Adicionar novo paciente</h1>
		<form name="fmPaciente" action="insertP">
			<div class="form-group">
				<label for="fmNome" class="form-label">Nome Completo</label>
				<input required type="text" class="form-control" id="fmNome" name="nome">
				<div class="invalid-feedback">
			      Por favor, preencha o nome completo do paciente acima!
			    </div>
			</div>
			<div class="form-group">
				<label for="fmSexo" class="form-label">Sexo</label>
				<select id="fmSexo" class="form-select" name="sexo">
					<option selected>Selecione</option>
					<option value="M">Masculino</option>
					<option value="F">Feminino</option>
					<option value="O">Outro</option>
				</select>
			</div>
			<div class="form-group">
				<label for="fmDataNascimento" class="form-label">Data nascimento</label>
				<input type="date" class="form-control" id="fmDataNascimento" name="data-nascimento">
			</div>
			<div class="form-group">
				<label for="fmTelefone" class="form-label">Telefone</label>
				<input type="text" class="form-control" id="fmTelefone" name="telefone">
			</div>
			<div class="form-group">
				<label for="fmCPF" class="form-label">CPF</label>
				<input type="text" class="form-control" id="fmCPF" name="cpf">
			</div>
			<a class="btn btn-secondary mt-2" href="pacientes">Voltar</a>
			<input type="button" class="btn btn-primary mt-2" value="Salvar" onclick="validarNovoPaciente()">
		</form>
	</div>
	<script src="scripts/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   	<script src="scripts/main.js" type="text/javascript"></script> 
</body>
</html>