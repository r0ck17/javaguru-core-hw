package module7StreamAPI.topic5finalTask;

import java.util.Collection;

public class DataBaseTest {
    public static void main(String[] args) {
        Database database = new Database();

        database.processInputFileCustomer();
        database.processInputFileLineItem();
        database.processInputFileOrders();

        long listItemsCount = database.getItems().values().stream()
                .flatMap(Collection::stream)
                .count();

        System.out.println("Total customers records: " + database.getCustomers().size());
        System.out.println("Total orders records: " + database.getOrders().size());
        System.out.println("Total ListItems records " + listItemsCount);

        long furnitureAvg = database.getAverageQuantityPerMarketSegment("FURNITURE");
        System.out.println("Average items count per order in FURNITURE segment: " + furnitureAvg);

        long testAvg = database.getAverageQuantityPerMarketSegment("test");
        System.out.println("Average items count per order in test segment: " + testAvg);

        database.createCustomerJson(5);

        database.createOrderJson(1);
    }
}
