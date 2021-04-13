package space.generics.superburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.generics.superburger.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    
}
