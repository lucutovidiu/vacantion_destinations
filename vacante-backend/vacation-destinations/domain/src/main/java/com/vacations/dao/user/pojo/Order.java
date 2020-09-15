package com.vacations.dao.user.pojo;

import com.vacations.dao.orders.OrderStatus;
import com.vacations.dao.orders.PaymentCardType;
import com.vacations.dao.user.UserEntity;
import com.vacations.dao.vacation.VacationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
public class Order {

    private long price;
    private OrderStatus orderStatus;
    private PaymentCardType paymentCardType;
    private UserEntity user;
}
