import React, {useEffect, useState} from 'react'
import {useParams} from "react-router-dom";
import './Meal.css'
import MealsService from "../../services/meals.service";
import {useAtom} from "jotai";
import {orderState} from "../../state";

export default function Meal() {
    const { id } = useParams();
    const [meals, setMeals] = useState([]);
    const [orderMeals, setOrderMeals] = useAtom(orderState.order.meals);

    function handleClick(meal) {
        setOrderMeals(prev => [...prev, meal]);
    }

    useEffect(() => {
        MealsService.getMeals(id)
            .then(response => setMeals(response.data))
            .catch(error => console.log(error));
    });

    return(
        <div className="grid gap-10">
            <div>
                <p className={"type"}>
                    Meals
                </p>
                <div className={"grid grid-cols-3 gap-2"}>
                    {
                        meals.map(
                            meal => (
                                <div className={"product"} key={meal.id}>
                                    <div className={"grid grid-cols-2 p-1"}>
                                        <img src={meal.image} alt="No meal" className={"mealImage"}/>
                                        <div className="grid p-3">
                                            <p>
                                                {meal.name}
                                            </p>
                                            <p className={"ingredients"}>
                                                {meal.ingredients}
                                            </p>
                                        </div>
                                    </div>

                                    <div className={"cardBottom"}>
                                        <p>
                                            {meal.price} RON
                                        </p>
                                        <button className={"addVictual"} onClick={() => handleClick(meal)}>+</button>
                                    </div>
                                </div>
                            )
                        )
                    }
                </div>
            </div>
        </div>
    );
}