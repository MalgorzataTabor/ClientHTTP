package pl.tabor.exercise.goldexercise.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.tabor.exercise.goldexercise.model.Gold;

@Controller
public class GoldController {

    RestTemplate restTemplate;

    public GoldController() {
        this.restTemplate = new RestTemplate();
    }


    @GetMapping("/gold")
    public String getCurrency(Model model) {

        Gold[] golds = restTemplate.getForObject("http://api.nbp.pl/api/cenyzlota/2020-01-01/2021-01-01", Gold[].class);
        model.addAttribute("golds", golds);
        return "goldView";
    }
}
