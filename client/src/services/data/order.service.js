import axios from "axios";
import {ORDER_URL} from "../../utils/urls";

const createOrder = (price, discount, restaurant, user, drinks, meals) => {
    return axios.post(ORDER_URL, {
        price,
        discount,
        restaurant,
        user,
        drinks,
        meals
    });
}

const getOrder = (id) => {
    return axios.get(ORDER_URL + `/${id}`);
}

const OrderService = {
    createOrder,
    getOrder
};

export default OrderService;