package ru.esvetlichny.furniturestore.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderAdmDto extends CreateOrderDto {
    private Long customerid;
}
