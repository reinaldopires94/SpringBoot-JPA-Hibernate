package com.reinaldopires.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reinaldopires.course.entities.OrderItem;
import com.reinaldopires.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}