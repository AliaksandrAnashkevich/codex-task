package com.codex.controller;

import com.codex.entity.Item;
import com.codex.entity.User;
import com.codex.service.EmailService;
import com.codex.service.ItemService;
import com.codex.util.EmailCreation;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {

    private final ItemService itemService;

    private final EmailService emailService;

    @GetMapping("/select")
    public String adminPage(Model model) {
        return "admin";
    }

    @GetMapping("/selectAll")
    public String itemList(Model model) {
        model.addAttribute("allItems", itemService.getAll());
        return "itemAdmin";
    }

    @PostMapping("/selectByTag")
    public String itemListByTag(Model model,
                                @RequestParam(name = "tag") String tag) {
        model.addAttribute("allItems", itemService.getByTag(tag));
        return "itemAdmin";
    }

    @PostMapping("/selectByDescription")
    public String itemListByDescription(Model model,
                                        @RequestParam(name = "description") String description) {
        model.addAttribute("allItems", itemService.getByDescription(description));
        return "itemAdmin";
    }

    @GetMapping("/addItem")
    public String addItemPage(Model model) {
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(Model model,
                          @ModelAttribute("item") @Valid Item item) {
        itemService.save(item);
        return "redirect:/admin/select";
    }

    @GetMapping("/editItem/{id}")
    public String editItemPage(Model model,
                               @PathVariable("id") Long id) {
        Item item = itemService.getById(id);
        if (!item.getUsers().isEmpty()) {
            model.addAttribute("messageForUpdate", "if you update, will be send email users where have this item in basket");
        }
        model.addAttribute("item", item);
        return "updateItem";
    }

    @PutMapping("/editItem")
    public String editItem(Model model,
                           @ModelAttribute("item") @Valid Item item) {
        Item oldItem = itemService.getById(item.getId());
        if (!oldItem.getUsers().isEmpty()) {
            item.setUsers(oldItem.getUsers());
            for (User user : oldItem.getUsers()) {
                try {
                    emailService.sendMessage(user.getEmail(), EmailCreation.getWARN(),
                            EmailCreation.getInstance().updateEmailMessage(oldItem, item));
                } catch (MailException mailException) {
                    mailException.printStackTrace();
                }
            }
        }
        itemService.update(item);
        return "redirect:/admin/select";
    }

    @GetMapping(value = "/deleteItem/{id}")
    public String deleteItem(Model model,
                             @PathVariable("id") Long id) {
        itemService.delete(id);
        return "redirect:/admin/select";
    }

}
