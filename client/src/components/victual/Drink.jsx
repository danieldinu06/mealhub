import React, {useEffect, useState} from 'react'
import {useParams} from "react-router-dom";
import './Meal.css';
import DrinksService from "../../services/drinks.service";
import {useAtom} from "jotai";
import {orderState} from "../../state";

export default function Drink() {
    const { id } = useParams();
    const [drinks, setDrinks] = useState([]);
    const [orderDrinks, setOrderDrinks] = useAtom(orderState.order.drinks);

    function handleClick(drink) {
        setOrderDrinks(prev => [...prev, drink]);
    }

    useEffect(() => {
        DrinksService.getDrinks(id)
            .then(response => setDrinks(response.data))
            .catch(error => console.log(error));
    });

    return(
        <div className="grid gap-10">
            <div>
                <p className={"type"}>
                    Drinks
                </p>
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
                                <button className={"addVictual"} onClick={() => handleClick(drink)}>+</button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}