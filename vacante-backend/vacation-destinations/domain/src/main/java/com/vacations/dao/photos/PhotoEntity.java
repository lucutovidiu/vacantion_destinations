package com.vacations.dao.photos;

import com.vacations.dao.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "photos")
public class PhotoEntity extends BaseEntity {

    @NotNull
    private byte[] photo;
    @NotNull
    private String photoName;
}
