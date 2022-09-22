import React, {useEffect, useState} from 'react'
import axios from "axios";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTruck} from "@fortawesome/free-solid-svg-icons";
import {faClock, faThumbsUp} from "@fortawesome/free-regular-svg-icons";

export default function RestaurantsPanel() {

    const [restaurants, setRestaurants] = useState([]);

    useEffect(() => {

        const url = "http://localhost:8888/api/public/restaurants"

        axios.get(url)
            .then(response => setRestaurants(response.data))
            .catch(error => console.log(error));

    }, []);


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

                {restaurants.map(restaurant => (
                    <div className="grid gap-1 shadow-lg border-b-2" key={restaurant.id}>
                        <div className={"relative h-48 overflow-hidden cursor-pointer"}>
                            <a href={`/restaurants/${restaurant.id}`}>
                                <img className={"blur-sm -translate-y-1/4 hover:scale-110 ease-in-out duration-500"} src={restaurant.logo} alt="No restaurant"/>
                                <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 text-3xl font-bold
                            hover:text-white ease-in-out duration-500">
                                    {restaurant.name}
                                </div>
                            </a>
                        </div>
                        <div className={"flex justify-between pl-2 pr-2"}>
                            <div className={"flex gap-1 items-center"}>
                                <FontAwesomeIcon className={"self-center"} icon={faThumbsUp} />
                                100%
                                <p className="text-gray-400">
                                    (250)+
                                </p>
                            </div>
                            <div className={"flex gap-4 items-center"}>
                                <div>
                                    <FontAwesomeIcon icon={faTruck}/> {restaurant.deliveryFee} RON
                                </div>
                                <div>
                                    <FontAwesomeIcon icon={faClock} /> 40min
                                </div>
                            </div>
                        </div>
                    </div>
                ))}

            </div>
        </div>
    );
}