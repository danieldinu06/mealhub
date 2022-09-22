import axios from "axios";

const API_URL = "http://localhost:8888/api/public/auth";

const config = {
    headers: {
        "Access-Control-Allow-Origin": API_URL
    }
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
    }, config)
        .then((response) => {
            if(response.data.token) {
                // let token = JSON.stringify(response.data.token);
                localStorage.setItem("user", JSON.stringify(response.data.token));
            }

            return response.data;
        });
};

const logout = () => {
    localStorage.removeItem("user");
};

const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("user"));
}

const AuthService = {
    register,
    login,
    logout,
    getCurrentUser,
};

export default AuthService;