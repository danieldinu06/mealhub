import React, {useEffect, useState} from 'react'
import AuthService from "../../services/authentication/auth.service";

export default function Search() {
    const [location, setLocation] = useState();

    useEffect(() => {
        if (AuthService.getCurrentUser()) {
            AuthService.getCurrentUser()
                .then(response => setLocation(response.data.location))
                .catch(err => console.log(err));
        }
    });

    return (
        <div className="h-6 flex flex-row gap-3" id="searchBarExample">
            <img src="/images/location.png" alt="Location"/>
            <p className={"text-white"}>{location}</p>
        </div>
    );
}