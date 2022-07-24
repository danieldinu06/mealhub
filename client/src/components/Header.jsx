import React from 'react'
import Search from "./Search";

export default function Header() {
    return(
        <div className={"flex justify-between items-center p-3 bg-gray-700"}>
            <div className={"font-bold text-xl text-white"}>
                MealHub
            </div>
            <Search />
            <div className={"font-bold text-xl text-white"}>
                Location
            </div>
        </div>
    );
}