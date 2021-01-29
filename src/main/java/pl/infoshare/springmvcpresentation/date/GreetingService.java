package pl.infoshare.springmvcpresentation.date;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String getMessage(String name) {
        return "Hello, " + name;
    }
}
