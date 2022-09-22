import "./Authentication.css"
import {Link} from "react-router-dom";
import AuthService from "../../services/auth.service";
import {useState} from "react";

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleLogin = () => {
        AuthService.login(username, password)
            .then(() => {
                window.location.replace("/restaurants");
            });
    }

    return (
        <div className={"loginPage"}>
            <div className="profileImage">
                <img src={"/images/user.png"} alt="No User"/>
            </div>

            <form>
                <div className="credentials">
                    <label htmlFor="username">Username</label>
                    <input type="text" id={"username"} placeholder={"Enter your username"} onChange={handleUsernameChange}/>

                    <label htmlFor="password">Password</label>
                    <input type="password" placeholder={"Password"} onChange={handlePasswordChange}/>
                </div>

                <div className="submitBtn">
                    <button onClick={handleLogin}>
                        Log In
                    </button>
                </div>

                <div className="forgotPassword">
                    <Link to="/forgot">
                        Forgot password?
                    </Link>
                </div>

                <div className="createAccount">
                    <Link to={"/register"}>
                        Need an account? Sign up!
                    </Link>
                </div>
            </form>
        </div>
    );
}

export default Login;