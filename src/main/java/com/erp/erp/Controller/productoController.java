package com.erp.erp.Controller;

import com.erp.erp.Service.productoService;
import com.erp.erp.model.producto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author piti_
 */
@RestController
@RequestMapping("/api/producto")
public class productoController {

    private final productoService productoService;

    public productoController(productoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public producto create(@RequestBody producto product) {
        return productoService.save(product);
    }

    @GetMapping
    public List<producto> getAll() {
        return productoService.findAll();
    }
}
