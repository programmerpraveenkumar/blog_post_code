var jwt = require('jsonwebtoken');
const SECRET = 'shhhhh';

var token = jwt.sign({ foo: 'bar' }, SECRET,{expiresIn:5});
console.log(token);

try{
   var de_token = jwt.verify(token,SECRET);
   console.log(de_token);
}catch(e){
    console.log(e);
}
