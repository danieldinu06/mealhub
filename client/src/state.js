import { atom } from 'jotai';

const meals = atom([]);
const drinks = atom([]);
const price = atom(0);

const order = {
    meals,
    drinks,
    price
}
const customerDetails = atom({name: '', deliveryAddress: '', phoneNumber: '', email: ''});

export const orderState = {
    order,
    customerDetails
};