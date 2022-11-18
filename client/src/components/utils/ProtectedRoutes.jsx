import {Navigate, Outlet} from "react-router-dom";
import AuthService from "../../services/authentication/auth.service";
import {useEffect, useState} from "react";

function ProtectedRoutes() {
    const [authToken, setAuthToken] = useState(null);

    useEffect(() => {
        if (AuthService.getCurrentUser()) {
            AuthService.getCurrentUser()
                .then(response => setAuthToken(response.data.token));
        }
    });

    return (
        !authToken ? <Outlet/> : <Navigate to={"/restaurants"}/>
    );
}

export default ProtectedRoutes;