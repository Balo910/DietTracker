package controllers;

import com.diettracker.backend.models.Food;
import com.diettracker.backend.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    // Pobierz listę produktów
    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    // Dodaj nowy produkt
    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    // Usuń produkt po ID
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
    }
}
