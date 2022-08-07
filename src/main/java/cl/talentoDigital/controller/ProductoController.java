package cl.talentoDigital.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.talentoDigital.model.Producto;
import cl.talentoDigital.service.IProductoService;
import cl.talentoDigital.vo.ProductoVO;



@Controller       //no olvidar indicar que es una capa controller
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	IProductoService prodSer;
	
	@GetMapping({ "/", "/inicio" })    // es lo mismo que request mapping, me va a llavar a la pagina home en donde inicia el programa
	public String home(Model model) {
		model.addAttribute("VO",prodSer.getAllProductos());
		return "home";  //manda a la pagina home.jsp
	}
	
	//abre la pagina de editar y luego envia al inicio con el producto editado
	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer id, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			respuestaServicio = prodSer.findById(id);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("miProducto", respuestaServicio.getProductos().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en ProductoController ", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = prodSer.getAllProductos();
		return new ModelAndView("redirect:/inicio");
	}

	
	// Llama al método del servicio que se encarga de actualizar los datos del
	 //producto en base de datos si esta bien redirigue al inicio, si esta mal redireige al formulario editar
	
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = prodSer.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/inicio");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}
	
	//envia al formulario agregar producto
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";  //manda a la pagina agregar.jsp
	}

	
	  //Llama al método del servicio que se encarga de crear los datos del producto en la BD y
	//redirecciona al inicio si esta bien o al agregarform, si no se logra el agregar
	 
	 
	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = prodSer.add(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/inicio");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	
	 // Llama al método del servicio que se encarga de eliminar los datos del producto en la BD
	//y luego te envia al home
	
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String id, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo eliminar el producto, intente nuevamente.");
		try {
			Producto eliminado = new Producto();
			eliminado.setId(Integer.parseInt(id));
			respuestaServicio = prodSer.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/inicio");
		} catch (Exception e) {
			log.error("Error en ProductoController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = prodSer.getAllProductos();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/inicio");
	}
	
	// va al metodo para buscar por nombre del producto y envia al home
	@PostMapping("/buscar")
	public String agregarSubmit(Model model, @RequestParam String productoBuscado) {
		System.out.println(productoBuscado);
		ProductoVO respuestaServicio = prodSer.findByNombre(productoBuscado);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", respuestaServicio);
		return "home";   //va a la pagina home.jsp
	}
}
