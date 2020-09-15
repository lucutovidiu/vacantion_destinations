package com.vacations.dao.orders;

import com.vacations.dao.base.BaseEntity;
import com.vacations.dao.user.UserEntity;
import com.vacations.dao.user.pojo.Order;
import com.vacations.dao.vacation.VacationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    private long price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentCardType paymentCardType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private VacationEntity vacation;

    public Order toOrder(){
        return Order.builder()
                .price(price)
                .orderStatus(orderStatus)
                .paymentCardType(paymentCardType)
                .user(user)
                .build();
    }
}
