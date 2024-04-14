const {  DataTypes } = require('sequelize');
const {sequelizeObj} = require("../config/DbCon");
const { MobileModel } = require('./MobileModel');
const UserModel = sequelizeObj.define('user', {
    // Model attributes are defined here
    name: {
      type: DataTypes.STRING,
      allowNull: false
    },
    email: {
      type: DataTypes.STRING
      // allowNull defaults to true
    },
    password: {
      type: DataTypes.STRING
      // allowNull defaults to true
    }
  });
  UserModel.hasMany(MobileModel,{foreignKey:"u_id"})
 module.exports = { UserModel }
