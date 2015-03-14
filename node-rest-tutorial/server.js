/**
 * Created by Weiwei on 2015/3/13.
 */

// BASE SETUP

var express = require('express');
var app = express();
var bodyParser = require('body-parser');

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/api-test');

var Bear = require('./models/bear');

// middleware
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

var port = process.env.PORT || 8080;

// ROUTERS FOR OUR API
var router = express.Router();

// middleware to use for all requests
router.use(function (req, res, next) {
    console.log('Something is happening!');
    next();
});

// test route to make sure everything is working (accessed at GET http://localhost:8080/api)
router.get('/', function (req, res) {
    res.json({message: 'hooray! welcome to our api!'});
});

router.route('/bears')

    // create a bear (accessed at POST http://localhost:8080/api/bears)
    .post(function (req, res) {
        var bear = new Bear();
        bear.name = req.body.name;
        bear.save(function (err) {
            if (err) res.send(err);
            res.json({message: 'Bear Created!'});
        });
    })

    // get all the bears (accessed at GET http://localhost:8080/api/bears)
    .get(function (req, res) {
        Bear.find(function (err, bears) {
            if (err) res.send(err);
            res.json(bears);
        });
    });

router.route('/bears/:bear_id')

    .get(function (req, res) {
        Bear.findById(req.params.bear_id, function (err, bear) {
            if (err) res.send(err);
            res.json(bear);
        });
    })

    .put(function (req, res) {

        Bear.findById(req.params.bear_id, function (err, bear) {
            if (err) res.send(err);
            bear.name = req.body.name; // update the bears info

            // save the bear
            bear.save(function (err) {
                if (err) res.send(err);
                res.json({message: 'Bear updated!'});
            });
        });
    })

    .delete(function (req, res) {
        Bear.remove({_id: req.params.bear_id}, function (err, bear) {
            if (err) res.send(err);
            res.json({message: 'Successfully deleted!'});
        });
    });

// REGISTER OUR ROUTES
app.use('/api', router);

// START THE SERVER
app.listen(port);
console.log('Magic happens on port ' + port);