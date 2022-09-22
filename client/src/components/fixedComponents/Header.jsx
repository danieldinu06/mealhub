import React, {useEffect, useState} from 'react'
import Search from "./Search";
import {Link} from "react-router-dom";
import AuthService from "../../services/auth.service";

export default function Header() {
    const [user, setUser] = useState();

    const handleLogout = () => {
        AuthService.logout();
    }

    useEffect(() => {
        setUser(AuthService.getCurrentUser());
    }, [])

    return(
        <div className={"flex justify-between items-center p-3 bg-gray-700"}>
            <div className={"font-bold text-xl text-white"}>
                <Link to={"/restaurants"}>
                    MealHub
                </Link>
            </div>
            <Search />
            {
                user ?
                    <div className={"font-bold text-xl text-white"}>
                        <a href={"/login"} onClick={handleLogout}>
                            Log Out
                        </a>
                    </div> :
                    <div className={"font-bold text-xl text-white"}>
                        <a href={"/login"}>
                            Log In
                        </a>
                    </div>
            }
        </div>
    );
}