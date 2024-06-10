package com.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.demo.dto.RolDTO;
import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.service.IServiceRol;
import com.mvc.demo.service.IServiceUsuario;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private IServiceUsuario usuarioService;
	
	@Autowired
	private IServiceRol rolService;
	
	@GetMapping("/menu")
	public String verAdmin(Model model, HttpServletRequest request) {
		UsuarioDTO usuarioLog = usuarioService.obtenerUsuarioPorId(Globales.idLogeado);
		List<UsuarioDTO> usuarios = usuarioService.listarTodosLosUsuarios();
		model.addAttribute("usuarioLog", usuarioLog);
		model.addAttribute("usuarios", usuarios);
		return "admin/menu";
	}
	
	@GetMapping("/buscarUsuario")
	public String buscarUsuario(@RequestParam("idUsuario") String idUsuario, Model model) {
	    UsuarioDTO usuarioLog = usuarioService.obtenerUsuarioPorId(Globales.idLogeado);
	    UsuarioDTO usuario = usuarioService.obtenerUsuarioPorId(idUsuario);
	    String forward = "redirect:/admin/menu";
	    
	    if (usuario != null) {
	        model.addAttribute("usuarios", List.of(usuario));
	        model.addAttribute("usuarioLog", usuarioLog);
	        forward = "admin/menu";
	    }
	    
	    return forward;
	}
	
	@GetMapping("/verEditarUsuario/{idUsuario}")
	public String verEditarUsuario(@PathVariable String idUsuario, Model model) {
		UsuarioDTO usuarioLog = usuarioService.obtenerUsuarioPorId(Globales.idLogeado);
		UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(idUsuario);
		List<RolDTO> roles = rolService.listarTodosLosRoles();
		model.addAttribute("usuarioLog", usuarioLog);
		model.addAttribute("usuario", usuarioDTO);
		model.addAttribute("roles", roles);
		return "admin/editarUsuario";
	}
	
	@PostMapping("/editarUsuario")
	public String editarUsuario(HttpServletRequest request) {
	    UsuarioDTO usuarioActualizado = new UsuarioDTO();

	    String idUsuario = request.getParameter("idUsuario");
	    usuarioActualizado.setIdUsuario(idUsuario);

	    String nombre = request.getParameter("nombre");
	    usuarioActualizado.setNombre(nombre);

	    String apellidos = request.getParameter("apellidos");
	    usuarioActualizado.setApellidos(apellidos);

	    String dni = request.getParameter("dni");
	    usuarioActualizado.setDni(dni);

	    String email = request.getParameter("email");
	    usuarioActualizado.setEmail(email);

	    Integer idRol = Integer.parseInt(request.getParameter("rol"));
	    RolDTO rol = rolService.obtenerRolPorId(idRol); // Suponiendo que tienes un servicio para obtener el rol
	    usuarioActualizado.setRol(rol);

	    // Obtener la contraseña actual del usuario
	    UsuarioDTO usuarioExistente = usuarioService.obtenerUsuarioPorId(idUsuario);
	    String contraseñaActual = usuarioExistente.getPasswd();

	    // Obtener la nueva contraseña del request
	    String nuevaContraseña = request.getParameter("passwd");

	    // Si no se proporciona una nueva contraseña, mantener la actual
	    if (nuevaContraseña == null || nuevaContraseña.isEmpty()) {
	        usuarioActualizado.setPasswd(contraseñaActual);
	    } else {
	        usuarioActualizado.setPasswd(nuevaContraseña);
	    }

	    // Actualizar el usuario
	    usuarioService.actualizarUsuario(usuarioActualizado);

	    return "redirect:/admin/menu";
	}
	
	@GetMapping("/eliminarUsuario/{idUsuario}")
	public String eliminarUsuario(@PathVariable String idUsuario) {
	    String forward = "";
	    try {
	        UsuarioDTO usuarioAEliminar = usuarioService.obtenerUsuarioPorId(idUsuario);

	        // Verificar si se intenta eliminar el usuario actualmente logeado
	        if (usuarioAEliminar.getIdUsuario().equals(Globales.idLogeado)) {
	            throw new IllegalArgumentException("No se puede eliminar el usuario actualmente logeado");
	        }

	        usuarioService.eliminarUsuario(idUsuario);
	        forward = "redirect:/admin/menu";
	    } catch (Exception e) {
	        // Manejar la excepción, redirigir a una página de error o mostrar un mensaje de error.
	        System.out.println(e.getMessage());
	        forward = "error/error";
	    }
	    return forward;
	}
	
	
}
