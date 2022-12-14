import React from 'react';
import Restaurant from "./Restaurant";
import OrderPanel from "../payment/OrderPanel";

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