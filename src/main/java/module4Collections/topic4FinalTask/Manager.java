package module4Collections.topic4FinalTask;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Manager {
    Basket backet = new Basket();

    public boolean addProduct(Product product) {
        Map<Product, Integer> goods = backet.getGoods();
        goods.put(product, product.getPrice());

        System.out.printf("Добавлен новый товар %s, цена: %d\n",
                product.getName(), product.getPrice());

        return true;
    }

    public void printAllProductsAndTotalPrice() {
        Map<Product, Integer> goods = backet.getGoods();
        int totalPrice = 0;
        System.out.println("\nВсе товары в корзине:");

        for (var entry: goods.entrySet()) {
            System.out.printf("%s: %d р.\n",
                    entry.getKey().getName(), entry.getValue());
            totalPrice += entry.getValue();
        }

        System.out.printf("\nОбщая стоимость: %d р.\n", totalPrice);
    }

    public void printAllProducts(SortCriterion sortCriterion) {
        Map<Product, Integer> goods = backet.getGoods();
        Map<Product, Integer> sortedMap;

        switch (sortCriterion) {
            case BY_NAME: {
                sortedMap = new TreeMap<>(new NameComparator());
                sortedMap.putAll(goods);
                break;
            }
            case BY_PRICE: {
                sortedMap = new TreeMap<>(new PriceComparator());
                sortedMap.putAll(goods);
                break;
            }
            case BY_NAME_AND_PRICE: {
                Comparator<Product> comparator = new NameComparator().
                        thenComparing(new PriceComparator());
                sortedMap = new TreeMap<>(comparator);
                break;
            }
            default: {
                sortedMap = new TreeMap<>(new NameComparator());
            }
        }

        sortedMap.putAll(goods);

        for (var entry: sortedMap.entrySet()) {
            System.out.printf("%s: %d р.\n",
                    entry.getKey().getName(), entry.getValue());
        }
    }

    public enum SortCriterion {
        BY_NAME, BY_PRICE, BY_NAME_AND_PRICE;
    }
}
