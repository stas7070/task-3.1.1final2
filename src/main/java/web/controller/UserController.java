package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUser());
        return "allUsers";
    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") Long id, @ModelAttribute("user") User user){
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
