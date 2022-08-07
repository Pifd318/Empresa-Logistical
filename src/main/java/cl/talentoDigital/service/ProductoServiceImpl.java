package cl.talentoDigital.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //recuerda colocar el de spring


import cl.talentoDigital.model.Producto;
import cl.talentoDigital.repository.IProductoRepository;
import cl.talentoDigital.vo.ProductoVO;

@Service     //anotacion, para indicar que es un service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired                            //para inyectar la dependencia
	IProductoRepository prodRepo;  //esto es el repositorio
	
	ProductoVO respuesta;                //esta es una variable que responde un  ProductoVO 

	
	//implementacion del metodo para obtener todos los productos
	@Override
	@Transactional(readOnly = true)    //indica solo lectura
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "101");
	
		try {
			respuesta.setProductos((ArrayList<Producto>) prodRepo.findAll());
			respuesta.setMensaje("Se ha/n encontrado " + respuesta.getProductos().size() + " registro/s");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	
	//implementacion del metodo para obtener los productos por nombre
	@Override
	@Transactional(readOnly = true)    //indica solo lectura
	public ProductoVO findByNombre(String nombre) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "102");
		try {
			ArrayList<Producto> productos = (ArrayList<Producto>) prodRepo.findByNombre(nombre);
			if (productos.size() > 0) {
				respuesta.setProductos(productos);
				respuesta.setMensaje("Producto encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Productos no encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

     //implementacion del metodo para agregar productos
	@Override
	@Transactional                  //indica modificacion agregar
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "103");
		
		try {
			prodRepo.save(producto);
			respuesta.setMensaje("Se ha guardado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	//implementacion del metodo para modificar productos
	@Override
	@Transactional                //indica modificacion modifica
	public ProductoVO update(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "104");
		try {
			prodRepo.save(producto);
			respuesta.setMensaje("Se ha actualizado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	//implementacion del metodo para eliminar productos
	@Override
	@Transactional               //indica modificacion eliminar
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "105");
		try {
			prodRepo.delete(producto);
			respuesta.setMensaje("Se ha eliminado correctamente el producto "+producto.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	
	//implementacion del metodo para obtener producto por el id
	@Override
	@Transactional(readOnly = true)   //indica solo lectura
	public ProductoVO findById(Integer id) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "106");
		try {
			Producto producto = prodRepo.findById(id).get();
			respuesta.getProductos().add(producto);
			respuesta.setMensaje("Producto encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}
