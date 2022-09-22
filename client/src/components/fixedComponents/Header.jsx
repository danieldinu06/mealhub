import React from 'react'
import Search from "./Search";

export default function Header() {
    return(
        <div className={"flex justify-between items-center p-3 bg-gray-700"}>
            <div className={"font-bold text-xl text-white"}>
                <a href="/restaurants">
                    MealHub
                </a>
            </div>
            <Search />
            <div className={"font-bold text-xl text-white"}>
                Location
            </div>
        </div>
    );
}