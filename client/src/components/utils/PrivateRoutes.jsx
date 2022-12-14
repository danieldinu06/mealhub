import {Navigate, Outlet} from "react-router-dom";
import AuthService from "../../services/authentication/auth.service";

function PrivateRoutes() {
    let authToken = AuthService.getCurrentUser();

    return (
        authToken ? <Outlet/> : <Navigate to={"/login"}/>
    );
}

export default PrivateRoutes;