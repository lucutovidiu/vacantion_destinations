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
@Table(name = "accommodation")
public class AccommodationEntity extends BaseEntity {

    @NotNull
    private String country;
    @NotNull
    private String city;
    private String street;
    private String streetName;
    private int streetNo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AccommodationType accommodationType;
    private boolean allInclusive;
    private boolean breakFastIncluded;
    private long price;
    private String roomSize;
    @ManyToMany
    @JoinTable(name = "accommodation_feature_join",
            joinColumns = {@JoinColumn(name = "accommodation_id")},
            inverseJoinColumns = {@JoinColumn(name = "feature_id")})
    private List<AccommodationFeatureEntity> accommodationFeatures;
    @OneToMany
    @JoinColumn(name = "accommodation_id")
    private List<PhotoEntity> photo;
}
