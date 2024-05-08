const nodemailer = require('nodemailer');

let transporter = nodemailer.createTransport({
    host: 'sandbox.smtp.mailtrap.io',
    port: '2525',
    auth:{
        user:'307371a588ff57',
        pass:'31f1c402a7e7bb'
    }
   
  });


let messageOptions = {
    from: 'test@example.com',
    to: 'twst@example.com',
    subject: 'test Email from nodejs',
    html: '<h1>this is heading.</h1>'
  };

  transporter.sendMail(messageOptions,(err,info)=>{
    if(err){
        throw err
    }else{
        console.log("email send");
    }
  })