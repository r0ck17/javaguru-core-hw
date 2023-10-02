package module3Oop.topic1OOP;

import java.util.Arrays;

/**
 * Вы делаете систему фильтрации комментариев для системы онлайн-обучения :)
 * Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.
 *
 * Мы будем фильтровать:
 * 1)  Спам   (по наличию указанных ключевых слов в тексте )
 * 2)  Комментарии с негативным содержанием (по наличию одного из трех смайликов – :(   =(    :|)
 * 3) Длинные комментарии (по ограничению максимальный длины)
 *
 * Вам необходимо реализовать три класса, которые реализуют интерфейс TextAnalyzer:
 *
 * 1) SpamAnalyzer   -  должен конструироваться от массива строк с ключевыми словами. Объект этого класса должен сохранять в своем состоянии этот массив строк в приватном поле keywords.
 * 2) NegativeTextAnalyzer   -  должен конструироваться конструктором по-умолчанию.
 * 3) TooLongTextAnalyzer    -  должен конструироваться от int'а с максимальной допустимой длиной комментария. Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.
 *
 * SpamAnalyzer и NegativeTextAnalyzer во многом похожи – они оба проверяют текст на наличие каких-либо ключевых слов  (в случае спама мы получаем их из конструктора, в случае негативного текста мы заранее знаем набор грустных смайликов) и в случае нахождения одного из ключевых слов возвращают Label (SPAM и NEGATIVE_TEXT соответственно), а если ничего не нашлось – возвращают OK.
 *
 * Давайте эту логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:
 * 1. Выделим два абстрактных метода getKeywords и getLabel,
 * 2. Реализуем processText
 * 3. Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.
 *
 * Написать метод checkLabels, который будет возвращать метку для комментария по набору анализаторов текста. checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов, и OK, если все анализаторы вернули OK.
 */

public class Task_3 {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label result = analyzer.processText(text);
            if (result != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG

        for (String str : tests) {
            System.out.println(checkLabels(textAnalyzers, str));
        }
    }
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    public abstract String[] getKeywords();
    public abstract Label getLabel();

    @Override
    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keyWords;
    public SpamAnalyzer(String[] keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public String[] getKeywords() {
        return Arrays.copyOf(keyWords, keyWords.length);
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keyWords = new String[]{":(", "=(", ":|"};

    @Override
    public String[] getKeywords() {
        return Arrays.copyOf(keyWords, keyWords.length);
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}