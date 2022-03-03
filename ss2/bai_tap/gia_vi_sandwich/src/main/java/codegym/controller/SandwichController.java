package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @RequestMapping("")
    public String index(){
        return "/index";
    }

    @PostMapping("save")
    public ModelAndView save(@RequestParam(value = "condiment" , defaultValue = "0") String[] condiment, ModelAndView model){
        ModelAndView modelAndView;
        if(condiment[0].equals("0")){
            modelAndView = new ModelAndView("index", "result", "chon gia vi di");
        } else {
            modelAndView = new ModelAndView("index", "result", condiment);
        }

        return modelAndView;
    }
}
