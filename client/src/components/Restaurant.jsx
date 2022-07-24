import React, {useEffect, useState} from 'react'
import axios from "axios";
import {useParams} from "react-router-dom";
import './Restaurant.css';
import Meal from "./Meal";
import Drink from "./Drink";

export default function Restaurant() {

    const { id } = useParams();
    const [restaurant, setRestaurant] = useState([]);
    const [mealTypes, setMealTypes] = useState([]);
    const [drinks, setDrinks] = useState([]);
    const [drinkTypes, setDrinkTypes] = useState([]);

    useEffect(() => {
        const restaurantUrl = `http://localhost:8080/restaurant/${id}`;
        const drinksUrl = restaurantUrl + '/drinks';

        axios.get(restaurantUrl)
            .then(response => setRestaurant(response.data))
            .catch(error => console.log(error));

        axios.get('http://localhost:8080/meals')
            .then(response => setMealTypes(response.data))
            .catch(error => console.log(error));

        axios.get(drinksUrl)
            .then(response => setDrinks(response.data))
            .catch(error => console.log(error));

        axios.get('http://localhost:8080/drinks')
            .then(response => setDrinkTypes(response.data))
            .catch(error => console.log(error));

    }, [id]);


    return(
        <div className={"centerPanel"}>
            <catalogue>
                {
                    mealTypes.map(
                        (mealType, index) => (
                            <div key={index} className={"mealType"}>
                                {mealType}
                            </div>
                        )
                    )
                }
                {
                    drinkTypes.map(
                        (drinkType, index) => (
                            <div key={index} className={"drinkType"}>
                                {drinkType}
                            </div>
                        )
                    )
                }
            </catalogue>

            <div className={"grid gap-10"}>
                <Meal/>
                <Drink/>
            </div>
        </div>
    );
}