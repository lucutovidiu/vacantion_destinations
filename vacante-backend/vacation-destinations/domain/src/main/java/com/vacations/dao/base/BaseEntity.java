package com.vacations.dao.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate = LocalDateTime.now();

    @PreUpdate
    @PrePersist
    public void setUpdateDateAtPersist() {
        updateDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "id=" + id +
                ", createDate=" + createdAt +
                '}';
    }
}
