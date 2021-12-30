package model;

public class AgendamentosJavaBeans {
	private String age_id;
	private String age_paciente_id;
	private String age_datahorainicio;
	private String age_datahorafim;
	private String age_valor;
	private String age_pago;
	
	public AgendamentosJavaBeans() {
		super();
	}

	public AgendamentosJavaBeans(String age_id, String age_paciente_id, String age_datahorainicio,
			String age_datahorafim, String age_valor, String age_pago) {
		super();
		this.age_id = age_id;
		this.age_paciente_id = age_paciente_id;
		this.age_datahorainicio = age_datahorainicio;
		this.age_datahorafim = age_datahorafim;
		this.age_valor = age_valor;
		this.age_pago = age_pago;
	}

	public String getAge_id() {
		return age_id;
	}

	public void setAge_id(String age_id) {
		this.age_id = age_id;
	}

	public String getAge_paciente_id() {
		return age_paciente_id;
	}

	public void setAge_paciente_id(String age_paciente_id) {
		this.age_paciente_id = age_paciente_id;
	}

	public String getAge_datahorainicio() {
		return age_datahorainicio;
	}

	public void setAge_datahorainicio(String age_datahorainicio) {
		this.age_datahorainicio = age_datahorainicio;
	}

	public String getAge_datahorafim() {
		return age_datahorafim;
	}

	public void setAge_datahorafim(String age_datahorafim) {
		this.age_datahorafim = age_datahorafim;
	}

	public String getAge_valor() {
		return age_valor;
	}

	public void setAge_valor(String age_valor) {
		this.age_valor = age_valor;
	}

	public String getAge_pago() {
		return age_pago;
	}

	public void setAge_pago(String age_pago) {
		this.age_pago = age_pago;
	}
	
}
