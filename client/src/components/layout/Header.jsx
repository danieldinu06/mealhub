import React, {useEffect, useState} from 'react'
import Search from "./Search";
import {Link} from "react-router-dom";
import AuthService from "../../services/authentication/auth.service";

export default function Header() {
    const [user, setUser] = useState();

    const handleLogout = () => {
        AuthService.logout();
    }

    useEffect(() => {
        if (AuthService.getCurrentUser() === null) return;
        AuthService.getCurrentUser()
            .then(response => setUser(response.data))
            .catch(error => console.log(error));

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
                        <a href={"/"} onClick={handleLogout}>
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