package com.mvc.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.demo.dto.ClaseDTO;
import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.service.IServiceClase;
import com.mvc.demo.service.IServiceUsuario;

@Controller
@RequestMapping(value = "/clases")
public class ClasesController {

	@Autowired
	private IServiceUsuario usuarioService;
	
	@Autowired
	private IServiceClase claseService;
	
	
	@GetMapping("/inicio")
    public String verClases(Model model) {
		UsuarioDTO usuarioLog = null;
		if (Globales.idLogeado != null) {
			usuarioLog = usuarioService.obtenerUsuarioPorId(Globales.idLogeado);
		}
	    List<ClaseDTO> clases = claseService.listarTodosLasClases();

	    // Definir listas de horas y días
	    List<String> horas = Arrays.asList("09:00", "11:00", "17:00", "20:00");
	    List<String> diasSemana = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
	    
	    String fechaSemana = obtenerFecha();
        
        model.addAttribute("fechaSemana", fechaSemana);
	    model.addAttribute("usuarioLog", usuarioLog);
	    model.addAttribute("clases", clases);
	    model.addAttribute("horas", horas);
	    model.addAttribute("diasSemana", diasSemana);

	    return "clases/inicio";
    }
	
	@GetMapping("/apuntarse")
    public String apuntarseAClase(@RequestParam("idClase") Integer idClase) {
        String idLogeado = Globales.idLogeado;
        try {
        	claseService.apuntarMiembroAClase(idLogeado, idClase);
        } catch (Exception e) {
			// TODO: handle exception
		}
        
        return "redirect:/clases/inicio";
        
    }
	
	private String obtenerFecha() {
		LocalDate hoy = LocalDate.now();
        // Encontrar el lunes de la semana actual
        LocalDate lunes = hoy.with(java.time.DayOfWeek.MONDAY);
        // Encontrar el sábado de la semana actual
        LocalDate sabado = lunes.plusDays(5);

        // Formatear las fechas
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("es-ES"));
        String lunesStr = lunes.format(formateador);
        String sabadoStr = sabado.format(formateador);

        // Crear y devolver el rango de fechas
        return lunesStr + " - " + sabadoStr;
    }
	
	
}
