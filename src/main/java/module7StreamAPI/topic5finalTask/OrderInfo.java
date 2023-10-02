package module7StreamAPI.topic5finalTask;

import java.util.Collection;

public class OrderInfo {
    private Order order;
    private Customer customer;
    private Collection<LineItem> items;

    public OrderInfo(Order order, Customer customer, Collection<LineItem> items) {
        this.order = order;
        this.customer = customer;
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Collection<LineItem> getItems() {
        return items;
    }
}
