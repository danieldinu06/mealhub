import React, {useState} from 'react'
import {Link, useParams} from "react-router-dom";
import Order from "./Order";
import {useAtom} from "jotai";
import {orderState} from "../../state";
import RestaurantService from "../../services/data/restaurant.service";
import OrderService from "../../services/data/order.service";

export default function OrderPanel() {
    const {id} = useParams();
    const [meals, ] = useAtom(orderState.order.meals);
    const [drinks, ] = useAtom(orderState.order.drinks);
    const [price, ] = useAtom(orderState.order.price);
    const [restaurant, setRestaurant] = useState();

    RestaurantService.getRestaurant(id)
        .then(response => setRestaurant(response.data))
        .catch(error => console.log(error));

    function handleCheckout() {
        console.log(meals);
        OrderService.createOrder(price, 0, restaurant, null, drinks, meals)
            .then(r => console.log(r));
    }

    return(
        <div>
            <div className="flex justify-center sticky top-0">
                <div className="rounded-lg shadow-lg bg-white max-w-sm border-l-2">
                    <div className="p-6">
                        <h5 className="text-gray-900 text-xl font-medium pb-10">My Order</h5>

                        <p className="text-gray-700 text-base font-serif">
                            Delivery Address
                        </p>

                        <p className="text-black text-2xl mb-1 font-serif">
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

                        <Order/>

                        <div className="mt-12 border-t-2 grid grid-cols-2">
                            <p className="mt-3 font-light text-sm">
                                Subtotal
                            </p>
                            <p className="mt-3 font-bold text-sm justify-self-end">
                                {price} $
                            </p>
                            <p className="font-light text-sm">
                                Delivery fee
                            </p>
                            <p className="font-bold text-sm justify-self-end">
                                {restaurant ? restaurant.deliveryFee : 0} $
                            </p>
                        </div>

                        <div className="mt-6 grid grid-cols-2 border-orange-500 bg-orange-500 rounded-md">
                            <input className="p-2 border-2 border-orange-500 rounded-md" type="text" placeholder="Coupon"/>
                            <button className="p-2 justify-self-center rounded-md">
                                Add coupon
                            </button>
                        </div>

                        <div className="mt-6 border-t-2 grid grid-cols-2">
                            <p className="mt-3 font-light text-sm">
                                Total
                            </p>
                            <p className="mt-3 font-bold text-sm justify-self-end">
                                {price + (restaurant ? restaurant.deliveryFee : 0)} $
                            </p>
                        </div>

                        <div className="mt-6 flex justify-center">
                            <Link to={"/checkout"}>
                                <button className="p-2 rounded-md bg-orange-500 w-36" onClick={() => handleCheckout()}>
                                    Checkout
                                </button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}