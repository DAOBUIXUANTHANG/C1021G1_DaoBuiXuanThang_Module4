package codegym.controller;

import codegym.model.Customer;
import codegym.service.CustomerService;
import codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer){
        customer.setId((int)(Math.random() * 1000));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable  int id , Model model){
        model.addAttribute("customerEdit", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("saveEdit")
    public String SaveEdit(Customer customer){
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id , Model model){
        model.addAttribute("customer1",customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable Integer id , Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/view1";
    }
}
