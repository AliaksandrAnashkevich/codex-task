package com.codex.controller;

import com.codex.entity.Item;
import com.codex.entity.User;
import com.codex.service.EmailService;
import com.codex.service.ItemService;
import com.codex.service.UserService;
import com.codex.util.EmailCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;


    @GetMapping("/select")
    public String userPage(Model model) {
        return "user";
    }

    @GetMapping("/basket")
    public String basket(Model model,
                         Principal principal) {
        model.addAttribute("items", itemService.getByUser(principal.getName()));
        return "basket";
    }

    @GetMapping("/selectAll")
    public String itemList(Model model) {
        model.addAttribute("allItems", itemService.getAll());
        return "itemUser";
    }

    @PostMapping("/selectByTag")
    public String itemListByTag(Model model,
                                @RequestParam(name = "tag") String tag) {
        model.addAttribute("allItems", itemService.getByTag(tag));
        return "itemUser";
    }

    @PostMapping("/selectByDescription")
    public String itemListByDescription(Model model,
                                        @RequestParam(name = "description") String description) {
        model.addAttribute("allItems", itemService.getByDescription(description));
        return "itemUser";
    }

    @GetMapping("/pay")
    public String pay(Model model,
                      Principal principal){
        User user = userService.getByLogin(principal.getName());
        List<Item> items = itemService.getByUser(user.getUsername());
        if (!items.isEmpty()){
            try {
                emailService.sendMessage(user.getEmail(),EmailCreation.getTHANKS(),
                        EmailCreation.getInstance().payEmailMessage(items));
            } catch (MailException mailException) {
                mailException.printStackTrace();
            }
            itemService.deleteConnection(user.getId());
        }

        return "redirect:/user/select";
    }

    @GetMapping("/addToBasket/{id}")
    public String addToCart(Model model,
                            @PathVariable("id") Long id,
                            Principal principal){
        itemService.addItemConnection(id,userService.getByLogin(principal.getName()).getId());
        return "user";
    }

    @GetMapping("/deleteToBasket/{id}")
    public String deleteToCart(Model model,
                            @PathVariable("id") Long id){
        itemService.deleteItemConnection(id);
        return "redirect:/user/basket";
    }
}
