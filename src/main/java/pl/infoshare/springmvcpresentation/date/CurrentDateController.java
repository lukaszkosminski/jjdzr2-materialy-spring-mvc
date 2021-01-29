package pl.infoshare.springmvcpresentation.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrentDateController {

    private final CurrentDateService currentDateService;

    @Autowired
    public CurrentDateController(CurrentDateService currentDateService) {
        this.currentDateService = currentDateService;
    }

    @GetMapping("/current-date")
    @ResponseBody
    public String getCurrentDateMessage(@RequestParam(defaultValue = "yyyy-MM-dd") String format) {
        return currentDateService.getMessage(format);
    }

    @GetMapping("/current-date-html")
    public String displayDateMessage(Model model, @RequestParam(defaultValue = "yyyy-MM-dd") String format) {
        String message = currentDateService.getMessage(format);
        model.addAttribute("message", message);

        return "message-view";
    }

}
