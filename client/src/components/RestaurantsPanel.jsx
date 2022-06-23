import React from 'react'
import burger1 from '../images/burger1.jpg'
import burger2 from '../images/burger2.jpg'
import burger3 from '../images/burger3.jpg'

import pizza1 from '../images/pizza1.jpg'
import pizza2 from '../images/pizza2.jpg'
import pizza3 from '../images/pizza3.jpg'

import ramen1 from '../images/ramen1.jpg'
import ramen2 from '../images/ramen2.jpg'
import ramen3 from '../images/ramen3.jpg'

export default function RestaurantsPanel() {

    return(
        <div className="grid mt-16">
            <div className="grid grid-cols-4 text-center border-b-2 h-8 border-gray-300 rounded-lg">
                <button className="border-r-2 border-gray-300 rounded-lg" id="nearby">
                    Nearby
                </button>
                <button className="border-r-2 border-gray-300 rounded-lg" id="promotion">
                    Promotion
                </button>
                <button className="border-r-2 border-gray-300 rounded-lg" id="bestRating">
                    Best rating
                </button>
                <button className="rounded-lg" id="topSeller">
                    Top seller
                </button>
            </div>
            <div className="grid grid-cols-3 gap-6 p-6 text-center">

                {/*Burgers*/}

                <div className="grid gap-2">
                    <img src={burger1} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Burger
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $5.5
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>

                </div>
                <div className="grid gap-2">
                    <img src={burger2} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Burger
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $6.25
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
                <div className="grid grid-gap-2">
                    <img src={burger3} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Burger
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $5.75
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>

                {/*Pizza*/}

                <div className="grid grid-gap-2">
                    <img src={pizza1} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Pizza
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $8
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
                <div className="grid grid-gap-2">
                    <img src={pizza2} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Pizza
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $7.35
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
                <div className="grid grid-gap-2">
                    <img src={pizza3} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Pizza
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $8.2
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>

                {/*Ramen*/}


                <div className="grid grid-gap-2">
                    <img src={ramen1} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Ramen
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $10
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
                <div className="grid grid-gap-2">
                    <img src={ramen2} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Ramen
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $10.5
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
                <div className="grid grid-gap-2">
                    <img src={ramen3} alt="No burger"/>
                    <div className="grid grid-cols-2">
                        <div className="justify-self-start">
                            Ramen
                        </div>
                        <div className="grid grid-rows-2">
                            <div className="font-serif justify-self-center text-2xl">
                                $9.75
                            </div>
                            <button className="self-center bg-orange-400 rounded-full h-8">
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}