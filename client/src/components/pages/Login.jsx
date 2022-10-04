import "./Authentication.css"
import {Link} from "react-router-dom";
import AuthService from "../../services/auth.service";
import {useState} from "react";
import {toast, ToastContainer} from "react-toastify";
import {delay} from "./Register";

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
            .then(async (response) => {

                console.log(response.data);
                toast.success(response.data.message);

                await delay(2000);
                window.location.replace("/restaurants");

            }).catch(error => {
                toast.error(error.response.data.message);
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
                        <ToastContainer/>
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