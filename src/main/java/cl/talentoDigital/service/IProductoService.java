package cl.talentoDigital.service;

import cl.talentoDigital.model.Producto;
import cl.talentoDigital.vo.ProductoVO;

public interface IProductoService {

	
	//declaracion de metodos
	
	public ProductoVO getAllProductos();  //agregar a la lista de productos y se guarda en productovo y producto
	public ProductoVO findByNombre(String nombre);  //para dar mensajes
	public ProductoVO add(Producto producto);       //agregar producto
	public ProductoVO update(Producto producto);    //modificar producto
	public ProductoVO delete(Producto producto);    //eliminar producto
	public ProductoVO findById(Integer id);       //buscar producto por id

	
	
}
