package cl.talentoDigital.vo;

import java.util.List;

import cl.talentoDigital.model.Producto;

public class ProductoVO extends GenericVO{

	
	List<Producto> productos;
	
	//constructor sin parametro
	public ProductoVO() {
		
	}

	//constructor con parametro y agregamos los atributos de GenericVO
	public ProductoVO(List<Producto> productos, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	@Override
	public String toString() {
		return "ProductoVO [productos=" + productos + "]";
	}

	

	
	

	
	
	
}
