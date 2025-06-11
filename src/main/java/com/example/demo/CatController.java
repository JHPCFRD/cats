package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public Object getAllCats(Model model) {
        model.addAttribute("catslist", catService.getAllCats());
        model.addAttribute("Title", "AllCats");
        return "cat-list";
    }

    @GetMapping("/{catId}")
    public Object getCatById(@PathVariable Long catId, Model model) {
        model.addAttribute("cat", catService.getCatById(catId));
        model.addAttribute("Title", "Cat #" + catId);
        return "cat-details";
    }

    @GetMapping("/new")
    public Object showCreateForm(Model model) {
        Cat cat = new Cat();
        model.addAttribute("cat", cat);
        model.addAttribute("Title", "Create New Cat");
        return "cat-create";
    }

    @GetMapping("/edit/{catId}")
    public Object showUpdateForm(@PathVariable Long catId, Model model) {
        model.addAttribute("cat", catService.getCatById(catId));
        return "cat-update";
    }

    @PostMapping("/new")
    public Object createCat(@ModelAttribute Cat cat, Model model) {
        try {
            Cat newCat = catService.addCat(cat);
            return "redirect:/cats";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create cat");
            return "cat-create";
        }
    }

    @PostMapping("/update")
    public Object updateCat(@ModelAttribute Cat cat) {
        catService.updateCat(cat.getCatId(), cat);
        return "redirect:/cats/" + cat.getCatId();
    }

    @GetMapping("/delete/{catId}")
    public Object deleteCat(@PathVariable Long catId) {
        catService.deleteCat(catId);
        return "redirect:/cats";
    }
}