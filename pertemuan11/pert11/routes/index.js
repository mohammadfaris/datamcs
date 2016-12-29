var express = require('express');
var router = express.Router();
var connection = require('../config/db');
var passport = require('passport');

router.get('/', function(req, res, next){
	res.render('sign-in');
});

router.get('/home', function( req, res, next){
	res.render('home');
});

router.get('/auth/facebook', passport.authenticate('facebook', { scope: ['email' , 'public_profile'] }));

router.get('/auth/facebook/callback',
  passport.authenticate('facebook', { failureRedirect: '/' }), function(req, res) {
  	var user = {
  		fb_id: req.user.id,
  		username: req.user.displayName,
  		useremail: req.user.emails[0].value
  	};

  	//kalau user sudah pernah login
  	var sql = "SELECT * FROM user WHERE fb_id = ?"
  	var param = [user.fb_id];

  	connection.query(sql, param, function(err, result) {
  		if (err) {
  			console.log(err);
  			throw err;
  		};
  		if( result.length == 0) {
  			var sql1 = "INSERT INTO user (username, fb_id, email) VALUES (?,?,?)";
  			var param1 = [user.username, user.fb_id, user.useremail];

  			connection.query(sql1, param1, function(err1, result1) {
  				if (err1) {
  					console.log(err1);
  					throw err1;
  				}

  				connection.query(sql, param, function(err2, result2) {
  					if (err2) {
  						console.log(err2);
  						throw err2;
  					}
  					if (result2.length >0) {
  						res.redirect('/home');
  					};
  				});
  			});
  		}
  		else {
  			res.redirect('/home');
  		}
  	});
  }
);

module.exports = router;
	