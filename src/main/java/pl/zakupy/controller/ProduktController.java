package pl.zakupy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zakupy.model.Produkt;
import pl.zakupy.repository.ProduktRepository;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProduktController {


    @Autowired
//    @Qualifier("produkt")
    private ProduktRepository produktRepository;



    @GetMapping("/products")
    public String viewProducts(Model model){
       model.addAttribute("products",produktRepository.findAll());
        System.out.println("Czy wyswietla");
//        List<Produkt> listaproduktow = new ArrayList<>();
//        listaproduktow.add(new Produkt(1,"cukier","kg",2.0,null));
//        listaproduktow.add(new Produkt(1,"maka","kg",2.0,null));
//        model.addAttribute("products",listaproduktow);
        return "productList";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model){
        return "addproduct";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute Produkt produkt){
        produktRepository.save(produkt);
        return "redirect:products";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam int id){
        produktRepository.deleteById(id);
        return "redirect:products";
    }



}
