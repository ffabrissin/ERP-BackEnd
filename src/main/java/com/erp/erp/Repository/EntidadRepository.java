package com.erp.erp.Repository;

import com.erp.erp.model.Entidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author piti_
 */
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {

    Optional<Entidad> findByEmail(String email);

    boolean existsByEmail(String email);
}
