import React, {useEffect, useState} from 'react'
import axios from "axios";
import {useParams} from "react-router-dom";
import './Meal.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSquarePlus} from "@fortawesome/free-regular-svg-icons";

export default function Meal() {
    const { id } = useParams();
    const [meals, setMeals] = useState([]);

    useEffect(() => {
        const url = `http://localhost:8080/restaurant/${id}/meals`

        axios.get(url)
            .then(response => setMeals(response.data))
            .catch(error => console.log(error));
    }, [id]);

    return(
        <div className="grid gap-10">
            <div>
                <p className={"type"}>
                    Type of meals
                </p>
                <div className={"grid grid-cols-3 gap-2"}>
                    {
                        meals.map(
                            meal => (
                                <div className={"product"} key={meal.id}>
                                    <div className={"grid grid-cols-2 p-1"}>
                                        <img src={meal.image} alt="No meal" className={"mealImage"}/>
                                        <div className="grid p-3">
                                            <p>
                                                {meal.name}
                                            </p>
                                            <p className={"ingredients"}>
                                                {meal.ingredients}
                                            </p>
                                        </div>
                                    </div>

                                    <div className={"cardBottom"}>
                                        <p>
                                            {meal.price} RON
                                        </p>
                                        <button>
                                            <FontAwesomeIcon icon={faSquarePlus} />
                                        </button>
                                    </div>
                                </div>
                            )
                        )
                    }
                </div>
            </div>
        </div>
    );
}