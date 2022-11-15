import axios from "axios";
import {RESTAURANT_URL} from "../../utils/urls";

const getDrinks = (id) => {
    return axios.get(RESTAURANT_URL + `/${id}/drinks`);
}

const DrinksService = {
    getDrinks,
};

export default DrinksService;