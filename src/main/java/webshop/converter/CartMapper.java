package webshop.converter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import webshop.dto.CartDto;
import webshop.dto.ProductDto;
import webshop.model.Cart;
import webshop.model.Product;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface CartMapper {
    CartMapper MAPPER = Mappers.getMapper(CartMapper.class);

    @Mapping(target = "ProductMapper.fromProductList.productList")
    Cart toCart(CartDto cartDto);
    @InheritInverseConfiguration
    CartDto fromCart(Cart cart);
}
