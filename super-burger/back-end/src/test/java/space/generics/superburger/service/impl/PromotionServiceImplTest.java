package space.generics.superburger.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import space.generics.superburger.dto.promotion.AddPromotionDto;
import space.generics.superburger.dto.promotion.PromotionDto;
import space.generics.superburger.dto.promotion.UpdatePromotionDto;
import space.generics.superburger.entity.Promotion;
import space.generics.superburger.exception.exceptions.EntityByValueNotFoundException;
import space.generics.superburger.repository.PromotionRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PromotionServiceImplTest {
    
    @Autowired
    PromotionServiceImpl promotionService;
    
    @Autowired
    ModelMapper modelMapper;
    
    @MockBean
    PromotionRepository promotionRepository;
    
    private static final long PROMOTION_ID = 1;
    private static final Promotion PROMOTION = new Promotion();
    private static final List<Promotion> PROMOTIONS = new ArrayList<>();
    private static final PromotionDto PROMOTION_DTO = new PromotionDto();
    private static final AddPromotionDto ADD_PROMOTION_DTO =
            new AddPromotionDto();
    private static final UpdatePromotionDto UPDATE_PROMOTION_DTO =
            new UpdatePromotionDto();

    @BeforeEach
    public void setUpPromotion() {
        PROMOTION.setId(PROMOTION_ID);
        PROMOTION.setTitle("title");
        PROMOTION.setDescription("description");
        PROMOTION.setActionSrc("actionSrc");
        PROMOTION.setImageSrc("imageSrc");
        PROMOTION.setExpires(LocalDateTime.now());
        PROMOTIONS.clear();
        PROMOTIONS.add(PROMOTION);
        this.modelMapper.map(PROMOTION, PROMOTION_DTO);
        this.modelMapper.map(PROMOTION, ADD_PROMOTION_DTO);
        this.modelMapper.map(PROMOTION, UPDATE_PROMOTION_DTO);
    }
    
    @BeforeEach
    public void setUpMockito() {
        Mockito.doReturn(Optional.of(PROMOTION))
                .when(this.promotionRepository)
                .findById(PROMOTION_ID);
        Mockito.doReturn(PROMOTION)
                .when(this.promotionRepository)
                .save(Mockito.any(Promotion.class));
        Mockito.doNothing()
                .when(this.promotionRepository)
                .delete(Mockito.any(Promotion.class));
        Mockito.doReturn(PROMOTIONS)
                .when(this.promotionRepository)
                .findAll();
    }
    
    @Test 
    public void testFindById() {
        Promotion actual = this.promotionService.findById(PROMOTION_ID);
        Assertions.assertEquals(PROMOTION, actual);
    }
    
    @Test
    public void testFindByNotExistId() {
        Assertions.assertThrows(
                EntityByValueNotFoundException.class,
                () -> this.promotionService.findById(0));
    }
    
    @Test
    public void testReadById() {
        PromotionDto actual = this.promotionService.readById(PROMOTION_ID);
        Assertions.assertEquals(PROMOTION_DTO, actual);
    }
    
    @Test
    public void testCreate() {
        PromotionDto actual = this.promotionService.create(ADD_PROMOTION_DTO);
        Assertions.assertEquals(PROMOTION_DTO, actual);
    }
    
    @Test
    public void testUpdate() {
        PromotionDto actual = this.promotionService.update(
                PROMOTION_ID, UPDATE_PROMOTION_DTO);
        Assertions.assertEquals(PROMOTION_DTO, actual);
    }
    
    @Test
    public void testDeleteById() {
        this.promotionService.deleteById(PROMOTION_ID);
        Mockito.verify(this.promotionRepository, Mockito.times(1))
                .delete(PROMOTION);
    }
    
    @Test
    public void testDeleteByNotExistId() {
        Assertions.assertThrows(
                EntityByValueNotFoundException.class,
                () -> this.promotionService.deleteById(0));
    }
    
    @Test
    public void testGetAll() {
        final int expected = PROMOTIONS.size();
        final int actual = this.promotionService.readAll().size();
        Assertions.assertEquals(expected, actual);   
    }
    
}
