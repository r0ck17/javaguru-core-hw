package module7StreamAPI.topic3XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Task_1 {
    public static void main(String[] args) {
        String fileName = "text.xml";
        List<Point> points = getPointsFromXML(fileName);

        System.out.printf("Считанные координаты точек из файла '%s':%n", fileName);
        if (points.size() != 0) {
            for (Point point : points) {
                System.out.printf("%d px, %d px.%n", point.getX(), point.getY());
            }
        } else {
            System.out.println("Данные не были распознаны.");
        }
    }

    private static List<Point> getPointsFromXML(String filePath){
        List<Point> points = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            NodeList nodelist = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);

                if (node instanceof Element) {
                    getPointFromNode(node).ifPresent(points::add);
                }
            }
        } catch (ParserConfigurationException | SAXException | NumberFormatException | IOException e) {
            System.out.println("Ошибка при обработке файла. Считывание приостановлено.\n");
        }

        return points;
    }

    private static Optional<Point> getPointFromNode(Node node) {
        NodeList childNodes = node.getChildNodes();
        Integer x = null;
        Integer y = null;

        for (int j = 0; j < childNodes.getLength(); j++) {
            Node childNode = childNodes.item(j);
            if (childNode instanceof Element) {
                String content = childNode.getTextContent().trim();
                switch (childNode.getNodeName()) {
                    case "x":
                        x = Integer.valueOf(content);
                        break;
                    case "y":
                        y = Integer.valueOf(content);
                        break;
                    default:
                        break;
                }
            }
        }
        return (x != null) && (y != null)
                ? Optional.of(new Point(x, y))
                : Optional.empty();
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}