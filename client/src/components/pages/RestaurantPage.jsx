import React from 'react';
import Restaurant from "../restaurant/Restaurant";
import OrderPanel from "../OrderPanel";

function RestaurantPage() {
    return (
        <div className={"AppContainer"}>
            <div className="container rounded-l-2xl">
                <Restaurant />
            </div>
            <OrderPanel/>
        </div>
    );
}

export default RestaurantPage;