package com.erp.erp.Service;

import com.erp.erp.Repository.productoRepository;
import com.erp.erp.model.producto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author piti_
 */
@Service
public class productoService {

    private final productoRepository productoRepository;

    public productoService(productoRepository proRepository) {
        this.productoRepository = proRepository;
    }

    public producto save(producto producto) {
        return productoRepository.save(producto);
    }

    public List<producto> findAll() {
        return productoRepository.findAll();
    }

    public void control(producto producto) {
        String sError = "";

        if (producto.getName().isEmpty() || producto.getName() == null) {
            sError = "El producto debe tener nombre";
        }

        if (!sError.isEmpty()) {
        }
    }

}
