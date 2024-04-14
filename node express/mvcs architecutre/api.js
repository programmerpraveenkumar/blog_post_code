var exp = require('express');
const { UserService } = require('./Service/UserService');
const { MobileModel } = require('./model/MobileModel');
var router = exp.Router();
let userService = new UserService();
// http://localhost:8080/api/sample/login
router.get('/getAll',async (req,res)=>{
    let dbData = await userService.getAllData({ include: MobileModel });
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