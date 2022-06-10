package files.controller;

import files.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@Controller
@RequestMapping("/front")
public class MainController {

    private final MainService mainService;
    private String[] answer = new String[2];

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }


    //    http://localhost:8090/front
    @GetMapping
    public String index(Model model) {
        model.addAttribute("giphyUrl", answer[0]);
        model.addAttribute("message", answer[1]);
        return "index";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam(name = "currency") String currency) {
        answer = mainService.getGifAndCurrency(currency.toUpperCase(Locale.ROOT));
        return "redirect:/front";
    }
}