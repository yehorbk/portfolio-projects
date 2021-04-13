package space.generics.superburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.generics.superburger.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
