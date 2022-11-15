import React from 'react';
import DiscountCarousel from "../layout/DiscountCarousel";
import RestaurantsPanel from "./RestaurantsPanel";

export default function RestaurantsPage() {
    return (
        <div>
            <div className="container rounded-l-2xl">
                <DiscountCarousel />
            </div>

            <div className="AppContainer">
                <RestaurantsPanel />
            </div>
        </div>
    );
}
