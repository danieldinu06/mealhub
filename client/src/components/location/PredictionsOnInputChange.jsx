import { useRef, useEffect } from "react";

function PredictionsOnInputChange() {
    const autoCompleteRef = useRef();
    const inputRef = useRef();

    const options = {
        fields: ["address_components", "geometry", "icon", "name"],
        types: ["establishment"]
    }

    useEffect(() => {
        autoCompleteRef.current = new window.google.maps.places.Autocomplete(
            inputRef.current,
            options
        );

        autoCompleteRef.current.addListener("place_changed", async function () {
            const place = await autoCompleteRef.current.getPlace();
            console.log({ place });
        });
    });

    return (
        <input className={"inputLocation"} ref={inputRef}/>
    );
}

export default PredictionsOnInputChange;