const nodemailer = require('nodemailer');

const transporter = nodemailer.createTransport({
    port: 465, 
    host: "smtp.gmail.com",
       auth: {
            user: 'youremail@gmail.com',
            pass: 'password',
         },
    secure: true,
    }); 

    const mailData = {
        from: 'youremail@gmail.com',  // sender address
          to: 'myfriend@gmail.com',   // list of receivers
          subject: 'Sending Email using Node.js',
         html: '<b>Hey there! </b>',
        };
        transporter.sendMail(mailData, function (err, info) {
   if(err)
     console.log(err)
   else
     console.log(info);
});