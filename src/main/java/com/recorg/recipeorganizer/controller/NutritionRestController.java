package com.recorg.recipeorganizer.controller;


import com.recorg.recipeorganizer.entity.Nutrition;
import com.recorg.recipeorganizer.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NutritionRestController {

    private NutritionService nutritionService;

    @Autowired
    public NutritionRestController(NutritionService theNutritionService) {
        nutritionService = theNutritionService;
    }

    @GetMapping("/nutritions")
    public List<Nutrition> getNutritions() {
        return nutritionService.getNutritions();
    }

    @GetMapping("/nutritions/{nutritionId}")
    public Nutrition getNutritionById(@PathVariable int nutritionId) {
        Nutrition theNutrition = nutritionService.getNutrition(nutritionId);

        if (theNutrition == null) {
            throw new RuntimeException("Nutrition of id " + nutritionId + " not found");
        }

        return theNutrition;
    }

    @PostMapping("/nutritions")
    public Nutrition saveNutrition(@RequestBody Nutrition theNutrition) {

        theNutrition.setId(0);

        nutritionService.saveNutrition(theNutrition);

        return theNutrition;
    }

    @DeleteMapping("/nutritions/{nutritionId}")
    public String deleteNutrition(@PathVariable int nutritionId) {

        Nutrition tempNutrition = nutritionService.getNutrition(nutritionId);

        if (tempNutrition == null) {
            throw new RuntimeException("Nutrition id not found - " + nutritionId);
        }

        nutritionService.deleteNutrition(nutritionId);

        return "Deleted nutrition of id " + nutritionId;
    }
}
