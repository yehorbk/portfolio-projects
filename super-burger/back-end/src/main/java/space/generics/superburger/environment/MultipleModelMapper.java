package space.generics.superburger.environment;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class MultipleModelMapper extends ModelMapper {
    
    public <S, D> List<D> map(List<S> source, Class<D> destinationType) {
            Function<S, D> multipleMapper = entry ->
                    this.map(entry, destinationType);
            return source.stream()
                    .map(multipleMapper)
                    .collect(Collectors.toList());
        }
    
}
