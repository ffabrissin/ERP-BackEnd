package com.erp.erp.Service;

import com.erp.erp.ExceptionGeneralSistema.ExceptionGeneralSistema;
import com.erp.erp.Repository.EntidadRepository;
import com.erp.erp.model.Entidad;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Entidad findById(Long id) {
        return entidadRepository.findById(id)
                .orElseThrow(() -> new ExceptionGeneralSistema("Entidad no encontrada"));
    }

    public void delete(Long id) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new ExceptionGeneralSistema("Entidad no encontrada"));
        entidadRepository.delete(entidad);
    }

    public void control(Entidad entidad) {
        StringBuilder sError = new StringBuilder();

        if (entidad.getNombre() == null || entidad.getNombre().isBlank()) {
            sError.append("El nombre no puede estar vacío. ");
        }

        if (entidad.getApellido() == null || entidad.getApellido().isBlank()) {
            sError.append("El apellido no puede estar vacío. ");
        }

        if (entidad.getEmail() == null || entidad.getEmail().isBlank()) {
            sError.append("El email no puede estar vacío. ");
        }

        if (!sError.isEmpty()) {
            throw new ExceptionGeneralSistema(sError.toString());
        }
    }

}
