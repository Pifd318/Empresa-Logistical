package cl.talentoDigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.talentoDigital.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Integer> {
	
	// esta query es para buscar un producto, por nombre, en donde ?1 es lo que escribe el usuario por teclado
	@Query("FROM Producto WHERE upper(nombre) like upper(?1)")
	
	//es la lista de todos los productos por nombre
	public List<Producto> findByNombre(String nombre);

}
