package com.vacations.dao.vacation;

import com.vacations.dao.accommodation.AccommodationEntity;
import com.vacations.dao.base.BaseEntity;
import com.vacations.dao.flights.FlightEntity;
import com.vacations.dao.photos.PhotoEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vacations")
public class VacationEntity extends BaseEntity {

    @NotNull
    private String destinationCountry;
    @NotNull
    private String destinationCity;
    private long price;
    @NotNull
    private int duration;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    private String description;
    @ManyToMany
    @JoinTable(name = "vacation_accomodation",
    joinColumns = {@JoinColumn(name = "vacation_id")},
    inverseJoinColumns = {@JoinColumn(name = "accomodation_id")})
    private List<AccommodationEntity> accommodations;
    @OneToMany
    @JoinColumn(name = "vacation_id")
    private List<FlightEntity> flights;
    @OneToMany
    @JoinColumn(name = "vacation_id")
    private List<PhotoEntity> photo;
}
