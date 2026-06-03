package ir.sajjad.springbootsession23.repository;

import ir.sajjad.springbootsession23.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Long> {
}
