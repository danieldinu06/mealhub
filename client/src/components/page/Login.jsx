import "./Authentication.css"
import {Link, useNavigate} from "react-router-dom";
import {toast, ToastContainer} from "react-toastify";
import {delay} from "./Register";
import AuthService from "../../services/authentication/auth.service";
import {useFormik} from "formik";
import {loginSchema} from "../../services/validation/loginValidation";


function Login() {
    const navigate = useNavigate();

    const {values, handleChange, handleSubmit} = useFormik({
        initialValues: {
            "username": "",
            "password": "",
        },
        validationSchema: loginSchema,
        onSubmit(values) {
            AuthService.login(values.username, values.password)
                .then(async () => {
                    toast.success("Login successfully, please wait!");

                    await delay(3000);
                    navigate("/restaurants");
                })
                .catch(error => {
                    toast.error("Username or password incorrect!");
                });
        }
    });

    return (
        <div className={"loginPage"}>
            <div className="profileImage">
                <img src={"/images/user.png"} alt="No User"/>
            </div>

            <form onSubmit={handleSubmit}>
                <div className="credentials">
                    <label htmlFor="username">Username</label>
                    <input
                        value={values.username}
                        type="text"
                        id={"username"}
                        placeholder={"Enter your username"}
                        onChange={handleChange}/>

                    <label htmlFor="password">Password</label>
                    <input
                        value={values.password}
                        type="password"
                        id={"password"}
                        placeholder={"Password"}
                        onChange={handleChange}/>
                </div>

                <div className="submitBtn">
                    <button type={"submit"}>
                        Log In
                    </button>
                    <ToastContainer/>
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