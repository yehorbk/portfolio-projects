package space.generics.superburger.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.generics.superburger.entity.Product;
import space.generics.superburger.entity.enums.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByType(ProductType productType);
    
}
