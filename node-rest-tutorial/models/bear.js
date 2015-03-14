/**
 * Created by Weiwei on 2015/3/13.
 */

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var BearSchema = Schema({
    name: String
});

module.exports = mongoose.model('Bear', BearSchema);