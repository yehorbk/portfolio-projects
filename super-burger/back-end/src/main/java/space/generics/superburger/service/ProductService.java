package space.generics.superburger.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import space.generics.superburger.dto.product.AddProductDto;
import space.generics.superburger.dto.product.ProductDto;
import space.generics.superburger.dto.product.UpdateProductDto;
import space.generics.superburger.entity.enums.ProductType;

public interface ProductService {
    
    ProductDto readById(long id);
    
    ProductDto create(AddProductDto addProductDto);
    
    ProductDto update(long id, UpdateProductDto updateProductDto);
    
    ProductDto updateImageById(long id, MultipartFile image);
    
    void deleteById(long id);
    
    List<ProductDto> readAll();
    
    List<ProductDto> readAllByType(ProductType productType);
    
}
