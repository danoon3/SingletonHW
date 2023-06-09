import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logger {
    private static Logger logger;
    private Calendar calendar = new GregorianCalendar();
    private int count = 1;

    public void log(String msg) {
        System.out.println("[" + calendar.getTime() + " " + count++ + "] " + msg);
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }
}
