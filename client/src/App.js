import './App.css';
import Sidebar from "./components/Sidebar";
import Search from "./components/Search";
import DiscountCarousel from "./components/DiscountCarousel";
import OrderPanel from "./components/OrderPanel";
import RestaurantsPanel from "./components/RestaurantsPanel";
import Footer from "./components/Footer";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Checkout from "./components/Checkout";
import Restaurant from "./components/Restaurant";


function App() {
    return (
        <BrowserRouter>
            <div className="App">
                <div className="AppContainer">
                    <Sidebar />

                    <Routes>
                        <Route path={"/"} element={(
                            <>
                                <div className="container rounded-l-2xl">
                                    <Search />
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
                                    <Search />
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
