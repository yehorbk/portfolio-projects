package space.generics.superburger.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import space.generics.superburger.dto.promotion.AddPromotionDto;
import space.generics.superburger.dto.promotion.PromotionDto;
import space.generics.superburger.dto.promotion.UpdatePromotionDto;
import space.generics.superburger.service.PromotionService;

@RestController
@RequestMapping("/rest")
public class PromotionController {
    
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    
    @ApiOperation("Get all promotions")
    @GetMapping("/promotions")
    public List<PromotionDto> readAll() {
        List<PromotionDto> result = this.promotionService.readAll();
        return result;
    }
    
    @ApiOperation("Get promotion by id")
    @GetMapping("/promotions/{id}")
    public PromotionDto readById(@NotBlank @PathVariable long id) {
        PromotionDto result = this.promotionService.readById(id);
        return result;
    }
    
    @ApiOperation("Create promotion")
    @PostMapping("/promotions")
    public PromotionDto create(@RequestBody AddPromotionDto dto) {
        PromotionDto result = this.promotionService.create(dto);
        return result;
    }
    
    @ApiOperation("Update promotion by id")
    @PutMapping("/promotions/{id}")
    public PromotionDto update(
            @NotBlank @PathVariable long id,
            @RequestBody UpdatePromotionDto dto) {
        PromotionDto result = this.promotionService.update(id, dto);
        return result;
    }
    
    @ApiOperation("Delete promotion by id")
    @DeleteMapping("/promotions/{id}")
    public void delete(@NotBlank @PathVariable long id) {
        this.promotionService.deleteById(id);
    }
    
    @ApiOperation("Upload promotion image")
    @PostMapping("/promotions/{id}/image")
    public PromotionDto updateImage(
            @NotBlank @PathVariable long id,
            @RequestParam("file") MultipartFile file) {
        PromotionDto result = this.promotionService.updateImageById(id, file);
        return result;
    }
    
}
