import "./Authentication.css"
import {Link, useNavigate} from "react-router-dom";
import {useFormik} from "formik";
import {registerSchema} from "../../services/validation/registerValidation";
import AuthService from "../../services/authentication/auth.service";
import {toast, ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export const delay = ms => new Promise(resolve => setTimeout(resolve, ms))

function Register() {
    const navigate = useNavigate();

    const {values, errors, touched, handleBlur, handleChange, handleSubmit} = useFormik({
        initialValues: {
            "username": "",
            "email": "",
            "password": "",
            "confirmPassword": "",
        },
        validationSchema: registerSchema,
        onSubmit(values) {
            AuthService.register(values.username, values.email, values.password)
                .then( async (response) => {
                    toast.success("User registered successfully, please wait!");
                    await delay(3000);
                    navigate("/verify");
                })
                .catch((error) => {
                    toast.error(error.response.data.message);
                });
        },
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
                        onChange={handleChange}
                        id={"username"}
                        type="text"
                        placeholder={"Username"}
                        onBlur={handleBlur}
                        className={errors.username && touched.username ? "input-error" : ""}
                    />
                    {errors.username && touched.username && <p className={"error"}>{errors.username}</p>}

                    <label htmlFor="email">Email</label>
                    <input
                        value={values.email}
                        onChange={handleChange}
                        id={"email"}
                        type="email"
                        placeholder={"email@email.com"}
                        onBlur={handleBlur}
                        className={errors.email && touched.email ? "input-error" : ""}
                    />
                    {errors.email  && touched.email && <p className={"error"}>{errors.email}</p>}

                    <label htmlFor="password">Password</label>
                    <input
                        value={values.password}
                        onChange={handleChange}
                        id={"password"}
                        type="password"
                        placeholder={"Password"}
                        onBlur={handleBlur}
                        className={errors.password && touched.password ? "input-error" : ""}
                    />
                    {errors.password  && touched.password && <p className={"error"}>{errors.password}</p>}

                    <label htmlFor="confirmPassword">Confirm Password</label>
                    <input
                        value={values.confirmPassword}
                        onChange={handleChange}
                        type="password"
                        id={"confirmPassword"}
                        placeholder={"Password"}
                        onBlur={handleBlur}
                        className={errors.confirmPassword && touched.confirmPassword ? "input-error" : ""}
                    />
                    {errors.confirmPassword  && touched.confirmPassword && <p className={"error"}>{errors.confirmPassword}</p>}
                </div>

                <div className="submitBtn">
                    <button type={"submit"}>
                        Register
                        <ToastContainer/>
                    </button>
                </div>

                <div className="already">
                    <Link to="/login">
                        Already have an account? Sign in!
                    </Link>
                </div>
            </form>
        </div>
    );
}

export default Register;