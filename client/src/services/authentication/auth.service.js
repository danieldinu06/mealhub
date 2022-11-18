import axios from "axios";
import {API_URL, ORDER_URL, USER_URL} from "../../utils/urls";
import jwt_decode from "jwt-decode";

export const token = JSON.parse(localStorage.getItem("user"));

const loginConfig = {
    headers: {
        "Access-Control-Allow-Origin": API_URL,
        "Content-Type": "application/json"
    }
}

const config = {
    headers: {
        'Access-Control-Allow-Origin': USER_URL,
        'Authorization': `Bearer ${token}`,
    }
}

export const orderConfig = {
    'Access-Control-Allow-Origin': ORDER_URL,
    'Content-Type': 'application/json',
}

const register = (username, email, password) => {
    return axios.post(API_URL + "/register", {
        username,
        email,
        password
    });
};

const login = (username, password) => {
    return axios.post(API_URL + "/login", {
        username, password
    }, loginConfig)
        .then((response) => {
            if(response.data.token) {
                localStorage.setItem("user", JSON.stringify(response.data.token));
            }

            return response.data;
        });
};

const logout = () => {
    localStorage.removeItem("user");
};

const getCurrentUser = () => {
    if (!token) return null;

    const decodedToken = jwt_decode(token);
    return axios.get(USER_URL + "?name=" + decodedToken.sub, config);
}

const AuthService = {
    register,
    login,
    logout,
    getCurrentUser,
};

export default AuthService;