package webshop.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import webshop.dto.ProductDto;
import webshop.model.Product;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);
    ProductDto fromProduct(Product product);

}
