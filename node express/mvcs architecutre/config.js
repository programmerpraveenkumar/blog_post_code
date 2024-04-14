const dotenv = require('dotenv');
dotenv.config();

module.exports = {
  DB_USR: process.env.DB_USR,
  DB_PWD: process.env.DB_PWD
};