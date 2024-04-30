const { Sequelize, DataTypes } = require('sequelize');

// Option 3: Passing parameters separately (other dialects)
const sequelize = new Sequelize('dec2023', 'root', '', {
  host: 'localhost',
  dialect:   'mysql',
  define: {
    timestamps: false
}
});

const User = sequelize.define(
    'users',
    {
      // Model attributes are defined here
      name: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      email: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      password: {
        type: DataTypes.STRING,
        allowNull: false,
      }, country: {
        type: DataTypes.STRING,
      }
    }
  );

(async()=>{
    try {
        await sequelize.authenticate();
        console.log('Connection has been established successfully.');
        // const user = new User({name:"sequlize",email:'sequlize@gmail.com',password:'sequlize'});
        // user.save();
         let row = await User.findAll();//get all the data from the table.
        // console.log(row);
         row.forEach((obj)=>{
             console.log(obj.dataValues);
         })
        // await User.update({"password":"sample"},{"where":{"id":"170"}});        
  //      await User.destroy({"where":{"id":"169"}});        
        sequelize.close();
      } catch (error) {
        console.error('Unable to connect to the database:', error);
      }
})()

