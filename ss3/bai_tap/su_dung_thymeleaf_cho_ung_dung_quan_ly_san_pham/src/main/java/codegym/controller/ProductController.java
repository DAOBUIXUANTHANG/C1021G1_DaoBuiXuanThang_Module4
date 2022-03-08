package codegym.controller;

import codegym.model.Product;
import codegym.service.ProductService;
import codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);

        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product){
        product.setId((int)(Math.random() * 1000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
//
    @PostMapping("saveEdit")
    public String SaveEdit(Product product){
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
//
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id , Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product customer){
        productService.remove(customer.getId());
        return "redirect:/product";
    }
//
    @GetMapping("/view/{id}")
    public String showView(@PathVariable Integer id , Model model){
        model.addAttribute("product", productService.findById(id));
        return "/view1";
    }

    @GetMapping("/search")
    public String Seach(@RequestParam String search, Model model){
        model.addAttribute("search", productService.findByName(search));
        return "/search";
    }
}
