var exp = require('express');
const { UserService } = require('./Service/UserService');
var router = exp.Router();
let userService = new UserService();
router.get('/getAll',async (req,res)=>{
    let dbData = await userService.getAllData();
    res.json(dbData);
})
router.post('/login',async (req,res)=>{
    try{
        let uname = req['body']['name'];
        let pwd = req['body']['pwd']
        let dbData = await userService.login(uname,pwd);
        res.json(dbData);
    }catch(e){
        res.status(400);
        res.json({"Error":"Error "+e})
    }
    
})
router.post('/register',async (req,res)=>{
    try{
        await userService.register();
        res.json({"message":"data inserted"});
    }catch(e){
        res.status(400);
        res.json({"Error":"Error "+e})
    }
    
})
module.exports=router;




// const { Sequelize, DataTypes } = require('sequelize');
// const { User,sequelizeObj } = require('./model/UserModel');

// async function getData(){
//     await sequelizeObj.sync();
//     let res = await User.findAll();
//     res.forEach(obj=>{
//            // console.log(obj);
//     })
//     sequelizeObj.close();
// }
// function pdfCreation(){
    
// }
// getData();