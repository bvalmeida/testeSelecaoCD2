package br.com.sigabem.frete.repository;

import br.com.sigabem.frete.model.FreteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<FreteEntity, Long> {
}
