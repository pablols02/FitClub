package com.mvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.exception.MiExcepcion;
import com.mvc.demo.service.IServiceUsuario;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InicioController {

	@Autowired
	private IServiceUsuario usuarioService;
	
	@GetMapping(value = {"","/","/index"})
	public String verIndice() {
		return "inicio/inicio";
	}
	
	@GetMapping("/login")
	public String verLogin() {
		return "login/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
	    Globales.idLogeado = null;
	    return "redirect:/index";
	}
	
	@PostMapping("/inicio")
	public String login(Model model, HttpServletRequest request) {
	    String forward = "";
	    String idUsuarioLog = request.getParameter("idUsuario");
	    String passwdLog = request.getParameter("passwd");
	    UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(idUsuarioLog);
	    if (usuarioDTO != null && idUsuarioLog.equals(usuarioDTO.getIdUsuario()) && passwdLog.equals(usuarioDTO.getPasswd())) {
	        Globales.idLogeado = usuarioDTO.getIdUsuario();
	        model.addAttribute("usuarioLog", usuarioDTO);
	        forward = "inicio/inicio";
	    } else {
	        String mensaje = "El usuario o la contraseña es incorrecto";
	        model.addAttribute("mensaje", mensaje);
	        forward = "login/login";
	    }
	    return forward;
	}
	
	
	@GetMapping("/indice")
	public String inicio(Model model) {
	    String idUsuarioLog = Globales.idLogeado;
	    if (idUsuarioLog != null && !idUsuarioLog.isEmpty()) {
	        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(idUsuarioLog);
	        model.addAttribute("usuarioLog", usuarioDTO);
	    } else {
	        model.addAttribute("usuarioLog", null);
	    }
	    return "inicio/inicio";
	}
	
	
	@PostMapping("/registro")
	public String registro(Model model, HttpServletRequest request) {
		String forward = "";
		try {
			String idUsuario = request.getParameter("idUsuario");
			String passwd = request.getParameter("passwd");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String dni = request.getParameter("dni");
			String email = request.getParameter("email");
			
			UsuarioDTO usuarioDTO = new UsuarioDTO(idUsuario,passwd,nombre,apellidos,dni,email);
			usuarioService.guardarUsuario(usuarioDTO);
			
			String mensaje = "Tu usuario ha sido creado correctamente";
			model.addAttribute("mensaje",mensaje);
	        forward = "login/login";
		} catch (MiExcepcion e) {
			forward = "error/error";
		}
		return forward;
	}
	
	
}
