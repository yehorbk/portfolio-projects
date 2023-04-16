package space.generics.superburger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.generics.superburger.environment.MultipleModelMapper;

@Configuration
public class MapperConfig {
    
    @Bean
    public MultipleModelMapper modelMapper() {
        MultipleModelMapper modelMapper = new MultipleModelMapper();
        return modelMapper;
    }
    
}
