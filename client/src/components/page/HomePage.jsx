import React from 'react';
import "./HomePage.css";
import PredictionsOnInputChange from "../location/PredictionsOnInputChange";
import {useNavigate} from "react-router-dom";

export default function HomePage() {
    const navigate = useNavigate();

    return (
        <div className={"homepage"}>
            <div className={"banner"}>
                <div className={"name"}>
                    <p>
                        MealHub
                    </p>
                </div>
                <div className={"auth"}>
                    <div id={"logIn"}>
                        <a href="/login">Sign In</a>
                    </div>

                    <div id={"logOut"}>
                        <a href="/register">Sign Up</a>
                    </div>
                </div>
                <div className={"info"}>
                    <p>Enjoy your meal<br/>Wherever you feel</p>
                    <div>
                        <img src="/images/location.png" alt="Location"/>
                        <PredictionsOnInputChange/>
                        <input className={"submitLocation"} type="image" src={"/images/enter.png"} alt={"Enter"}/>
                    </div>
                </div>
            </div>

            <div className="explorePanel">
                <div className="ads">
                    <div>
                        <img src="/images/chef.png" alt="Chef"/>
                        <p align={"center"}>Enjoy the best chefs in town!</p>
                    </div>
                    <div>
                        <img src="/images/food.png" alt="Food"/>
                        <p align={"center"}>Food like you've never eaten!</p>
                    </div>
                    <div>
                        <img src="/images/supermarket.png" alt="Supermarket"/>
                        <p align={"center"}>Or even buy your day-to-day groceries!</p>
                    </div>
                </div>
                <img src="/images/restaurants_artwork.jpg" alt="Restaurants artwork"/>
                <div>
                    <button onClick={() => navigate("/restaurants")}>Find restaurants</button>
                </div>
            </div>

            <div className={"bussinessPanel"}>
                <div id={"courierPanel"}>
                    <img src="/images/courier.png" alt="Courier"/>
                    <h1>Become a courier!</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis ea ex nostrum officiis qui tempora tenetur totam vero voluptatem! Animi deserunt eligendi exercitationem iure laborum magnam numquam officia porro possimus quidem, quos, saepe sapiente totam. Accusantium ad, adipisci aliquam debitis dolor expedita illum optio quisquam quo soluta vitae voluptas voluptatibus.</p>
                </div>

                <div id={"partnerPanel"}>
                    <h1>Become a Partner!</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis ea ex nostrum officiis qui tempora tenetur totam vero voluptatem! Animi deserunt eligendi exercitationem iure laborum magnam numquam officia porro possimus quidem, quos, saepe sapiente totam. Accusantium ad, adipisci aliquam debitis dolor expedita illum optio quisquam quo soluta vitae voluptas voluptatibus.</p>
                    <img src="/images/partner.png" alt="Partner"/>
                </div>
            </div>

        </div>
    );
}
