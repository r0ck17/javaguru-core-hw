package module2Classes.topic3Regexp;

import java.util.Scanner;

/**
 * Напишите валидацию клиентов хостинговой компании
 *
 * 1) Создайте класс Client с полями: email, ip, address, url и конструктором со всеми полями
 *
 * 2) Напишите класс ClientValidator с методами:
 *  - boolean validateEmail(String email)
 * - boolean validateIP(String ip)
 * - boolean validateUrl(String url)
 * - boolean validateAddress(String address)
 *
 * 3) boolean validateEmail(String email)
 *
 * Общий вид валидного email — логин@поддомен.домен
 * Логин - слова из букв, цифр, подчеркиваний, дефисов и точек.
 * Поддомен - от 2 до 6 букв
 * Домен - один из: ru, com, net, org.
 * Примеры валидных: my_email@gmail.com  a.petrov@gmail.com coder-4575@yandex.ru
 *
 * 4) boolean validateIP(String ip)
 *
 * Всегда есть 4 группы цифр (от 1 до 3 цифр в каждой) разделены точками. Группа содержит число в диапазоне от 0 до 256
 * Примеры валидных: 127.0.0.0  , 255.255.255.255, 234.34.98.14
 *
 * 5) boolean validateUrl(String url)
 *
 * Сначала идет необязательный протокол (http:// или https://)
 * Затем последовательность букв, цифр, дефисов, подчеркиваний и точек (домены уровня > 1)
 * Потом домен первого уровня (от 2 до 6 букв)
 * Наконец, файловая структура после слэша / — набор слов из букв, цифр, дефисов, подчеркиваний и точек со слэшем в конце или после знака ? набор букв, цифр, подчеркиваний, один знак равно =
 * В конце может быть слэш, а может отсутствовать
 *
 * Примеры:
 * https://www.labirint.ru/books/594619/
 * https://catalog.onliner.by/bike?is_prime=1
 * /books/594619/  - эта часть может быть, а может отсутствовать
 *
 * 6) boolean validateAddress(String address)
 *
 * [Название страны] обл. [Название области] р-н [Название района] г. или д. [Название города или деревни] ул. [Название улицы] д. [Номер дома]
 * где все названия начинаются с большой буквы и состоят из кириллицы. Приставки обл.  г. - обязательны, номер дома - только цифры.
 * Метод должен сначала насколько возможно привести переданный адрес к валидному формату, убрав возможные лишние пробелы и спец. символы (%$@<>?*())
 * Затем проверить или строка соответствует формату.
 *
 * 7) Создать класс ClientTest и в методе main создать несколько объектов класса Client. Протестировать работу всех методов для валидации.
 */

public class Task_4 {
    public static void main(String[] args) {
        Client[] clients = generateClients();
        System.out.println("Проверка данных с помощью валидатора:\n");
        for (Client client : clients) {
            String email = client.getEmail();
            String ip = client.getIp();
            String url = client.getUrl();
            System.out.println(email + " - " + ClientValidator.validateEmail(email));
            System.out.println(ip + " - " + ClientValidator.validateIP(ip));
            System.out.println(url + " - " + ClientValidator.validateUrl(url));
            System.out.println();
        }

        System.out.println("Введите данные для валидации:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("ip: ");
        String ip = scanner.nextLine();
        System.out.print("url: ");
        String url = scanner.nextLine();

        Client client = new Client(email, ip, url);
        System.out.println(ClientValidator.validateEmail(client.getEmail()));
        System.out.println(ClientValidator.validateIP(client.getIp()));
        System.out.println(ClientValidator.validateUrl(client.getUrl()));

        System.out.print("\nВведите адрес: ");
        String address = scanner.nextLine();
        System.out.println(ClientValidator.validateAddress(address));
    }

    public static Client[] generateClients() {
        String[] emails = {"a1_-.@a.ru", "a.petrov@gmail.com",
                "a1_-.@aa2aa.ru", "a1_-.@a.ru"};

        String[] ip = {"127.0.0.0", "255.255.255.255",
                "255.312.255.255", "127.0,0.0"};

        String[] urls = {"https://www.labirint.ru/books/594619/",
                "catalog.onliner.by",
                "https://catalog.onliner.by/bike?is_prime=1",
                "www.labirint.ru/books/594619/"};

        Client[] clients = new Client[4];

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client(emails[i], ip[i], urls[i]);
        }

        return clients;
    }
}

class Client {
    private final String email;
    private final String ip;
    private final String url;
    public Client(String email, String ip, String url) {
        this.email = email;
        this.ip = ip;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }
}

class ClientValidator {
    static boolean validateEmail(String email) {
        return email.matches("[\\w\\-\\.]{1,20}@[a-zA-z]{2,6}\\." +
                "(ru|com|net|org)");
    }

    static boolean validateIP(String ip) {
        return ip.matches("([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])\\." +
                "([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])\\." +
                "([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])\\." +
                "([0-1]?\\d?\\d|2[0-4]\\d|25[0-5])");
    }

    static boolean validateUrl(String url) {
        return url.matches("^(http:\\/\\/|https:\\/\\/)?(([\\w\\_])+\\.)+" +
                "([\\w\\_]){2,6}((\\/[\\w\\_\\.]+)+(\\/$)?(\\?([\\w\\_])+" +
                "=([\\w\\_])+)?)?(\\/)?");
    }

    static boolean validateAddress(String address) {
        String normalizedAddress = address.trim()
                .replaceAll("\\b\\s+\\b", " ")
                .replaceAll("[%$@<>?*()]", "");
        return normalizedAddress.matches("[А-Я][а-я]{3,20}\\s+" +
                "обл\\.\\s[А-Я][а-я]{3,20}\\s+р-н\\s[А-Я][а-я]{3,20}\\s" +
                "(г|д)\\.\\s[А-Я][а-я]{3,15}(\\b|[-\\s][А-Я][а-я]{3,15})\\s" +
                "ул\\.\\s([А-Я][а-я]{3,15}\\s){1,2}" +
                "д\\.\\s\\d{1,3}(\\b|\\s[Кк]\\s[0-9]{1,2})");
    }
}