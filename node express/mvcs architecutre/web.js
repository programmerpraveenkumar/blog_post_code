var exp = require('express');
const {UserService} = require('./Service/UserService');

var router = exp.Router();
 let userService = new UserService();
 
router.get('/sample',async (req,res)=>{
    let dbData = await userService.getAllData();
    res.render('index',{'message':"sample","name":"sample name",
                        "userList":['test','test2','test3'],
                        "userDbData":dbData
                        })
})
module.exports=router;
