import axios from "axios";
import {RESTAURANT_URL} from "../../utils/urls";

const getRestaurant = (id) => {
    return axios.get(RESTAURANT_URL + `/${id}`);
}

const RestaurantService = {
    getRestaurant,
};

export default RestaurantService;