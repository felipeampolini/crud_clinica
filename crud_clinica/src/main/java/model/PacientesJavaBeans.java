package model;

public class PacientesJavaBeans {
	private String pac_id;
	private String pac_nome;
	private String pac_sexo;
	private String pac_datanascimento;
	private String pac_telefone;
	private String pac_cpf;
	
	public PacientesJavaBeans() {
		super();
	}

	public PacientesJavaBeans(String pac_id, String pac_nome, String pac_sexo, String pac_datanascimento, String pac_telefone,
			String pac_cpf) {
		super();
		this.pac_id = pac_id;
		this.pac_nome = pac_nome;
		this.pac_sexo = pac_sexo;
		this.pac_datanascimento = pac_datanascimento;
		this.pac_telefone = pac_telefone;
		this.pac_cpf = pac_cpf;
	}

	public String getPac_id() {
		return pac_id;
	}
	
	public void setPac_id(String pac_id) {
		this.pac_id = pac_id;
	}
	
	public String getPac_nome() {
		return pac_nome;
	}
	
	public void setPac_nome(String pac_nome) {
		this.pac_nome = pac_nome;
	}
	
	public String getPac_sexo() {
		return pac_sexo;
	}
	
	public void setPac_sexo(String pac_sexo) {
		this.pac_sexo = pac_sexo;
	}
	
	public String getPac_datanascimento() {
		return pac_datanascimento;
	}
	
	public void setPac_datanascimento(String pac_datanascimento) {
		this.pac_datanascimento = pac_datanascimento;
	}
	
	public String getPac_telefone() {
		return pac_telefone;
	}
	
	public void setPac_telefone(String pac_telefone) {
		this.pac_telefone = pac_telefone;
	}
	
	public String getPac_cpf() {
		return pac_cpf;
	}
	
	public void setPac_cpf(String pac_cpf) {
		this.pac_cpf = pac_cpf;
	}
	
}
