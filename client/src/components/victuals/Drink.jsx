import React, {useEffect, useState} from 'react'
import axios from "axios";
import {useParams} from "react-router-dom";
import './Meal.css';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSquarePlus} from "@fortawesome/free-regular-svg-icons";

export default function Drink() {
    const { id } = useParams();
    const [drinks, setDrinks] = useState([]);

    useEffect(() => {
        const url = `http://localhost:8888/api/public/restaurants/${id}/drinks`

        axios.get(url)
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
                                <img src={drink.image} alt="No meal" className={"drinkImage"}/>
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
                                <button>
                                    <FontAwesomeIcon icon={faSquarePlus} />
                                </button>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}