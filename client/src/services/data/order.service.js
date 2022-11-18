import axios from "axios";
import {ORDER_URL} from "../../utils/urls";
import {config, orderConfig} from "../authentication/auth.service";


const createOrder = (price, discount, restaurant, user, drinks, meals) => {
    const data ={
        'price': price,
        'discount': discount,
        'restaurant': restaurant,
        'user': null,
        'drinks': drinks,
        'meals': meals
    };

    return fetch(ORDER_URL, {
        headers: orderConfig,
        method: 'POST',
        body: JSON.stringify(data)
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