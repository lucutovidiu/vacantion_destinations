package com.vacations.dao.flights;

import com.vacations.dao.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "flights")
public class FlightEntity extends BaseEntity {

    @NotNull
    private String originCountry;
    @NotNull
    private String destinationCountry;
    @NotNull
    private String originCity;
    @NotNull
    private String destinationCity;
    private long price;
    private int stops;
    @NotNull
    private LocalDateTime departureTime;
    @NotNull
    private LocalDateTime arrivalTime;
}
