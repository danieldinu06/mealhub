package com.danieldinu.mealhub.config;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.model.utils.DrinkType;
import com.danieldinu.mealhub.model.utils.MealType;
import com.danieldinu.mealhub.service.DrinkService;
import com.danieldinu.mealhub.service.MealService;
import com.danieldinu.mealhub.service.RestaurantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Configurator {
    @Bean
    CommandLineRunner commandLineRunner(RestaurantService restaurantService, MealService mealService, DrinkService drinkService) {
        return args -> {

            /*
             *   RESTAURANTS
             */
            Restaurant dristorBudapesta = new Restaurant("Dristor Kebap",
                    "/images/restaurants/dristor.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d38330.807210756866!2d26.12252046937397!3d44.43409982534479!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ff05004b659f%3A0x7b37201482b1a05e!2sDristor%20Doner%20Kebap!5e0!3m2!1sro!2sro!4v1657113864534!5m2!1sro!2sro",
                    2.0);

            Restaurant mcDonaldsVitan = new Restaurant("McDonald's",
                    "/images/restaurants/mcdonalds.png",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d32240.666474904494!2d26.115948603277783!3d44.41881711917117!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1fee5f3a35dad%3A0x8cc8bb4309048df3!2sMcDonald&#39;s!5e0!3m2!1sro!2sro!4v1657114250324!5m2!1sro!2sro",
                    8.0);

            Restaurant tacoBellTitan = new Restaurant("Taco Bell",
                    "/images/restaurants/tacobell.png",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d45595.191960599834!2d26.11582720979917!3d44.41881176930752!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ffcd9de8fc9d%3A0xf7cea864c85927b1!2sTaco%20Bell!5e0!3m2!1sro!2sro!4v1657114423643!5m2!1sro!2sro",
                    6.99);

            restaurantService.addRestaurants(List.of(dristorBudapesta, mcDonaldsVitan, tacoBellTitan));


            /*
             *   MEALS
             */

            Meal papanasi = new Meal(
                    "Papanasi",
                    "/images/papanasi.jpg",
                    "branza de vaci grasa, faina, praf de copt, oua, sare, zahar vanilat, coaja rasa de la lamaie, ulei",
                    18.00,
                    MealType.DESERT
                    );
            Meal gogosi = new Meal(
                    "Gogosi",
                    "/images/gogosi.jpg",
                    "faina, galbenusuri de ou, lapte, zahar vanilat, sare, coaja de lamaie, zahar, drojdie, zahar pudra vanilat, ulei",
                    13.00,
                    MealType.DESERT
            );

            mealService.addMeals(dristorBudapesta, List.of(papanasi, gogosi));


            /*
             *   DRINKS
             */

            Drink cola = new Drink(
                    "Coca-Cola",
                    "/images/cola.jpg",
                    7.00,
                    DrinkType.NONALCOHOLIC
            );
            Drink colaZero = new Drink(
                    "Coca-Cola Zero",
                    "/images/colazero.jpg",
                    7.00,
                    DrinkType.NONALCOHOLIC
            );
            Drink fanta = new Drink(
                    "Fanta",
                    "/images/fanta.jpg",
                    7.00,
                    DrinkType.NONALCOHOLIC
            );
            Drink sprite = new Drink(
                    "Sprite",
                    "/images/sprite.jpg",
                    7.00,
                    DrinkType.NONALCOHOLIC
            );

            drinkService.addDrinks(dristorBudapesta, List.of(cola, colaZero, fanta, sprite));
            drinkService.addDrinks(mcDonaldsVitan, List.of(cola, colaZero, fanta, sprite));
            drinkService.addDrinks(tacoBellTitan, List.of(cola, colaZero, fanta, sprite));

        };
    }
}
