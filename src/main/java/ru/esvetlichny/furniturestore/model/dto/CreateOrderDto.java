package ru.esvetlichny.furniturestore.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDto {
    private Long furnitureId;
    private Integer quantity;
    private String address;
}
