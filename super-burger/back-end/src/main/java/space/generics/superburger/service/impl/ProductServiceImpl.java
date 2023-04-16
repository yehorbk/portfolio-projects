package space.generics.superburger.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.generics.superburger.dto.product.AddProductDto;
import space.generics.superburger.dto.product.ProductDto;
import space.generics.superburger.dto.product.UpdateProductDto;
import space.generics.superburger.entity.Product;
import space.generics.superburger.entity.enums.ProductType;
import space.generics.superburger.environment.MultipleModelMapper;
import space.generics.superburger.exception.exceptions.EntityByValueNotFoundException;
import space.generics.superburger.repository.ProductRepository;
import space.generics.superburger.service.FileService;
import space.generics.superburger.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final FileService fileService;
    
    private final ProductRepository productRepository;
    
    private final MultipleModelMapper modelMapper;
    
    Product findById(long id) {
        Optional<Product> optional = this.productRepository.findById(id);
        if (optional.isPresent()) {
            Product result = optional.get();
            return result;
        }
        throw new EntityByValueNotFoundException(
                "Product", "id", String.valueOf(id));
    }

    @Override
    public ProductDto readById(long id) {
        Product result = this.findById(id);
        return this.modelMapper.map(result, ProductDto.class);
    }

    @Override
    public ProductDto create(AddProductDto dto) {
        Product product = this.modelMapper.map(dto, Product.class);
        Product result = this.productRepository.save(product);
        return this.modelMapper.map(result, ProductDto.class);
    }

    @Override
    public ProductDto update(long id, UpdateProductDto dto) {
        Product product = this.findById(id);
        this.modelMapper.map(dto, product);
        Product result = this.productRepository.save(product);
        return this.modelMapper.map(result, ProductDto.class);
    }

    @Override
    public ProductDto updateImageById(long id, MultipartFile image) {
        Product product = this.findById(id);
        String path = this.fileService.upload(image);
        product.setImageSrc(path);
        Product result = this.productRepository.save(product);
        return this.modelMapper.map(result, ProductDto.class);
    }

    @Override
    public void deleteById(long id) {
        Product product = this.findById(id);
        this.productRepository.delete(product);
    }

    @Override
    public List<ProductDto> readAll() {
        List<Product> result = this.productRepository.findAll();
        return this.modelMapper.map(result, ProductDto.class);
    }

    @Override
    public List<ProductDto> readAllByType(ProductType productType) {
        List<Product> result = this.productRepository
                .findAllByType(productType);
        return this.modelMapper.map(result, ProductDto.class);
    }
    
}
