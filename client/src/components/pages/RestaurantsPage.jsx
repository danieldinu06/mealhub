import React from 'react';
import DiscountCarousel from "../DiscountCarousel";
import RestaurantsPanel from "../restaurant/RestaurantsPanel";
import OrderPanel from "../OrderPanel";

export default function RestaurantsPage() {
    return (
        <div>
            <div className="container rounded-l-2xl">
                <DiscountCarousel />
            </div>

            <div className="AppContainer">
                <RestaurantsPanel />
                <OrderPanel/>
            </div>
        </div>
    );
}
