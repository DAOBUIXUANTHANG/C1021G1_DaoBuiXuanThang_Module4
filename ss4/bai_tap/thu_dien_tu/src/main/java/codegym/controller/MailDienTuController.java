package codegym.controller;

import codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailDienTuController {
    @GetMapping ("")
    public String showForm(Model model){
        model.addAttribute("email", new Email("English", 25, false, "Thor King, Asgard"));
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages",languages);

        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        model.addAttribute("pageSizes",pageSizes);
        return ("index");
    }
    @PostMapping("/showForm")
    public String update(@ModelAttribute("email") Email email, Model model) {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages", languages);
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("mess", "Update successful");
        return "index";
    }
}
