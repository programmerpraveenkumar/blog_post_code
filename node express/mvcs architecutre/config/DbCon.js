const { Sequelize, DataTypes } = require('sequelize');
// const { DB_USR,DB_PWD } = require('../config');
const sequelizeObj = new Sequelize('dec2023', 'root', '', {
    dialect: 'mysql'
  });
 
 (async()=>{
    try {
        await sequelizeObj.authenticate();
        console.log('Connection has been established successfully.');
        return sequelizeObj;
    } catch (error) {
        console.error('Unable to connect to the database:', error);
    }
})();

  module.exports=  {sequelizeObj};