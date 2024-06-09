import { Link } from "react-router-dom";

export default function HeaderApp1(){
    return(
        <>
        <Link to="/react1/home">Home</Link>
        <Link to="/react1/about">About</Link>
            {/* <a href="">Home</a>
            <a href="/react1/about"></a> */}
        </>
    )
}