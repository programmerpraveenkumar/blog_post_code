const { UserModel } = require('../model/UserModel');
 const {sequelizeObj} = require("../config/DbCon");
class UserService{
   async getAllData(){
        await sequelizeObj.sync();
        let userDbData = await UserModel.findAll();
        return userDbData;
    }
    async login(uname,pwd){
        await sequelizeObj.sync();
        console.log(uname,pwd);
        let userDbData = await UserModel.findOne({where:{"email":uname,"password":pwd}});
        if(userDbData == null){
            throw 'NO USER FOUND';
        }
  
         return userDbData.dataValues;
    }
    async register(){
        await sequelizeObj.sync();
        await UserModel.create({
            "name":"tesrt",
            "email":"test@gmail.com",
            "password":"test"
        })
    }
}
module.exports ={  UserService};