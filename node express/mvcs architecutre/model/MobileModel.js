const {  DataTypes } = require('sequelize');
const {sequelizeObj} = require("../config/DbCon");
const MobileModel = sequelizeObj.define('mobiles', {
    // Model attributes are defined here
   
    mobile: {
      type: DataTypes.STRING
      // allowNull defaults to true
    }
  });
 module.exports = { MobileModel }
