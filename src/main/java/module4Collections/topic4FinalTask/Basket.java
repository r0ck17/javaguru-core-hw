package module4Collections.topic4FinalTask;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Product, Integer> goods;

    public Basket() {
        this.goods  = new HashMap<>();
    }

    public Map<Product, Integer> getGoods() {
        return goods;
    }
}