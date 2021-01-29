package pl.infoshare.springmvcpresentation.date;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CurrentDateService {

    public String getMessage(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return "Current date: " + LocalDate.now().format(formatter);
    }
}
