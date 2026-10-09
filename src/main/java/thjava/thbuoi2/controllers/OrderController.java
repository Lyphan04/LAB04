package thjava.thbuoi2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import thjava.thbuoi2.repository.OrderRepository;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders/orders-list";
    }
}
