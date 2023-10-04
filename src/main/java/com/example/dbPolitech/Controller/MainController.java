package com.example.dbPolitech.Controller;

import com.example.dbPolitech.dto.UserDto;
import com.example.dbPolitech.model.User;
import com.example.dbPolitech.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = { "/successUser" }, method = RequestMethod.POST)
    public String succesUser(Model model, @ModelAttribute("personForm") UserDto userDto) {

        boolean userSuccess = userRepo.findAll()
                .stream()
                .filter(x -> x.getName().equals(userDto.getName())
                        && x.getPassword().equals(userDto.getPassword()))
                .findFirst()
                .isEmpty();

        if(!userSuccess)
        {
            return "redirect:/startPage";
        }

        return "login";
    }
}
