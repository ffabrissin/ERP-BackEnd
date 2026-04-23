package com.erp.erp.Service;

import com.erp.erp.ExceptionGeneralSistema.ExceptionGeneralSistema;
import com.erp.erp.Repository.EntidadRepository;
import com.erp.erp.model.Entidad;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author piti_
 */
@Service
public class EntidadService {

    private final EntidadRepository entidadRepository;

    public EntidadService(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
    }

    public Entidad save(Entidad entidad) {

        control(entidad);

        boolean esNuevo = (entidad.getId() == null);

        if (esNuevo) {
            if (entidadRepository.existsByEmail(entidad.getEmail())) {
                throw new ExceptionGeneralSistema("El email ya está registrado");
            }

            return entidadRepository.save(entidad);

        } else {
            Entidad existente = entidadRepository.findById(entidad.getId())
                    .orElseThrow(() -> new ExceptionGeneralSistema("Entidad no encontrada"));

            if (!existente.getEmail().equals(entidad.getEmail())) {
                if (entidadRepository.existsByEmail(entidad.getEmail())) {
                    throw new ExceptionGeneralSistema("El email ya está registrado");
                }
            }

            existente.setNombre(entidad.getNombre());
            existente.setApellido(entidad.getApellido());
            existente.setEmail(entidad.getEmail());

            return entidadRepository.save(existente);
        }
    }

    public List<Entidad> findAll() {
        return entidadRepository.findAll();
    }

    public void control(Entidad entidad) {
        String sError = "";

        if (entidad.getNombre() == null || entidad.getNombre().isEmpty()) {
            sError = "El nombre no puede estar vacio.";
        }
        if (entidad.getApellido() == null || entidad.getApellido().isEmpty()) {
            sError = "El apellido no puede estar vacio.";
        }
        if (entidad.getEmail() == null || entidad.getEmail().isEmpty()) {
            sError = "El email no puede estar vacio.";
        }

        if (!sError.isEmpty()) {
            throw new ExceptionGeneralSistema(sError);
        }

    }

}
