package space.generics.superburger.service;

import java.util.List;
import space.generics.superburger.dto.promotion.AddPromotionDto;
import space.generics.superburger.dto.promotion.PromotionDto;
import space.generics.superburger.dto.promotion.UpdatePromotionDto;

public interface PromotionService {
    
    PromotionDto readById(long id);
    
    PromotionDto create(AddPromotionDto addPromotionDto);
    
    PromotionDto update(long id, UpdatePromotionDto updatePromotionDto);
    
    void deleteById(long id);
    
    List<PromotionDto> readAll();
    
}
