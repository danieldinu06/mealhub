import React, {useEffect, useState} from 'react';
import {orderState} from "../../state";
import {useAtom} from "jotai";

const Order = () => {
    const [meals, ] = useAtom(orderState.order.meals);
    const [drinks, ] = useAtom(orderState.order.drinks);

    const [order, setOrder] = useState({meals, drinks});

    useEffect(() => {
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
                <div className="bg-gray-200 shadow-md rounded-md grid grid-cols-2 gap-3" key={meal.id}>
                    <div>
                        <img src={meal.image} alt="Food"/>
                    </div>
                    <div className="grid grid-rows-3 gap-3">
                        <div>
                            {meal.name}
                        </div>
                        <div className={"font-bold"}>
                            {meal.price} $
                        </div>
                        <div className={"text-red-700 font-bold flex justify-between"}>
                            <div>
                                {meal.quantity}
                            </div>
                            {/*<button className={"mr-2"} onClick={() => handleReduce}>*/}
                            {/*    less*/}
                            {/*</button>*/}
                        </div>
                    </div>
                </div>
            ))}

            {order.drinks.map(drink => (
                <div className="bg-gray-200 shadow-md rounded-md grid grid-cols-3 gap-3" key={drink.id}>
                    <div>
                        <img src={drink.image} alt="Food"/>
                    </div>
                    <div className="grid grid-rows-2 gap-3">
                        <div>
                            {drink.name}
                        </div>
                        <div>
                            {drink.quantity}
                        </div>
                    </div>
                    <div>
                        {drink.price}
                    </div>
                </div>
            ))}
        </div>
    );
};

export default Order;