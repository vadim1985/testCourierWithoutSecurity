package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrderNumberService;

@Controller
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private OrderNumberService orderNumberService;

    @GetMapping
    public String getCourierPage(){
        return "courier";
    }

    @PostMapping
    public String getOrderNumberFromPage(@RequestParam(value = "number") long number){
        orderNumberService.addOrder(number);
        return "courier";
    }
}
