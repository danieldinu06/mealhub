import React, {useState} from 'react'
import {useParams} from "react-router-dom";
import './Meal.css'
import MealsService from "../../services/data/meals.service";
import {useAtom} from "jotai";
import {orderState} from "../../state";

export default function Meal() {
    const { id } = useParams();
    const [meals, setMeals] = useState([]);
    const [orderMeals, setOrderMeals] = useAtom(orderState.order.meals);
    const [price, setPrice] = useAtom(orderState.order.price);

    MealsService.getMeals(id)
        .then(response => setMeals(response.data))
        .catch(error => console.log(error));

    function addToCart(meal) {
        let index = orderMeals.findIndex(obj => obj.id === meal.id);

        if (index >= 0) {
            let newOrderMeals = [...orderMeals];
            newOrderMeals[index].quantity++;

            setOrderMeals(newOrderMeals);
        } else {
            orderMeals.push(meal);
            orderMeals[orderMeals.length - 1].quantity = 1;
            setOrderMeals(orderMeals);
        }

        setPrice(price + meal.price);
    }

    return(
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
                                    <button className={"addVictual"} onClick={() => addToCart(meal)}>+</button>
                                </div>
                            </div>
                        )
                    )
                }
            </div>
    );
}