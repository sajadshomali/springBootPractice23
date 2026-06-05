package ir.sajjad.springbootsession23.repository;

import ir.sajjad.springbootsession23.model.Factor;
import ir.sajjad.springbootsession23.model.Payed;
import ir.sajjad.springbootsession23.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactorRepository extends JpaRepository<Factor,Long> {
    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
