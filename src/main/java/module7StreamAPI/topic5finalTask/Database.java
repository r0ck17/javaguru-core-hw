package module7StreamAPI.topic5finalTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private Path baseDataDirectory = Paths.get("src", "main", "java", "module7StreamAPI", "topic5finalTask", "DataBaseTask", "data");

    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, List<LineItem>> items = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();

    public Database() {
    }

    public void createCustomerJson(int custKey) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Customer customer = customers.get(custKey);

            if (customer != null) {
                String fileName = String.format("customer #%s.json", custKey);
                objectMapper.writeValue(new File(fileName), customer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createOrderJson(int orderKey) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            Order order = orders.get(orderKey);
            Customer customer = customers.get(order.getCustKey());
            List<LineItem> orderItems = items.get(order.getOrderKey());
            OrderInfo orderInfo = new OrderInfo(order, customer, orderItems);

            String fileName = String.format("order #%s.json", orderKey);
            objectMapper.writeValue(new File(fileName), orderInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getAverageQuantityPerMarketSegment(String marketsegment) {
        HashSet<Integer> customersKeys = customers.values().stream()
                .filter(c -> Objects.equals(marketsegment, c.getMktsegment()))
                .map(Customer::getCustKey)
                .collect(Collectors.toCollection(HashSet::new));

        HashSet<Integer> ordersKeys = orders.values().stream()
                .filter(o -> customersKeys.contains(o.getCustKey()))
                .map(Order::getOrderKey)
                .collect(Collectors.toCollection(HashSet::new));

        return (long) items.entrySet().stream()
                .filter(item -> ordersKeys.contains(item.getKey()))
                .map(e -> countQuantityFromOrder(e.getValue()))
                .mapToLong(Long::longValue)
                .average()
                .orElse(-1);
    }

    private long countQuantityFromOrder(List<LineItem> items) {
        return items.stream()
                .mapToLong(LineItem::getQuantity)
                .sum();
    }

    public void setBaseDataDirectory(Path baseDataDirectory) {
        this.baseDataDirectory = baseDataDirectory;
    }

    public void processInputFileCustomer() {
        try (Stream<String> lines = Files.lines(baseDataDirectory.resolve("customer.tbl"))) {
            customers = lines
                    .map(c -> mapToCustomerData.apply(c))
                    .collect(Collectors.toMap(Customer::getCustKey, Function.identity()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processInputFileLineItem() {
        try (Stream<String> lines = Files.lines(baseDataDirectory.resolve("lineitem.tbl"))) {
            items = lines
                    .map(c -> mapToLineItemData.apply(c))
                    .collect(Collectors.groupingBy(LineItem::getOrderKey));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processInputFileOrders() {
        try (Stream<String> lines = Files.lines(baseDataDirectory.resolve("orders.tbl"))) {
            orders = lines
                    .map(c -> mapToOrderData.apply(c))
                    .collect(Collectors.toMap(Order::getOrderKey, Function.identity()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public Map<Integer, List<LineItem>> getItems() {
        return items;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    private Function<String, Customer> mapToCustomerData = (line) -> {
        String[] p = line.split("\\|");
        return new Customer(Integer.parseInt(p[0]), p[1].toCharArray(),
                Integer.parseInt(p[3]), p[4].toCharArray(), Float.parseFloat(p[5]),
                p[6], p[7].toCharArray());
    };

    private Function<String, LineItem> mapToLineItemData = (line) -> {
        String[] p = line.split("\\|");
        return new LineItem(Integer.parseInt(p[0]), Integer.parseInt(p[1]),
                Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]) * 100,  // По ТЗ *100
                Float.parseFloat(p[5]), Float.parseFloat(p[6]), Float.parseFloat(p[7]),
                p[8].charAt(0), p[9].charAt(0), LocalDate.parse(p[10]),
                LocalDate.parse(p[11]), LocalDate.parse(p[12]), p[13].toCharArray(),
                p[14].toCharArray(), p[15].toCharArray());
    };

    private Function<String, Order> mapToOrderData = (line) -> {
        String[] p = line.split("\\|");
        return new Order(Integer.parseInt(p[0]), Integer.parseInt(p[1]), p[2].charAt(0),
                Float.parseFloat(p[3]), LocalDate.parse(p[4]), p[5].toCharArray(), p[6].toCharArray(),
                Integer.parseInt(p[7]), p[8].toCharArray());
    };
}
