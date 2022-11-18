import React, {useState} from 'react'
import {useParams} from "react-router-dom";
import './Meal.css';
import DrinksService from "../../services/data/drinks.service";
import {useAtom} from "jotai";
import {orderState} from "../../state";

export default function Drink() {
    const { id } = useParams();
    const [drinks, setDrinks] = useState([]);
    const [orderDrinks, setOrderDrinks] = useAtom(orderState.order.drinks);
    const [price, setPrice] = useAtom(orderState.order.price);

    DrinksService.getDrinks(id)
        .then(response => setDrinks(response.data))
        .catch(error => console.log(error));

    function addToCart(drink) {
        let index = orderDrinks.findIndex(obj => obj.id === drink.id);

        if (index >= 0) {
            let newOrderMeals = [...orderDrinks];
            newOrderMeals[index].quantity++;

            setOrderDrinks(newOrderMeals);
        } else {
            orderDrinks.push(drink);
            orderDrinks[orderDrinks.length - 1].quantity = 1;
            setOrderDrinks(orderDrinks);
        }

        setPrice(price + drink.price);
    }

    return(
        <div>
            <div className={"grid grid-cols-3 gap-2"}>
                {drinks.map(drink => (
                    <div className={"product"} key={drink.id}>
                        <div className={"grid grid-cols-2 p-1"}>
                            <img src={drink.image} alt="No drink" className={"drinkImage"}/>
                            <div className="p-3">
                                <p>
                                    {drink.name}
                                </p>
                            </div>
                        </div>

                        <div className={"cardBottom"}>
                            <p>
                                {drink.price} RON
                            </p>
                            <button className={"addVictual"} onClick={() => addToCart(drink)}>+</button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}