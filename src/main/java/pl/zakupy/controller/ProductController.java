package pl.zakupy.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zakupy.model.Product;
import pl.zakupy.repository.ProductRepository;


import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {


    @Autowired
//    @Qualifier("produkt")
    private ProductRepository productRepository;


    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> listaProduktow = new ArrayList<>();
        productRepository.findAll().forEach(listaProduktow::add);
        listaProduktow.forEach(a -> {
            if (a.getLink() != null && !a.getLink().isEmpty()){
                try {
                    Document doc = Jsoup.connect(a.getLink()).get();
                    Elements pricesElement = doc.select(".basket-product-single-data-row > div > strong");
                    double price = Double.parseDouble(pricesElement.get(0).text().replace(',','.'));
                    a.setPrice(price);
                } catch (Exception e) {
                  //  e.printStackTrace();
                }
            }
        });
        model.addAttribute("products", listaProduktow);

        System.out.println("does it display");
        return "products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@ModelAttribute Product produkt) {
        productRepository.save(produkt);
        return "redirect:/products";
    }

    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam int productId) {
        productRepository.deleteById(productId);
        return "redirect:/products";
    }

    @GetMapping("/products/edit")
    public String editProduct(@RequestParam int productId, Model model,
                              @ModelAttribute Product product) {
        model.addAttribute("product", productRepository.findById(productId));
        return "addproduct";
    }


}
