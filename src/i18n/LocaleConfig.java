package i18n;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleConfig {
    public static Locale locale = Locale.getDefault();
    public static ResourceBundle bundle = ResourceBundle.getBundle("report", locale);
    public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss", Locale.getDefault());
    public static LocalDateTime dateTime;
}
