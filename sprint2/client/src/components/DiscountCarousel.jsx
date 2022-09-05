import React from 'react'

export default function DiscountCarousel() {
    return(
        <div id="carouselExampleControls" className="carousel slide relative justify-self-center max-w-2xl" data-bs-ride="carousel">
            <div className="carousel-inner relative w-full overflow-hidden rounded-lg">
                <div className="carousel-item active relative float-left w-full">
                    <img
                        src="https://cdn.grabon.in/gograbon/images/web-images/uploads/1618555230698/the-good-bowl-coupon.jpg"
                        className="block w-full"
                        alt="Wild Landscape"
                    />
                </div>
                <div className="carousel-item relative float-left w-full">
                    <img
                        src="https://happysale.in/hs/img/w/up/zomatocouponshappysalejpg1626767964284.jpg"
                        className="block w-full"
                        alt="Camera"
                    />
                </div>
                <div className="carousel-item relative float-left w-full">
                    <img
                        src="https://cdn.grabon.in/gograbon/images/web-images/uploads/1618575517942/food-coupons.jpg"
                        className="block w-full"
                        alt="Exotic Fruits"
                    />
                </div>
            </div>
            <button
                className="carousel-control-prev absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline left-0"
                type="button"
                data-bs-target="#carouselExampleControls"
                data-bs-slide="prev"
            >
                <span className="carousel-control-prev-icon inline-block bg-no-repeat" aria-hidden="true"></span>
                <span className="visually-hidden">Previous</span>
            </button>
            <button
                className="carousel-control-next absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline right-0"
                type="button"
                data-bs-target="#carouselExampleControls"
                data-bs-slide="next"
            >
                <span className="carousel-control-next-icon inline-block bg-no-repeat" aria-hidden="true"></span>
                <span className="visually-hidden">Next</span>
            </button>
        </div>
    );
}