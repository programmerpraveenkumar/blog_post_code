// var SequelizeMock = require('sequelize-mock');
// const sequelizeObj = require('../config/DbCon');÷
 const {UserService} = require("../Service/UserService");

 const sleep = ms => new Promise(resolve => setTimeout(resolve, ms));

describe("login", () => {
  afterEach(async () => {
    await sleep(2000);
  });
test('1# Login success', async () => {
  const userService = new UserService()
  const registeredUser = await userService.login('','');
    console.log(registeredUser);
  // // expect(UserModel.login).toHaveBeenCalledTimes(1);
  // // expect(registeredUser).toBeInstanceOf(UserModel);
   expect(registeredUser).toEqual('token generated!!!')
});
test('#2 Login failure', async () => {
  const userService = new UserService()
  const registeredUser = await userService.login('admin','pwd');
  console.log(registeredUser);
  // // expect(UserModel.login).toHaveBeenCalledTimes(1);
  // expect(registeredUser)
});
});