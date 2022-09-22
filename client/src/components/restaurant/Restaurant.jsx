import './Restaurant.css';
import Meal from "../victuals/Meal";
import Drink from "../victuals/Drink";

export default function Restaurant() {

    return(
        <div className={"centerPanel"}>
            <div className={"grid gap-10"}>
                <Meal/>
                <Drink/>
            </div>
        </div>
    );
}