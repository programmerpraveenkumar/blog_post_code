import { useEffect, useState } from "react";
function InputFilter(){
    let nameList = ["Lion","Tiger","Giraffe","Bear",
    "Zebra","Panda","Gorilla","Monkey","Wolf",
    "Deer","Fox","Yak","Jaguar","Hyena",
    "Squirrel","Elephant","Crocodile",
    "Kangaroo","Rhinoceros","Hippopotamus",'Lizard']
    const[filterTxt,setFilterTxt] = useState('');
    const[filterList,setFilterList] = useState([]);    
   
    useEffect(()=>{
        console.log(filterTxt);
        let tmp = nameList.filter(o=>o.toLowerCase()
                                .startsWith(filterTxt));
        setFilterList(tmp);
        console.log(tmp);
    },[filterTxt])
    
    
    return(
        <>
         <div>
         <h1>React Array Filter</h1>
            <div>
                <input type='text' onChange={(e)=>setFilterTxt(e.target.value)} placeholder="Enter Name"/>
                <ul>
                    {filterList && filterList.map(obj=>{
                        return <li key={obj}>{obj}</li>
                    })}
                    
                </ul>

            </div>
        </div>
        </>
    );
}
export default InputFilter;