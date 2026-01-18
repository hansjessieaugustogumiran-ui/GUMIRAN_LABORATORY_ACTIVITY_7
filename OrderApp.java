package com.store.main;

import com.store.order.OnlineOrder;
import com.store.order.Order;
import com.store.order.OrderStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderApp {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        OnlineOrder o1 = new OnlineOrder(1, 250.00);
        OnlineOrder o2 = new OnlineOrder(2, 150.00);
        OnlineOrder o3 = new OnlineOrder(3, 500.00);

        o2.cancelOrder(); // simulate cancelled order

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();

            System.out.println(order.getOrderSummary());

            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
                System.out.println("Cancelled order removed.");
            }
        }
    }
}
