var express = require('express');
var router = express.Router();
var connection = require('../config/db');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('register');
});
router.get('/login', function(req, res, next) {
  res.render('login');
});
router.get('/profile', function(req, res, next){
	var sql = "SELECT * FROM user WHERE id=?";
	var id = req.session.user.id;
	var param = [id];

connection.query(sql,param, function(err,result){
if(err){
console.log(err);
throw err;
}
if(result.length!=0){
			//req.session.user = result[0]; //buat nyimpen data
			res.render('profile',{nama:result[0]});
		}

})
	
});

router.post('/doRegister', function(req, res, next){
var nama = req.body.nama;
var email = req.body.email;
var password = req.body.password;
var address = req.body.address;
var gender = req.body.rbGender;



var sql = "INSERT INTO user (nama,email,password,address,gender) VALUES(?,?,?,?,?)";
var param = [nama,email,password,address,gender];
connection.query(sql,param, function(err,result){
if(err){
console.log(err);
throw err;
}
if(result.length!=0){
			//req.session.user = result[0]; //buat nyimpen data
			res.redirect('/login');
		}else{
			res.redirect('/');
		}
})
});

router.post('/doLogin', function(req, res, next){

var email = req.body.email;
var password = req.body.password;




var sql = "SELECT * FROM user WHERE email=? AND password=?";
var param = [email,password];
connection.query(sql,param, function(err,result){
if(err){
console.log(err);
throw err;
}
if(result.length!=0){
			req.session.user = result[0]; //buat nyimpen data
			res.redirect('/profile');
		}else{
			res.redirect('/login');
		}
})
});
router.post('/doProfile', function(req, res, next){

var email = req.body.email;
var password = req.body.password;




var sql = "SELECT * FROM user ";

connection.query(sql,param, function(err,result){
if(err){
console.log(err);
throw err;
}
if(result.length!=0){
			//req.session.user = result[0]; //buat nyimpen data
			res.redirect('/profile');
		}

})
});

module.exports = router;
