package pl.wojciechgalka.bazydanych.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wojciechgalka.bazydanych.models.BarcodeEntity;
import pl.wojciechgalka.bazydanych.models.ServiceEntity;
import pl.wojciechgalka.bazydanych.models.forms.BarcodeForm;
import pl.wojciechgalka.bazydanych.models.forms.SearchForm;
import pl.wojciechgalka.bazydanych.models.repositories.BarcodeRepository;
import pl.wojciechgalka.bazydanych.models.repositories.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository; // = new BarcodeRepostitory();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes", barcodeRepository.findAllByProductCompanyContains("test"));
        return "addBarcode";
    }

    @PostMapping("/")
    public String index(@ModelAttribute BarcodeForm barcodeForm) {
        BarcodeEntity barcodeEntity = new BarcodeEntity(barcodeForm);
        barcodeRepository.save(barcodeEntity);
        return "Dodano do bazy";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        List<BarcodeEntity> barcodeEntityList = new ArrayList<>();
        barcodeEntityList.addAll(barcodeRepository.findAllByProductCompanyContains(search));
        barcodeEntityList.addAll(barcodeRepository.findAllByProductNameContains(search));

        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes", barcodeEntityList);
        return "addBarcode";
    }
}