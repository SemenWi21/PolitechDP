package com.example.dbPolitech.Controller;

import com.example.dbPolitech.model.Product;
import com.example.dbPolitech.repo.CategoryRepo;
import com.example.dbPolitech.repo.ProductRepo;
import com.example.dbPolitech.repo.VendorRepo;
import com.example.dbPolitech.service.NameColumn;
import com.example.dbPolitech.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/startPage")
public class FoodController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private VendorRepo vendorRepo;
    @Autowired
    private SaveService saveService;
    @Autowired
    private NameColumn nameColumn;

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String all(Model model) {

        model.addAttribute("List", productRepo.findAll());
        model.addAttribute("nameColumn", nameColumn.getColumnNameProduct());
        model.addAttribute("parametr", "product");

        return "startPage";
    }

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public String product(Model model) {

        model.addAttribute("List", productRepo.findAll());
        model.addAttribute("nameColumn", nameColumn.getColumnNameProduct());
        model.addAttribute("parametr", "product");

        return "startPage";
    }

    @GetMapping("/category")
    public String category(Model model) {

        model.addAttribute("List", categoryRepo.findAll());
        model.addAttribute("nameColumn", nameColumn.getColumnNameCategory());
        model.addAttribute("parametr", "category");

        return "startPage";
    }

    @GetMapping("/vendor")
    public String vendor(Model model) {

        model.addAttribute("List", vendorRepo.findAll());
        model.addAttribute("nameColumn", nameColumn.getColumnNameVendor());
        model.addAttribute("parametr", "vendor");

        return "startPage";
    }

    @GetMapping("/add/{prm}")
    public String add(Model model, @PathVariable String prm) {

        model.addAttribute("parametr", prm);

        switch (prm) {
            case "product": model.addAttribute("nameColumn", nameColumn.getColumnNameProduct());
            break;
            case "vendor": model.addAttribute("nameColumn", nameColumn.getColumnNameVendor());
            break;
            case "category": model.addAttribute("nameColumn", nameColumn.getColumnNameCategory());
            break;
        }

        return "add";
    }

    @RequestMapping(value = { "/add/{prm}" }, method = RequestMethod.POST)
    public String addPost(Model model, @PathVariable String prm,
                          @RequestParam Object first,
                          @RequestParam Object second,
                          @RequestParam Object three)
    {
        switch (prm) {
            case "product": saveService.saveProduct(first,second,three);
                break;
            case "vendor": saveService.saveVendor(first,second,three);
                break;
            case "category": saveService.saveCategory(first,second,three);
                break;
        }

        return "redirect:/startPage/"+prm;
    }

    @RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
    public String delete(Model model, @RequestParam String id,@RequestParam String prm) {
        switch (prm) {
            case "product": productRepo.deleteById(Long.valueOf(id));
                break;
            case "vendor": vendorRepo.deleteById(Long.valueOf(id));
                break;
            case "category": categoryRepo.deleteById(Long.valueOf(id));
                break;
        }

        return "redirect:/startPage/"+prm;
    }
}
