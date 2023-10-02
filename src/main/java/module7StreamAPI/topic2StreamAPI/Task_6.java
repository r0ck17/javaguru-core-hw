package module7StreamAPI.topic2StreamAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Task_6 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("");
        objects.add("2");

        Iterator<Object> iterator = objects.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            objects.set(1,"3");
        }
    }
}
