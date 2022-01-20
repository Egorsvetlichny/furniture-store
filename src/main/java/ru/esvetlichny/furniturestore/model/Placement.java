package ru.esvetlichny.furniturestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Сущность описывает помещение,
// предназначенное для конкретной мебели

@Getter
@Setter
@Entity
@Table(name = "placements")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(name = "name", length = 55)
    private String name;

    @OneToMany(mappedBy = "placement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Furniture> furnitureList = new ArrayList<>();
}