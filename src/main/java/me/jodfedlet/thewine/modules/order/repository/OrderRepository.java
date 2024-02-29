package me.jodfedlet.thewine.modules.order.repository;

import me.jodfedlet.thewine.modules.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
