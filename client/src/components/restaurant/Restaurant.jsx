import './Restaurant.css';
import Meal from "../victual/Meal";
import Drink from "../victual/Drink";
import React from "react";

export default function Restaurant() {

    return(
        <div className={"centerPanel"}>
            <div className={"grid gap-10"}>
                <Meal/>
                <Drink/>
            </div>
        </div>
    );
}