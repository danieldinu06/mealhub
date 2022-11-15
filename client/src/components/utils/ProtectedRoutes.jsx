import {Navigate, Outlet} from "react-router-dom";
import AuthService from "../../services/authentication/auth.service";

function ProtectedRoutes() {
    let authToken = AuthService.getCurrentUser();

    return (
        !authToken ? <Outlet/> : <Navigate to={"/restaurants"}/>
    );
}

export default ProtectedRoutes;