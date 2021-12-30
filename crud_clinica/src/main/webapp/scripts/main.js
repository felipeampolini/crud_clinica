

//PACIENTES
function validarNovoPaciente(){
	if($('#fmNome').val() == ""){ //bloqueia
		$('#fmNome').addClass("is-invalid");	
		return false;
	}else // permite passagem
		document.forms["fmPaciente"].submit();		
}

$('#fmNome').change(function(){
	if($('#fmNome').hasClass('is-invalid') && $('#fmNome').val() != ""){
		$('#fmNome').removeClass("is-invalid");
		$('#fmNome').addClass("is-valid");
	}
	
	if($('#fmNome').hasClass('is-valid') && $('#fmNome').val() == ""){
		$('#fmNome').addClass("is-invalid");
		$('#fmNome').removeClass("is-valid");
	}
});

function confirmarExclusaoPaciente(pac_id){
	let res = confirm("Tem certeza que deseja apagar este contato?");
	if(res === true)
		window.location.href = "deleteP?pac_id=" + pac_id;	
}

//AGENDAMENTOS

function validarNovoAgendamento(){

	var valido = true;
	$('#formAgendamento input, #formAgendamento select').each(function(){
		if($(this).val() == ""){
			valido = false;
			$(this).addClass("is-invalid");
		}
	});
	
	if(valido)
		document.forms["fmAgendamento"].submit();
}

$('#formAgendamento input, #formAgendamento select').change(function(){
	
	if($(this).hasClass("is-invalid") && $(this).val() != ""){
		$(this).addClass("is-valid");
		$(this).removeClass("is-invalid");
	}
	
	if($(this).hasClass("is-valid") && $(this).val() == ""){
		$(this).addClass("is-invalid");
		$(this).removeClass("is-valid");
	}
});

function confirmarExclusaoAgendamento(age_id){
	let res = confirm("Tem certeza que deseja apagar este agendamento?");
	if(res === true)
		window.location.href = "deleteA?age_id=" + age_id;	
}