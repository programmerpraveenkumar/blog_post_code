var mysql = require('mysql');

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'dec2023',  
});
 
connection.connect();

connection.query("insert into users(name,email,password)values(?,?,?)",['apr25','apr25@gmail.com','apr25'],(err,res,field)=>{
  console.log(res);
})
connection.query("update users set name=?,password=? where id = ?",['update25','update25','1'],(err,res,field)=>{
  console.log(res);
})
connection.query("delete from users where id = ?",['7'],(err,res,field)=>{
  console.log(res);
})
connection.query("SELECT * FROM users",(err,res,field)=>{
  console.log(res);
})



connection.query("SELECT * FROM users where email=?",['test@gmail.com'],(err,res,field)=>{
  console.log(res);
})

connection.end();