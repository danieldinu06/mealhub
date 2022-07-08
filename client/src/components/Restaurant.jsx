import React, {useEffect, useState} from 'react'
import axios from "axios";
import {useParams} from "react-router-dom";

export default function Restaurant() {

    const { id } = useParams();
    const [restaurant, setRestaurant] = useState([]);
    const [meals, setMeals] = useState([]);
    const [drinks, setDrinks] = useState([]);

    useEffect(() => {
        const restaurantUrl = `http://localhost:8080/restaurant/${id}`;
        const mealsUrl = restaurantUrl + '/meals';
        const drinksUrl = restaurantUrl + '/drinks';

        axios.get(restaurantUrl)
            .then(response => setRestaurant(response.data))
            .catch(error => console.log(error));

        axios.get(mealsUrl)
            .then(response => setMeals(response.data))
            .catch(error => console.log(error));

        axios.get(drinksUrl)
            .then(response => setDrinks(response.data))
            .catch(error => console.log(error));

    }, []);


    return(
        <div className={"grid gap-10"}>
            <div>
                <p className={"mb-5 font-bold text-3xl"}>
                    Type of meals
                </p>
                <div className={"grid grid-cols-3 gap-2"}>
                    {meals.map(meal => (
                        <div className={"grid border-2 border-black rounded-md"} key={meal.id}>
                            <div className={"grid grid-cols-2"}>
                                <img src={meal.image} alt="No meal" className={"max-h-40"}/>
                                <div className="grid grid-rows-2">
                                    <p>
                                        {meal.name}
                                    </p>
                                    <p>
                                        Ingredients
                                    </p>
                                </div>
                            </div>

                            <div className={"grid grid-cols-2 h-12"}>
                                <p>
                                    Price
                                </p>
                                <button className={"bg-orange-400 rounded-md"}>
                                    Add to cart
                                </button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
            <div>
                <p className={"mb-5 font-bold text-3xl"}>
                    Type of drinks
                </p>
                <div className={"grid grid-cols-3 gap-2"}>
                    {drinks.map(drink => (
                        <div className={"grid border-2 border-black rounded-md"} key={drink.id}>
                            <div className={"grid grid-cols-2"}>
                                <img src={drink.image} alt="No meal" className={"max-h-40"}/>
                                <div className="grid grid-rows-2">
                                    <p>
                                        {drink.name}
                                    </p>
                                    <p>
                                        Ingredients
                                    </p>
                                </div>
                            </div>

                            <div className={"grid grid-cols-2 h-12"}>
                                <p>
                                    Price
                                </p>
                                <button className={"bg-orange-400 rounded-md"}>
                                    Add to cart
                                </button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>

    );
}