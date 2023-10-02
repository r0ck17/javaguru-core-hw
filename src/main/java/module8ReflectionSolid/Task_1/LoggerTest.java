package module8ReflectionSolid.Task_1;

/**
 * Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл.
 * Объект логгера должен быть создан с помощью ШП Singleton.
 *
 * Добавьте enum - уровень логирования,  полями:
 * TRACE (для ещё большего количества ещё более детальных отладочных сообщений),
 * DEBUG (для отладочных сообщений),
 * INFO (для информационных сообщений),
 * WARN (для предупреждений),
 * ERROR (для логирования ошибок),
 * FATAL (для критических ошибок).
 *
 * Указывайте уровень логирования при создании объекта логгера.
 * У объекта должен быть обязательным один метод, получающий на вход текст сообщения об ошибке и тип ошибки(уровень логирования).
 * Если тип ошибки больше или равен уровню логирования, то ошибка записывается в файл в формате:
 * Дата время тип_ошибки текст_сообщения
 */
public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Logger.Level.INFO);
        logger.log(Logger.Level.TRACE, "Message with TRACE level");
        logger.log(Logger.Level.DEBUG, "Message with DEBUG level");
        logger.log(Logger.Level.INFO, "Message with INFO level");
        logger.log(Logger.Level.WARN, "Message with WARN level");
        logger.log(Logger.Level.ERROR, "Message with ERROR level");
        logger.log(Logger.Level.FATAL, "Message with FATAL level");
    }
}
