import React from 'react';
import "./App.css";
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import 'tw-elements';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Checkout from "./components/Checkout";
import Header from "./components/fixedComponents/Header";
import Footer from "./components/fixedComponents/Footer";
import RestaurantsPage from "./components/pages/RestaurantsPage";
import RestaurantPage from "./components/pages/RestaurantPage";
import PrivateRoutes from "./components/utils/PrivateRoutes";
import Login from "./components/pages/Login";
import ProtectedRoutes from "./components/utils/ProtectedRoutes";
import PublicRoutes from "./components/utils/PublicRoutes";
import Register from "./components/pages/Register";
import VerificationPage from "./components/pages/VerificationPage";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <Routes>
                <Route element={<PublicRoutes/>}>
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
                </Route>

                <Route element={<PrivateRoutes/>}>
                    <Route path={"/verify"} element={(<VerificationPage/>)}/>
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
