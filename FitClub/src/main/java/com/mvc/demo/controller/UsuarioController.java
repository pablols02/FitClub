package com.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.demo.dto.ClaseDTO;
import com.mvc.demo.dto.RolDTO;
import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.service.IServiceClase;
import com.mvc.demo.service.IServiceRol;
import com.mvc.demo.service.IServiceUsuario;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private IServiceUsuario usuarioService;
	
	@Autowired
	private IServiceRol rolService;
	
	@Autowired
	private IServiceClase claseService;
	
	@GetMapping("/perfil")
    public String verUsuario(Model model) {
        UsuarioDTO usuarioLog = usuarioService.obtenerUsuarioPorId(Globales.idLogeado);
        List<RolDTO> roles = rolService.listarTodosLosRoles();
        List<ClaseDTO> clases = claseService.obtenerClasesPorUsuarioId(usuarioLog.getIdUsuario());
        
        model.addAttribute("usuarioLog", usuarioLog);
        model.addAttribute("roles", roles);
        model.addAttribute("clases", clases);
        
        return "usuario/perfil";
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

	    
	    // Obtener el usuario existente para recuperar su rol actual
	    UsuarioDTO usuarioExistente = usuarioService.obtenerUsuarioPorId(idUsuario);
	    RolDTO rolActual = usuarioExistente.getRol();
	    usuarioActualizado.setRol(rolActual);

	    // Obtener la contraseña actual del usuario
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

	    return "redirect:/usuario/perfil";
	}
	
	
}
