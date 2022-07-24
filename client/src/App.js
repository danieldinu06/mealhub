import './App.css';
import Sidebar from "./components/Sidebar";
import DiscountCarousel from "./components/DiscountCarousel";
import OrderPanel from "./components/OrderPanel";
import RestaurantsPanel from "./components/RestaurantsPanel";
import Footer from "./components/Footer";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Checkout from "./components/Checkout";
import Restaurant from "./components/Restaurant";
import Header from "./components/Header";


function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header />
                <div className="AppContainer">
                    <Sidebar />
                    <Routes>
                        <Route path={"/"} element={(
                            <>
                                <div className="container rounded-l-2xl">
                                    <DiscountCarousel />
                                    <RestaurantsPanel />
                                </div>
                                <OrderPanel/>
                            </>
                        )}/>

                        <Route path={"/checkout"} element={(
                            <Checkout/>
                        )}/>

                        <Route path={"/restaurant/:id"} element={(
                            <>
                                <div className="container rounded-l-2xl">
                                    <Restaurant />
                                </div>
                                <OrderPanel/>
                            </>
                        )}/>

                    </Routes>
                </div>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default App;
