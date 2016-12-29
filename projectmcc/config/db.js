var mysql = require('mysql');

var connection = mysql.createConnection({
	host:'localhost',
	user:'root',
	password:'',
	database:'cakeshop'
});

connection.connect();

console.log("Connection Success!");

module.exports = connection;