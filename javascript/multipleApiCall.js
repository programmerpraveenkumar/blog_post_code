// https://reqres.in/api/users/2
// https://reqres.in/api/users/3
(async ()=>{
    let [response,response1] = await Promise.all([fetch("https://reqres.in/api/users/4"),fetch("https://reqres.in/api/users/3")]);
        let res = await response.json();
        let res1 = await response1.json();
        console.log(res);
        console.log(res1);
    //console.log(response)

})();
    
