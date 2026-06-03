package ir.sajjad.springbootsession23.repository;

import ir.sajjad.springbootsession23.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface ShoppingCardRepository extends JpaRepository<ShoppingCard,Long> {
}
