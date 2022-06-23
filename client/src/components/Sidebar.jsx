import '../App.css';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowRightFromBracket, faHouse} from "@fortawesome/free-solid-svg-icons";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import { faHandshakeAngle } from "@fortawesome/free-solid-svg-icons";
import { faEarthEurope } from "@fortawesome/free-solid-svg-icons";

export default function Sidebar() {
    return (
        <div>
            <div className="w-full bg-white sticky top-0" id="sidenavSecExample">
                <div className="pt-4 pb-2 px-6">
                    <a href="#">
                        <div className="flex items-center">
                            <div className="shrink-0">
                                <img src="https://mdbcdn.b-cdn.net/img/new/avatars/8.webp" className="rounded-full w-10"
                                     alt="Avatar"></img>
                            </div>
                            <div className="grow ml-3">
                                <p className="text-sm font-semibold text-blue-600">Daniel Dinu</p>
                            </div>
                        </div>
                    </a>
                </div>
                <ul className="relative px-1">
                    <li className="relative">
                        <a className="flex items-center text-sm py-4 px-6 h-12 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                           href="/" data-mdb-ripple="true" data-mdb-ripple-color="primary">
                            <FontAwesomeIcon icon={faUser} className="w-5 h-5 mr-3"/>
                            <span className="text-lg">Profile</span>
                        </a>
                    </li>
                    <li className="relative">
                        <a className="flex items-center text-sm py-4 px-6 h-12 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                           href="#" data-mdb-ripple="true" data-mdb-ripple-color="primary">
                            <FontAwesomeIcon icon={faHouse} className="w-5 h-5 mr-3"/>
                            <span className="text-lg">Main Page</span>
                        </a>
                    </li>
                    <li className="relative" id="sidenavSecEx2">
                        <a className="flex items-center text-sm py-4 px-6 h-12 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out cursor-pointer"
                           data-mdb-ripple="true" data-mdb-ripple-color="primary" data-bs-toggle="collapse"
                           data-bs-target="#collapseSidenavSecEx2" aria-expanded="false"
                           aria-controls="collapseSidenavSecEx2">
                            <FontAwesomeIcon icon={faEarthEurope} className="w-5 h-5 mr-3"/>
                            <span className="text-lg">Explore</span>
                            <svg aria-hidden="true" focusable="false" data-prefix="fas" className="w-3 h-3 ml-auto"
                                 role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                <path fill="currentColor"
                                      d="M207.029 381.476L12.686 187.132c-9.373-9.373-9.373-24.569 0-33.941l22.667-22.667c9.357-9.357 24.522-9.375 33.901-.04L224 284.505l154.745-154.021c9.379-9.335 24.544-9.317 33.901.04l22.667 22.667c9.373 9.373 9.373 24.569 0 33.941L240.971 381.476c-9.373 9.372-24.569 9.372-33.942 0z"></path>
                            </svg>
                        </a>
                        <ul className="relative accordion-collapse collapse" id="collapseSidenavSecEx2"
                            aria-labelledby="sidenavSecEx2" data-bs-parent="#sidenavSecExample">
                            <li className="relative">
                                <a href="#"
                                   className="flex items-center text-md py-4 pl-12 pr-6 h-6 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                                   data-mdb-ripple="true" data-mdb-ripple-color="primary">Restaurants</a>
                            </li>
                            <li className="relative">
                                <a href="#"
                                   className="flex items-center text-md py-4 pl-12 pr-6 h-6 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                                   data-mdb-ripple="true" data-mdb-ripple-color="primary">Markets</a>
                            </li>
                        </ul>
                    </li>
                    <li className="relative" id="sidenavSecEx3">
                        <a className="flex items-center text-sm py-4 px-6 h-12 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out cursor-pointer"
                           data-mdb-ripple="true" data-mdb-ripple-color="primary" data-bs-toggle="collapse"
                           data-bs-target="#collapseSidenavSecEx3" aria-expanded="false"
                           aria-controls="collapseSidenavSecEx3">
                            <FontAwesomeIcon icon={faHandshakeAngle} className="w-5 h-5 mr-3"/>
                            <span className="text-lg">Help</span>
                            <svg aria-hidden="true" focusable="false" data-prefix="fas" className="w-3 h-3 ml-auto"
                                 role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                <path fill="currentColor"
                                      d="M207.029 381.476L12.686 187.132c-9.373-9.373-9.373-24.569 0-33.941l22.667-22.667c9.357-9.357 24.522-9.375 33.901-.04L224 284.505l154.745-154.021c9.379-9.335 24.544-9.317 33.901.04l22.667 22.667c9.373 9.373 9.373 24.569 0 33.941L240.971 381.476c-9.373 9.372-24.569 9.372-33.942 0z"></path>
                            </svg>
                        </a>
                        <ul className="relative accordion-collapse collapse" id="collapseSidenavSecEx3"
                            aria-labelledby="sidenavSecEx3" data-bs-parent="#sidenavSecExample">
                            <li className="relative">
                                <a href="#"
                                   className="flex items-center text-md py-4 pl-12 pr-6 h-6 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                                   data-mdb-ripple="true" data-mdb-ripple-color="primary">Contact Us</a>
                            </li>
                            <li className="relative">
                                <a href="#"
                                   className="flex items-center text-md py-4 pl-12 pr-6 h-6 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                                   data-mdb-ripple="true" data-mdb-ripple-color="primary">FAQ</a>
                            </li>
                        </ul>
                    </li>
                    <li className="relative">
                        <a className="flex items-center text-sm py-4 px-6 h-12 overflow-hidden text-gray-700 text-ellipsis whitespace-nowrap rounded hover:text-blue-600 hover:bg-blue-50 transition duration-300 ease-in-out"
                           href="#" data-mdb-ripple="true" data-mdb-ripple-color="primary">
                            <FontAwesomeIcon icon={faArrowRightFromBracket} className="w-5 h-5 mr-3"/>
                            <span className="text-lg">LogOut</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    );
}