package com.recorg.recipeorganizer.controller;


import com.recorg.recipeorganizer.entity.RecipeOrgUser;
import com.recorg.recipeorganizer.service.RecipeOrgUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeOrgUserRestController {

    private RecipeOrgUserService recipeOrgUserService;

    public RecipeOrgUserRestController(RecipeOrgUserService theRecipeOrgUserService) {
        recipeOrgUserService = theRecipeOrgUserService;
    }

    @GetMapping("/users")
    public List<RecipeOrgUser> getUsers() {
        return recipeOrgUserService.getRecipeOrgUsers();
    }

    @GetMapping("/users/{userId}")
    public RecipeOrgUser getUserById(@PathVariable int userId) {
        RecipeOrgUser theRecipeOrgUser = recipeOrgUserService.getRecipeOrgUser(userId);

        if (theRecipeOrgUser == null) {
            throw new RuntimeException("User with the id of " + userId + " not found.");
        }

        return theRecipeOrgUser;
    }

    @PostMapping("/users")
    public RecipeOrgUser saveUser(@RequestBody RecipeOrgUser theRecipeOrgUser) {

        theRecipeOrgUser.setId(0);

        recipeOrgUserService.saveRecipeOrgUser(theRecipeOrgUser);

        return theRecipeOrgUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        RecipeOrgUser tempUser = recipeOrgUserService.getRecipeOrgUser(userId);

        if (tempUser == null) {
            throw new RuntimeException("Cannot find the User with the id of " + userId);
        }

        recipeOrgUserService.deleteRecipeOrgUser(userId);

        return "Deleted the user with the id of " + userId;
    }
}
