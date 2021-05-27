package space.generics.superburger.service;

import java.util.List;
import space.generics.superburger.dto.promotion.AddPromotionDto;
import space.generics.superburger.dto.promotion.PromotionDto;
import space.generics.superburger.dto.promotion.UpdatePromotionDto;
import org.springframework.web.multipart.MultipartFile;

public interface PromotionService {
    
    PromotionDto readById(long id);
    
    PromotionDto create(AddPromotionDto addPromotionDto);
    
    PromotionDto update(long id, UpdatePromotionDto updatePromotionDto);
    
    PromotionDto updateImageById(long id, MultipartFile image);
    
    void deleteById(long id);
    
    List<PromotionDto> readAll();
    
}
