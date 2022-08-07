package cl.talentoDigital.vo;

public class GenericVO {

	
	String mensaje;
	String codigo;
	
	//constructor con parametros
	public GenericVO() {
		
	}
 
	//constructor con parametros
	public GenericVO(String mensaje, String codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	//getters y setters
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
