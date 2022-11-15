import axios from "axios";
import {RESTAURANT_URL} from "../../utils/urls";

const getMeals = (id) => {
    return axios.get(RESTAURANT_URL + `/${id}/meals`);
}

const MealsService = {
    getMeals,
};

export default MealsService;