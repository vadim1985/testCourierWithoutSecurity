package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrderNumberService;

import java.util.Collections;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private OrderNumberService orderNumberService;

    @PostMapping
    public String getFilter(@RequestParam(value = "symbol") String symbol,
                            @RequestParam(value = "dateOfOrder") String dateOfOrder,
                            Model model){
        model.addAttribute("checkOrder", "ShowAll");
        if (symbol.equals("=")){
            model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderEqualsDate(dateOfOrder)));
        }else {
            if (symbol.equals(">")){
                model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderMoreDate(dateOfOrder)));
            }else {
                if (symbol.equals("<"))model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderLessDate(dateOfOrder)));
            }
        }
        return "operator";
    }
}
