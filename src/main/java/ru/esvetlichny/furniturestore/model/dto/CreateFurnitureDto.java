package ru.esvetlichny.furniturestore.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFurnitureDto {
    private String name;
    private Long typeId;
    private Long placementId;
    private Double price;
}
