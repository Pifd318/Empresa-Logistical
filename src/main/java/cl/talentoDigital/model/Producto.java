package cl.talentoDigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SQ_PRODUCTO", initialValue=1, allocationSize=1,sequenceName ="SQ_PRODUCTO") //para generar una secuencia
public class Producto {  //recuerda que tiene que ser en singular

	
	@Id    //con esta anotacion le indico que esta es mi clave de la tabla
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SQ_PRODUCTO")
	private Integer idProducto;
	private String codigo;
	private String nombre;
	private String precio;
	private Integer stock;
	
	//constructor sin parametros
	public Producto() {
		
	}
     //constructor con parametros
	public Producto(Integer id, String codigo, String nombre, String precio, Integer stock) {
		super();
		this.idProducto = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	//getters y setters
	public Integer getId() {
		return idProducto;
	}
	public void setId(Integer id) {
		this.idProducto = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
  	