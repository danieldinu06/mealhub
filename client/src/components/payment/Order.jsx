import React, {useEffect, useState} from 'react';
import {orderState} from "../../state";
import {useAtom} from "jotai";
import "./Order.css"

const Order = () => {
    const [meals, ] = useAtom(orderState.order.meals);
    const [drinks, ] = useAtom(orderState.order.drinks);

    const [order, setOrder] = useState({meals, drinks});

    useEffect(() => {
        console.log(meals);

        setOrder(
            prevOrder => ({
                ...prevOrder,
                meals,
                drinks
            })
        );

    }, [meals, drinks]);

    return (
        <div className="mt-20 flex flex-col gap-4">
            {order.meals.map(meal => (
                <div className="bg-gray-200 h-28 shadow-md rounded-md grid grid-cols-2" key={meal.id}>
                    <img className={"h-28"} src={meal.image} alt="Food"/>
                    <div className="grid grid-rows-3 gap-3 elements">
                        <div>
                            {meal.name}
                        </div>
                        <div className={"font-bold"}>
                            {meal.price * meal.quantity} RON
                        </div>
                        <div className={"font-bold quantityPanel"}>
                            <button className={"decrease"}>
                                -
                            </button>
                            <div className={"quantity"}>
                                {meal.quantity}
                            </div>
                            <button className={"increase"}>
                                +
                            </button>
                        </div>
                    </div>
                </div>
            ))}

            {order.drinks.map(drink => (
                <div className="bg-gray-200 h-28 shadow-md rounded-md grid grid-cols-2" key={drink.id}>
                    <img className={"h-28"} src={drink.image} alt="Food"/>
                    <div className="grid grid-rows-3 gap-3 elements">
                        <div>
                            {drink.name}
                        </div>
                        <div className={"font-bold"}>
                            {drink.price * drink.quantity} RON
                        </div>
                        <div className={"font-bold quantityPanel"}>
                            <button className={"decrease"}>
                                -
                            </button>
                            <div className={"quantity"}>
                                {drink.quantity}
                            </div>
                            <button className={"increase"}>
                                +
                            </button>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
};

export default Order;