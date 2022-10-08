package com.danieldinu.mealhub.config;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.model.Role;
import com.danieldinu.mealhub.model.utils.DrinkType;
import com.danieldinu.mealhub.model.utils.MealType;
import com.danieldinu.mealhub.model.utils.RoleType;
import com.danieldinu.mealhub.service.DrinkService;
import com.danieldinu.mealhub.service.MealService;
import com.danieldinu.mealhub.service.OrderService;
import com.danieldinu.mealhub.service.RestaurantService;
import com.danieldinu.mealhub.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Configurator {

    @Bean
    @Autowired
    CommandLineRunner commandLineRunner(
            RestaurantService restaurantService, MealService mealService, DrinkService drinkService,
            RoleService roleService) {
        return args -> {
            /*
             *   ROLES
             */
            Role user = new Role(RoleType.ROLE_USER);
            Role admin = new Role(RoleType.ROLE_ADMIN);

            roleService.addRoles(List.of(user, admin));

            /*
             *   RESTAURANTS
             */
            Restaurant dristorBudapesta = new Restaurant("Dristor Kebap",
                    "/images/restaurants/dristor.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d38330.807210756866!2d26.12252046937397!3d44.43409982534479!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ff05004b659f%3A0x7b37201482b1a05e!2sDristor%20Doner%20Kebap!5e0!3m2!1sro!2sro!4v1657113864534!5m2!1sro!2sro",
                    2.99);

            Restaurant mcDonaldsVitan = new Restaurant("McDonald's",
                    "/images/restaurants/mcdonalds.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d32240.666474904494!2d26.115948603277783!3d44.41881711917117!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1fee5f3a35dad%3A0x8cc8bb4309048df3!2sMcDonald&#39;s!5e0!3m2!1sro!2sro!4v1657114250324!5m2!1sro!2sro",
                    8.99);

            Restaurant tacoBellTitan = new Restaurant("Taco Bell",
                    "/images/restaurants/tacobell.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d45595.191960599834!2d26.11582720979917!3d44.41881176930752!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ffcd9de8fc9d%3A0xf7cea864c85927b1!2sTaco%20Bell!5e0!3m2!1sro!2sro!4v1657114423643!5m2!1sro!2sro",
                    6.99);

            Restaurant kfcOltenitei = new Restaurant("KFC",
                    "/images/restaurants/kfc.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3284.0154016328206!2d26.12090916542096!3d44.39212856308464!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1fe4295e175f3%3A0x2e1a25ce7ad8b354!2sKFC!5e0!3m2!1sro!2sro!4v1662358173213!5m2!1sro!2sro",
                    10.99);

            Restaurant noodlePack = new Restaurant("Noodle Pack",
                    "/images/restaurants/noodlepack.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22787.474627486474!2d26.06327677910156!3d44.444764500000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1fffb51c17b1d%3A0x8df57335782b7c81!2sNoodle%20Pack!5e0!3m2!1sro!2sro!4v1662363307535!5m2!1sro!2sro",
                    5.99);

            Restaurant pizzaHut = new Restaurant("Pizza Hut",
                    "/images/restaurants/pizzahut.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22787.474627486474!2d26.06327677910156!3d44.444764500000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1fffb51c17b1d%3A0x8df57335782b7c81!2sNoodle%20Pack!5e0!3m2!1sro!2sro!4v1662363307535!5m2!1sro!2sro",
                    8.99);

            Restaurant saladBox = new Restaurant("Salad Box",
                    "/images/restaurants/saladbox.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22792.812404421464!2d26.01736517910156!3d44.43107910000002!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b201d017269f2b%3A0xce6334db0f02db3d!2sSalad%20Box!5e0!3m2!1sro!2sro!4v1662363382998!5m2!1sro!2sro",
                    2.99);

            Restaurant starbucks = new Restaurant("Starbucks",
                    "/images/restaurants/starbucks.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22791.29899497869!2d26.06673717498779!3d44.43495963328271!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ffbc1274f4eb%3A0x9b58f5c519d0b4a1!2sStarbucks!5e0!3m2!1sro!2sro!4v1662363411527!5m2!1sro!2sro",
                    12.99);

            Restaurant subway = new Restaurant("Subway",
                    "/images/restaurants/subway.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22790.391731331052!2d26.094374647869362!3d44.43728581956918!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ff3e69984f7f%3A0x1192215d13a73ccb!2sSubway!5e0!3m2!1sro!2sro!4v1662363440810!5m2!1sro!2sro",
                    1.99);

            Restaurant sushiTerra = new Restaurant("Sushi Terra",
                    "/images/restaurants/sushiterra.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22790.368871642935!2d26.094288808373353!3d44.43734442961547!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1f8c57de4d73b%3A0x54568f7424891c10!2sSushi%20Terra!5e0!3m2!1sro!2sro!4v1662363470852!5m2!1sro!2sro",
                    9.99);

            Restaurant uncleJohn = new Restaurant("Uncle John",
                    "/images/restaurants/unclejohn.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d91161.27207997083!2d26.041543777388355!3d44.43747480814718!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ffbfaf179227%3A0xc252c82daddcf449!2sUncle%20John%20Cocor!5e0!3m2!1sro!2sro!4v1662363499042!5m2!1sro!2sro",
                    6.99);

            Restaurant casaDiDinu = new Restaurant("Casa Di Dinu",
                    "/images/restaurants/casadidinu.jpg",
                    "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d868.0852538727087!2d26.11256485671304!3d44.438719898930174!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40b1ffdcc0c770b9%3A0xed0908fac575066b!2sCodecool!5e0!3m2!1sro!2sro!4v1662363559546!5m2!1sro!2sro",
                    3.99);

            List<Restaurant> restaurants = List.of(
                    dristorBudapesta, mcDonaldsVitan, tacoBellTitan,
                    kfcOltenitei, noodlePack, pizzaHut,
                    saladBox, starbucks, subway,
                    sushiTerra, uncleJohn, casaDiDinu);

            restaurantService.addRestaurants(restaurants);


            /*
             *   MEALS
             */

            /*
             * Dristor
             */

            Meal iskenderKebapAmestec = Meal.builder()
                    .name("Iskender Kebap amestec")
                    .image("/images/meals/dristor/iskender/amestec.jpg")
                    .ingredients("carne, iaurt, rosii, patrunjel, crutoane, sos iskender, ardei copti")
                    .price(49.00)
                    .mealType(MealType.ISKENDER)
                    .build();

            Meal iskenderKebapPui = Meal.builder()
                    .name("Iskender Kebap pui")
                    .image("/images/meals/dristor/iskender/pui.jpg")
                    .ingredients("carne, iaurt, rosii, patrunjel, crutoane, sos iskender, ardei copti")
                    .price(45.00)
                    .mealType(MealType.ISKENDER)
                    .build();

            Meal iskenderKebapVita = Meal.builder()
                    .name("Iskender Kebap vita")
                    .image("/images/meals/dristor/iskender/vita.jpg")
                    .ingredients("carne, iaurt, rosii, patrunjel, crutoane, sos iskender, ardei copti")
                    .price(49.00)
                    .mealType(MealType.ISKENDER)
                    .build();

            Meal lipieAmestec = Meal.builder()
                    .name("Lipie amestec")
                    .image("/images/meals/dristor/lipie/amestec.jpg")
                    .ingredients("ardei dulci, carne, rosii, ceapa, ardei picanti, varza alba, castraveti, patrunjel")
                    .price(34.00)
                    .mealType(MealType.LIPIE)
                    .build();

            Meal lipiePui = Meal.builder()
                    .name("Lipie pui")
                    .image("/images/meals/dristor/lipie/pui.jpg")
                    .ingredients("ardei dulci, carne, rosii, ceapa, ardei picanti, varza alba, castraveti, patrunjel")
                    .price(31.00)
                    .mealType(MealType.LIPIE)
                    .build();

            Meal lipieVegetariana = Meal.builder()
                    .name("Lipie vegetariana")
                    .image("/images/meals/dristor/lipie/vegetariana.jpg")
                    .ingredients("ardei dulci, cartofi, rosii, ceapa, ardei picanti, varza alba, castraveti, patrunjel")
                    .price(21.00)
                    .mealType(MealType.LIPIE)
                    .build();

            Meal lipieVita = Meal.builder()
                    .name("Lipie vita")
                    .image("/images/meals/dristor/lipie/vita.jpg")
                    .ingredients("ardei dulci, cartofi, rosii, ceapa, ardei picanti, varza alba, castraveti, patrunjel")
                    .price(38.00)
                    .mealType(MealType.LIPIE)
                    .build();

            Meal meniuLipiePui = Meal.builder()
                    .name("Meniu lipie pui")
                    .image("/images/meals/dristor/meniu/pui.jpg")
                    .ingredients("lipie pui, cartofi, sos, bautura")
                    .price(39.00)
                    .mealType(MealType.MENU)
                    .build();

            Meal meniuLipieAmestec = Meal.builder()
                    .name("Meniu lipie amestec")
                    .image("/images/meals/dristor/meniu/amestec.jpg")
                    .ingredients("lipie amestec, cartofi, sos, bautura")
                    .price(42.00)
                    .mealType(MealType.MENU)
                    .build();

            Meal meniuLipieVita = Meal.builder()
                    .name("Meniu lipie vita")
                    .image("/images/meals/dristor/meniu/vita.jpg")
                    .ingredients("lipie vita, cartofi, sos, bautura")
                    .price(46.00)
                    .mealType(MealType.MENU)
                    .build();

            Meal meniuLipieVegetariana = Meal.builder()
                    .name("Meniu lipie vegetariana")
                    .image("/images/meals/dristor/meniu/vegetariana.jpg")
                    .ingredients("lipie vegetariana, cartofi, sos, bautura")
                    .price(31.00)
                    .mealType(MealType.MENU)
                    .build();

            Meal ciorbaDeBurta = Meal.builder()
                    .name("Ciorba de burta")
                    .image("/images/meals/dristor/diverse/ciorbaBurta.jpg")
                    .ingredients("linte, ardei rosu, patrunjel, usturoi, morcov, ceapa, rosie, dafin")
                    .price(12.00)
                    .mealType(MealType.SOUP)
                    .build();

            Meal micDejun = Meal.builder()
                    .name("Mic dejun")
                    .image("/images/meals/dristor/diverse/micDejun.jpg")
                    .ingredients("oua, masline, branza, castravete, cascaval, cartofi, rosie, unt")
                    .price(38.00)
                    .mealType(MealType.BREAKFAST)
                    .build();

            Meal supaDeLinte = Meal.builder()
                    .name("Supa de linte")
                    .image("/images/meals/dristor/diverse/supaLinte.jpg")
                    .ingredients("smantana, burta de vita, otet, usturoi, pastarnac, telina, ou, morcov, ceapa")
                    .price(17.00)
                    .mealType(MealType.SOUP)
                    .build();

            Meal orezCuLapte = Meal.builder()
                    .name("Orez cu lapte")
                    .image("/images/meals/dristor/desert/orezLapte.jpg")
                    .ingredients("orez, lapte, scortisoara, vanilie, zahar")
                    .price(17.00)
                    .mealType(MealType.DESERT)
                    .build();

            Meal baklava = Meal.builder()
                    .name("Baklava")
                    .image("/images/meals/dristor/desert/baklava.jpg")
                    .ingredients("faina, ou, apa, zahar, lamaie, nuca, unt")
                    .price(4.00)
                    .mealType(MealType.DESERT)
                    .build();

            Meal negresa = Meal.builder()
                    .name("Negresa")
                    .image("/images/meals/dristor/desert/negresa.jpg")
                    .ingredients("faina, ou, lapte, zahar, cacaot")
                    .price(14.00)
                    .mealType(MealType.DESERT)
                    .build();

            List<Meal> dristorMeals = List.of(
                    iskenderKebapPui, iskenderKebapAmestec, iskenderKebapVita,
                    lipiePui, lipieVegetariana, lipieAmestec, lipieVita,
                    meniuLipiePui, meniuLipieVegetariana, meniuLipieAmestec, meniuLipieVita,
                    ciorbaDeBurta, micDejun, supaDeLinte,
                    orezCuLapte, baklava, negresa
            );
            mealService.addMeals(dristorBudapesta, dristorMeals);

            /*
             *   DRINKS
             */

            Drink apaPlata = Drink.builder()
                    .name("Apa plata")
                    .image("/images/drinks/nonalcoholic/apaplata.jpg")
                    .price(6.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();

            Drink apaMinerala = Drink.builder()
                    .name("Apa minerala")
                    .image("/images/drinks/nonalcoholic/apaminerala.jpg")
                    .price(6.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();

            Drink cola = Drink.builder()
                    .name("Coca-Cola")
                    .image("/images/drinks/nonalcoholic/cola.jpg")
                    .price(7.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();

            Drink colaZero = Drink.builder()
                    .name("Coca-Cola Zero")
                    .image("/images/drinks/nonalcoholic/colazera.jpg")
                    .price(7.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();
            Drink fanta = Drink.builder()
                    .name("Fanta")
                    .image("/images/drinks/nonalcoholic/fanta.jpg")
                    .price(7.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();
            Drink sprite = Drink.builder()
                    .name("Sprite")
                    .image("/images/drinks/nonalcoholic/sprite.jpg")
                    .price(7.00)
                    .drinkType(DrinkType.NONALCOHOLIC)
                    .build();

            List<Drink> nonAlcoholic = List.of(apaPlata, apaMinerala, cola, colaZero, fanta, sprite);

            for (Restaurant restaurant : restaurants) {
                drinkService.addDrinks(restaurant, nonAlcoholic);
            }
        };
    }
}
