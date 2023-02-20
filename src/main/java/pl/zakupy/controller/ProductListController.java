package pl.zakupy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.zakupy.model.Position;
import pl.zakupy.model.ProductList;
import pl.zakupy.model.Product;
import pl.zakupy.model.ProductSelectItem;
import pl.zakupy.repository.PositionRepository;
import pl.zakupy.repository.ProductListRepository;
import pl.zakupy.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductListController {

    @Autowired
    private ProductListRepository productListRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/lists")
    public String getList(Model model){
        model.addAttribute("productlists", productListRepository.findAll());
        List<ProductList> lista = new ArrayList<>();
        productListRepository.findAll().forEach(s -> lista.add(s));
        lista.forEach(s -> System.out.println(s.getId() + " " + s.getPosition().size()));
        return "lists";
    }

    @GetMapping("/addlist")
    public String addList(Model model){
        ProductList productList = new ProductList();
        productList.setId(0);
        model.addAttribute("productList",productList);
        model.addAttribute("action","savelist");
        Iterable<Product> listapro = productRepository.findAll();
        List<ProductSelectItem> listSelect = new ArrayList<>();
        for (Object p : listapro){
            Product pr = (Product) p;
            ProductSelectItem productSelectItem = new ProductSelectItem(pr.getId(),pr.getName(),false);
            listSelect.add(productSelectItem);
        }
        model.addAttribute("products",listSelect);

        return"addlist";
    }

    @PostMapping("/save")
    public String saveEdit(@ModelAttribute ProductList productList) {
        productList.setPosition(new ArrayList<>());
        for (Integer p : productList.getTablica()) {
            Optional<Product> product = productRepository.findById(p);
            boolean aBoolean = positionRepository.existsByProductIdAndProductListId(p, productList.getId());
            if (product.isPresent()) {
                Position position = new Position(0, 1, false, product.get(), productList);
                productList.getPosition().add(position);

                positionRepository.save(position);
            }

        }
        productListRepository.save(productList);
        return "redirect:/lists";
    }

      @PostMapping("/savelist")//zrobic nowego endpoit dla zapisu edycji bo przy edycji czysci nam liste
      public String saveList(@ModelAttribute ProductList productList){
          System.out.println(" Data zakupu; " + productList.getData());
          productListRepository.save(productList);
        productList.setPosition(new ArrayList<>());
        for (Integer p : productList.getTablica()){
            Optional<Product> pr = productRepository.findById(p);
            boolean bool = positionRepository.existsByProductIdAndProductListId(p,productList.getId());
            System.out.println("Wyswietlamy booleana " + bool);
            if (pr.isPresent() && !positionRepository.existsByProductIdAndProductListId(p,productList.getId())) {
                Position position = new Position(0, 1, false, pr.get(),productList);
                productList.getPosition().add(position);
                positionRepository.save(position);
            }

        }

          System.out.println(Arrays.toString(productList.getTablica()));
        return "redirect:/lists";
      }

      @GetMapping("/lists/delete")
    public String deleteProductList(@RequestParam int id){
        Optional<ProductList> elem = productListRepository.findById(id);


        if (elem.isPresent()){
          elem.get().getPosition().forEach(s -> positionRepository.deleteById(s.getId()));
       }

        productListRepository.delete(elem.get());

        return "redirect:/lists";
      }

      @GetMapping("/lists/edit")
    public String editProductList(@RequestParam int id,Model model){
        ProductList productList = productListRepository.findById(id).get();
          model.addAttribute("productList",productList);
          model.addAttribute("action", "save");
          Iterable prodlist = productRepository.findAll();
          List<ProductSelectItem> selectList = new ArrayList<>();

          for (Object p : prodlist){
            Product prod = (Product)p;
            boolean selected = productList.getPosition().stream().anyMatch(s -> s.getProduct().getId() == prod.getId());
              ProductSelectItem pr = new ProductSelectItem();
              pr.setSelected(selected);
              pr.setName(prod.getName());
              pr.setId(prod.getId());
              selectList.add(pr);
              System.out.println(pr.isSelected());
          }


          model.addAttribute("products",selectList);
        return"addlist";
      }

      @GetMapping("/lists/details")
    public String getDetails(@RequestParam int id, Model model){
          ProductList productList1 = productListRepository.findById(id).get();
          model.addAttribute("productList" ,productList1);
          return "details";
      }



}
