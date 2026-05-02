package com.erp.erp.Controller;

import com.erp.erp.Service.EntidadService;
import com.erp.erp.model.Entidad;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author piti_
 */
@RestController
@RequestMapping("/api/entidades")
@CrossOrigin(origins = "*")
public class entidadController {

    private final EntidadService entidadService;

    public entidadController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }

    @PostMapping
    public Entidad create(@RequestBody Entidad entidad) {
        return entidadService.save(entidad);
    }

    @GetMapping
    public List<Entidad> getAll() {
        return entidadService.findAll();
    }

    @GetMapping("/{id}")
    public Entidad getById(@PathVariable Long id) {
        return entidadService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entidadService.delete(id);
    }
}
