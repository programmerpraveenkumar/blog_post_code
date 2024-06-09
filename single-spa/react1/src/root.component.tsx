import { RouterProvider, createBrowserRouter } from "react-router-dom";
import Home from "./Home";
import About from "./About";

const routerConfig = createBrowserRouter([
  {path:"react1",element:<Home/>},
  {path:"react1/home",element:<Home/>},
  {path:"react1/about",element:<About/>}
])
export default function Root(props) {
  return <section>
    <RouterProvider router={routerConfig}></RouterProvider>

  </section>;
}
