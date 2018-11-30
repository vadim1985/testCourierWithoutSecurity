package controller;


import entity.OrderNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.OrderNumberService;

import java.util.Collections;
import java.util.Date;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private OrderNumberService orderNumberService;

    @GetMapping
    public String getOperatorPage(Model model){
        model.addAttribute("checkOrder", "ShowAll");
        model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrder()));
        return "operator";
    }

    @PostMapping("/filter")
    public String getOrderByNumberFromPage(@RequestParam(value = "number") long number, Model model){
        OrderNumber orderNumber = null;
        orderNumber = orderNumberService.getOrderByNumber(number);
        System.out.println(orderNumber + "------------");
        if (orderNumber == null){
            model.addAttribute("checkOrder", "Not found");
            model.addAttribute("foundOrder", number);
        }
        else {
            model.addAttribute("checkOrder", "OrderIsFound");
            model.addAttribute("foundOrder", orderNumber);
        }
        return "operator";
    }

    @GetMapping("/{number}")
    public String getInfo(@PathVariable("number") long number, Model model){
        model.addAttribute("orderByNumber", orderNumberService.getOrderByNumber(number));
        return "orderInfo";
    }

    @PostMapping("/{number}")
    public String delOrder(@PathVariable("number") long number){
        orderNumberService.removeOrder(number);
        return "redirect:/operator";
    }

//    @PostMapping
//    public String getFilter(@RequestParam(value = "symbol") String symbol,
//                            @RequestParam(value = "dateOfOrder") String dateOfOrder,
//                            Model model){
//        model.addAttribute("checkOrder", "ShowAll");
//        if (symbol.equals("=")){
//            model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderEqualsDate(dateOfOrder)));
//        }else {
//            if (symbol.equals(">")){
//                model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderMoreDate(dateOfOrder)));
//            }else {
//                if (symbol.equals("<"))model.addAttribute("listOfOrderNumber", Collections.unmodifiableList(orderNumberService.getAllOrderLessDate(dateOfOrder)));
//            }
//        }
//        return "operator";
//    }

}
