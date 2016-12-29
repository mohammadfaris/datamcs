var mysql = require('mysql');
var connection = mysql.createConnection({
	host:'localhost',
	user:'prk',
	password:'prk',
	database:'prk'
});

connection.connect();

console.log("Connection Success!");

module.exports = connection;