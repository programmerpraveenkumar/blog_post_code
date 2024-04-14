var exp = require('express')
var app = exp();
var api = require('./api');
var web = require('./web');
app.set("view engine","pug");
app.use(exp.json());
app.use('/api',api);
app.use('/web',web);

app.listen(8080,()=>{
    console.log("server started..");
})