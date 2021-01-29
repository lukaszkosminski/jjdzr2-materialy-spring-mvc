package pl.infoshare.springmvcpresentation.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public String getGreetingView(Model model) {
        String message = greetingService.getMessage("Maciek");
        model.addAttribute("greeting", message);

        return "greeting-view";
    }
}
