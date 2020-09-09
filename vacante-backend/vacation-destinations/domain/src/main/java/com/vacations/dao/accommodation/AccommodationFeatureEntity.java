package com.vacations.dao.accommodation;

import com.vacations.dao.base.BaseEntity;
import com.vacations.dao.photos.PhotoEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "accommodation_feature")
public class AccommodationFeatureEntity extends BaseEntity {

    @NotNull
    private String name;
    private long price;
    private boolean included;
    @ManyToMany(mappedBy = "accommodationFeatures")
    private List<AccommodationEntity> accommodations;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "photo_id")
    private PhotoEntity photo;
}
