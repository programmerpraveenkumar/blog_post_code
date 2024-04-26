const readXlsxFile = require('read-excel-file/node')
var mysql = require('mysql');

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'dec2023',  
});
 
connection.connect();


// File path.
readXlsxFile('sample.xlsx').then((rows) => {
    // console.log(rows);
   var data = [];
    rows.forEach(element => {
      //console.log(element);
      data.push([element[1]+" "+element[2],element[4],element[3]]);
    });
   
    connection.query("insert into users (name,country,gender) values ?",[data],(err,res,field)=>{
      console.log(err,res);
      connection.end();
    })
  // `rows` is an array of rows
  // each row being an array of cells.
})
 
