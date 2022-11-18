import React from 'react';
import "./App.css";
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import 'tw-elements';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Checkout from "./components/payment/Checkout";
import Header from "./components/layout/Header";
import Footer from "./components/layout/Footer";
import RestaurantsPage from "./components/restaurant/RestaurantsPage";
import RestaurantPage from "./components/restaurant/RestaurantPage";
import PrivateRoutes from "./components/utils/PrivateRoutes";
import Login from "./components/page/Login";
import ProtectedRoutes from "./components/utils/ProtectedRoutes";
import PublicRoutes from "./components/utils/PublicRoutes";
import Register from "./components/page/Register";
import VerificationPage from "./components/page/VerificationPage";
import HomePage from "./components/page/HomePage";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route>
                    <Route path={"/"} element={(
                        <>
                            <HomePage/>
                            <Footer/>
                        </>
                    )}/>
                    <Route path={"/restaurants"} element={(
                        <>
                            <Header/>
                            <RestaurantsPage/>
                            <Footer/>
                        </>
                    )}/>
                    <Route path={"/restaurants/:id"} element={(
                        <>
                            <Header/>
                            <RestaurantPage/>
                            <Footer/>
                        </>
                    )}/>
                </Route>

                <Route element={<ProtectedRoutes/>}>
                    <Route path={"/login"} element={(<Login/>)}/>
                    <Route path={"/register"} element={(<Register/>)}/>
                    <Route path={"/verify"} element={(<VerificationPage/>)}/>
                </Route>

                <Route element={<PrivateRoutes/>}>
                    <Route path={"/checkout"} element={(
                        <>
                            <Header/>
                            <Checkout/>
                            <Footer/>
                        </>
                    )}/>
                </Route>

            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
