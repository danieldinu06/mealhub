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
        <div>
            {drinks.map(meal => (
                <h1>{meal.name}</h1>
            ))}
        </div>
    );
}