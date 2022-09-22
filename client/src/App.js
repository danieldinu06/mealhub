import './App.css';
import React from "react";
import {useEffect, useState} from "react";
import AuthService from "./services/auth.service";


function App() {
    const [showCheckout, setShowCheckout] = useState(false);
    const [currentUser, setCurrentUser] = useState(undefined);

    useEffect(() => {
        const user = AuthService.getCurrentUser();

        if (user) {
            setCurrentUser(user);
            setShowCheckout(user.roles.includes("ROLE_USER"));
        }
    }, []);

    const logOut = () => {
        AuthService.logout();
    }

    return (
        <div className="App">
            <div className="AppContainer">

            </div>
        </div>
    );
}

export default App;
