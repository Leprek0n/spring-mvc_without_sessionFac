package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UsersDao;
import web.models.User;



@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersDao usersDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersDao.getUserList());
        return "users/users";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDao.getUserById(id));
        return "users/userById";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")  User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "users/new";
        }
        usersDao.save(user);
        return"redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersDao.getUserById(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")  User user,BindingResult bindingResult ,@PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "users/edit";
        }
        usersDao.update(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersDao.delete(id);
        return "redirect:/users";
    }

}
