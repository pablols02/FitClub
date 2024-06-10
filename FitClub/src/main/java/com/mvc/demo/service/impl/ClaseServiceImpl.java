package com.mvc.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.demo.dao.IDAOClaseMiembro;
import com.mvc.demo.dao.IDAOClases;
import com.mvc.demo.dao.IDAOMiembro;
import com.mvc.demo.dto.ClaseDTO;
import com.mvc.demo.dto.MonitorDTO;
import com.mvc.demo.dto.UsuarioDTO;
import com.mvc.demo.entity.ClaseEntity;
import com.mvc.demo.entity.ClaseMiembroEntity;
import com.mvc.demo.entity.MiembroEntity;
import com.mvc.demo.entity.MonitorEntity;
import com.mvc.demo.entity.UsuarioEntity;
import com.mvc.demo.service.IServiceClase;

@Service
public class ClaseServiceImpl implements IServiceClase {

    @Autowired
    private IDAOClases claseDAO;
    
    @Autowired
    private IDAOMiembro miembroDAO;
    
    @Autowired
    private IDAOClaseMiembro claseMiembroDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ClaseDTO> obtenerClasesPorUsuarioId(String usuarioId) {
        List<ClaseEntity> clases = claseDAO.findClasesByUsuarioId(usuarioId);
        List<ClaseDTO> clasesDTO = new ArrayList<>();
        
        for (ClaseEntity claseEntity : clases) {
            ClaseDTO claseDTO = new ClaseDTO();
            claseDTO.setIdClase(claseEntity.getIdClase());
            claseDTO.setNombre(claseEntity.getNombre());
            claseDTO.setDescripcion(claseEntity.getDescripcion());
            claseDTO.setSala(claseEntity.getSala());
            claseDTO.setDia(claseEntity.getDia());
            claseDTO.setHora(claseEntity.getHora());
            claseDTO.setDuracion(claseEntity.getDuracion());
            clasesDTO.add(claseDTO);
        }
        
        return clasesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseDTO> listarTodosLasClases() {
        List<ClaseEntity> clasesEntities = claseDAO.findAll(); // Suponiendo que tienes un DAO para las clases
        List<ClaseDTO> clasesDTO = new ArrayList<>();
        
        for (ClaseEntity claseEntity : clasesEntities) {
            ClaseDTO claseDTO = new ClaseDTO();
            claseDTO.setIdClase(claseEntity.getIdClase());
            claseDTO.setNombre(claseEntity.getNombre());
            claseDTO.setDescripcion(claseEntity.getDescripcion());
            claseDTO.setSala(claseEntity.getSala());
            claseDTO.setDia(claseEntity.getDia());
            claseDTO.setHora(claseEntity.getHora());
            claseDTO.setDuracion(claseEntity.getDuracion());
            claseDTO.setLimiteMiembros(claseEntity.getLimiteMiembros());
            
            // Obtener el monitor asociado a la clase
            MonitorEntity monitorEntity = claseEntity.getMonitor();
            MonitorDTO monitorDTO = new MonitorDTO();
            monitorDTO.setIdMonitor(monitorEntity.getIdMonitor());
            
            // Obtener los datos del usuario asociado al monitor
            UsuarioEntity usuarioEntity = monitorEntity.getUsuario();
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(usuarioEntity.getIdUsuario());
            usuarioDTO.setNombre(usuarioEntity.getNombre());
            usuarioDTO.setApellidos(usuarioEntity.getApellidos());
            usuarioDTO.setDni(usuarioEntity.getDni());
            usuarioDTO.setEmail(usuarioEntity.getEmail());
            usuarioDTO.setPasswd(usuarioEntity.getPasswd());
            
            // Puedes incluir más atributos del usuario si los necesitas
            
            monitorDTO.setUsuario(usuarioDTO);
            claseDTO.setMonitor(monitorDTO);
            
            clasesDTO.add(claseDTO);
        }
        return clasesDTO;
    }

	@Override
	@Transactional
	public void apuntarMiembroAClase(String idUsuario, Integer idClase) {
		List<MiembroEntity> miembrosEntities = miembroDAO.findAll();
		MiembroEntity miembro = null;
		for (MiembroEntity miembroEntity : miembrosEntities) {
			if(miembroEntity.getUsuario().getIdUsuario().equals(idUsuario)) {
				miembro = miembroEntity;
			}
		}
		
		ClaseMiembroEntity claseMiembro = new ClaseMiembroEntity();
		claseMiembro.setMiembro(miembro);
		claseMiembro.setClase(claseDAO.findById(idClase));
		
		claseMiembroDAO.save(claseMiembro);
		
	}
}
