import React from 'react'
import {useAtom} from "jotai";
import {orderState} from "../../state";
import StripeCheckout from "react-stripe-checkout";
import axios from "axios";
import {toast} from "react-toastify";
import {delay} from "../page/Register";
import {useNavigate} from "react-router-dom";
import './Checkout.css'

export default function Checkout() {

    const navigate = useNavigate();
    const [meals, ] = useAtom(orderState.order.meals);
    const [drinks, ] = useAtom(orderState.order.drinks);
    const [price, ] = useAtom(orderState.order.price);

    const onToken = (token) => {
        axios.post('http://localhost:8888/api/public/payment/create-charge', {
            amount: price + 2.99,
            email: "dinudaniel0604@gmail.com",
            token
        }).then(async r => {
            toast.success("Payment successfull, please wait!");

            await delay(3000);
            navigate("/restaurants");
        })
    }

    return(
        <div className={"checkout"}>
            <div className="grid grid-rows-1 mt-10 gap-10 elements">
                <div>
                    {meals.map(meal => (
                        <div className="shadow-md grid grid-cols-2 h-36 gap-3" key={meal.id}>
                            <img className="rounded-md h-36" src={meal.image} alt="Food"/>
                            <div className="text-xl grid">
                                <div>
                                    {meal.name}
                                </div>
                                <div className="grid grid-cols-2">
                                    {meal.price} $
                                    <div className="text-xl">
                                        x {meal.quantity}
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}

                    {drinks.map(drink => (
                        <div className="shadow-md grid grid-cols-2 h-36 gap-3" key={drink.id}>
                            <img className="rounded-md h-36" src={drink.image} alt="Food"/>
                            <div className="text-xl grid">
                                <div>
                                    {drink.name}
                                </div>
                                <div className="grid grid-cols-2">
                                    {drink.price} $
                                    <div className="text-xl">
                                        x {drink.quantity}
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>

            </div>

            <div className={"panel"}>
                <p className="text-gray-700 text-xl font-serif mt-10">
                    Delivery Address
                </p>

                <p className="text-black text-4xl mb-1 font-serif">
                    4-6 Semilunei
                </p>

                <div className="flex flex-row gap-10 items-center">
                    <div className="flex flex-row items-center">
                        <svg xmlns="http://www.w3.org/2000/svg" className="h-4 text-center align flex flex-center" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={2}>
                            <path strokeLinecap="round" strokeLinejoin="round" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
                        </svg>
                        <p>
                            40 min
                        </p>
                    </div>
                    <div className="flex flex-row items-center">
                        <svg xmlns="http://www.w3.org/2000/svg" className="h-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={2}>
                            <path strokeLinecap="round" strokeLinejoin="round" d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                            <path strokeLinecap="round" strokeLinejoin="round" d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                        </svg>
                        <p>
                            6kms
                        </p>
                    </div>
                </div>

                <div className="grid grid-rows-3 grid-cols-2 mt-20">
                    <p className="font-light text-lg">
                        Delivery fee
                    </p>
                    <p className="font-bold text-lg">
                        2.99 $
                    </p>
                    <p className="text-xl">Total:</p>
                    <div className="text-red-700 text-xl">
                        {price + 2.99} $
                    </div>
                </div>

                <div>
                    <StripeCheckout
                        amount={price * 100 + 299}
                        label={"Pay"}
                        name={"Daniel"}
                        description={`Your total is ${price + 2.99}$`}
                        panelLabel={"Pay"}
                        token={onToken}
                        stripeKey={'pk_test_51Ll4i1AcY67GDOtFB3us2rtQrmkAE2IRMEPJOFxQFHRnumAOEC7q4ZErnjlbvWeEdo5cUF2BttAocFSxvrd4Nkts00sj0cbtDi'}
                        currency={"RON"}
                    />
                </div>
            </div>
        </div>

    );
}
