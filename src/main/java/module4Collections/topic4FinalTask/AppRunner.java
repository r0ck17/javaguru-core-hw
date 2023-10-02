package module4Collections.topic4FinalTask;

import static module4Collections.topic4FinalTask.Manager.*;

public class AppRunner {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addProduct(new Product("Book", 500));
        manager.addProduct(new Product("Book", 100));
        manager.addProduct(new Product("Pen", 30));
        manager.addProduct(new Product("Notebook", 150));
        manager.addProduct(new Product("Journal", 700));

        manager.printAllProductsAndTotalPrice();

        System.out.println("\nСписок товаров в корзине отсортированный по имени:");
        manager.printAllProducts(SortCriterion.BY_NAME);

        System.out.println("\nСписок товаров в корзине отсортированный по цене:");
        manager.printAllProducts(SortCriterion.BY_PRICE);

        System.out.println("\nСписок товаров в корзине отсортированный по имени и цене:");
        manager.printAllProducts(SortCriterion.BY_NAME_AND_PRICE);
    }
}
