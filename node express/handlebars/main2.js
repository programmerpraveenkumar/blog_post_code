var exp = require('express');
var app = exp();
const path = require('path');
var {engine} = require('express-handlebars')
app.engine('handlebars', engine());
app.set("view engine","handlebars");
app.set('views', './views');
// app.use(exp.static("/"));


app.get("/sample",(req,res)=>{
    let name = "some value";
    res.render('sample',{"name":name,"country":"india"});
})
app.get("/login",(req,res)=>{
    res.sendFile(path.join(__dirname, 'views/login.html'));
 })
app.listen(8080,()=>{
    console.log("server started..");
})