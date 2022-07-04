import React from 'react'
import {useEffect} from "react";
import burger1 from "../images/burger1.jpg";
import pizza1 from "../images/pizza1.jpg";

export default function Checkout() {
    useEffect(() => {
        document.querySelector(".AppContainer").style.setProperty('grid-template-columns', "auto 2fr");
    })
    return(
        <div className="p-24">
            <div className="text-4xl font-thin">
                Checkout
            </div>

            <div className="grid grid-cols-2 mt-10">
                <div className="shadow-md grid grid-cols-2 h-48 gap-3">
                    <img className="rounded-md h-48" src={burger1} alt="Food"/>
                    <div className="text-3xl grid">
                        <div>
                            Burger
                        </div>
                        <div className="grid grid-cols-2">
                            $5.5
                            <div className="text-xl">
                                x 1
                            </div>
                        </div>
                    </div>

                    <img className="rounded-md h-48" src={pizza1} alt="Food"/>
                    <div className="text-3xl grid">
                        <div>
                            Pizza
                        </div>
                        <div className="grid grid-cols-2">
                            $16
                            <div className="text-xl">
                                x 2
                            </div>
                        </div>
                    </div>

                    {/*<img className="rounded-md h-48" src={pizza1} alt="Food"/>*/}
                    {/*<div className="text-3xl grid">*/}
                    {/*    <div>*/}
                    {/*        Burger*/}
                    {/*    </div>*/}
                    {/*    <div className="grid grid-cols-2">*/}
                    {/*        $16*/}
                    {/*        <div className="text-xl">*/}
                    {/*            x 2*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {/*<img className="rounded-md h-48" src={pizza1} alt="Food"/>*/}
                    {/*<div className="text-3xl grid">*/}
                    {/*    <div>*/}
                    {/*        Burger*/}
                    {/*    </div>*/}
                    {/*    <div className="grid grid-cols-2">*/}
                    {/*        $16*/}
                    {/*        <div className="text-xl">*/}
                    {/*            x 2*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {/*<img className="rounded-md h-48" src={pizza1} alt="Food"/>*/}
                    {/*<div className="text-3xl grid">*/}
                    {/*    <div>*/}
                    {/*        Burger*/}
                    {/*    </div>*/}
                    {/*    <div className="grid grid-cols-2">*/}
                    {/*        $16*/}
                    {/*        <div className="text-xl">*/}
                    {/*            x 2*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {/*<img className="rounded-md h-48" src={pizza1} alt="Food"/>*/}
                    {/*<div className="text-3xl grid">*/}
                    {/*    <div>*/}
                    {/*        Burger*/}
                    {/*    </div>*/}
                    {/*    <div className="grid grid-cols-2">*/}
                    {/*        $16*/}
                    {/*        <div className="text-xl">*/}
                    {/*            x 2*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}

                    {/*<img className="rounded-md h-48" src={pizza1} alt="Food"/>*/}
                    {/*<div className="text-3xl grid">*/}
                    {/*    <div>*/}
                    {/*        Burger*/}
                    {/*    </div>*/}
                    {/*    <div className="grid grid-cols-2">*/}
                    {/*        $16*/}
                    {/*        <div className="text-xl">*/}
                    {/*            x 2*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                </div>

                <div>
                    <p className="text-gray-700 text-base font-serif mt-10">
                        Delivery Address
                    </p>

                    <p className="text-black text-2xl mb-1 font-serif">
                        4-7 Semilunei
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
                        <p className="font-light text-sm">
                            Delivery fee
                        </p>
                        <p className="font-bold text-sm">
                            $2.5
                        </p>
                        <p>Total:</p>
                        <div className="text-red-700">
                            $40.0
                        </div>
                        <button className="p-2 rounded-md bg-orange-500 w-36">
                            Pay
                        </button>
                    </div>
                </div>
            </div>

        </div>
    );
}
