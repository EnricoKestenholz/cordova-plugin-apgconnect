var exec = require('cordova/exec');

var apgconnect = function() {
    var onsucess = function(){
        //console.log('apg success');
    };
    var onfail = function(){
        //console.log('apg fail');
    };
    this.permissionGranted = function(setting, onsucess, onfail) {
    	exec(onsucess, onfail, "apgconnect", "permissionGranted", []);
    };
    this.newPage = function(setting, onsucess, onfail) {
    	exec(onsucess, onfail, "apgconnect", "newPage", []);
    };
    exec(onsucess, onfail, "apgconnect", "init", []);
};


module.exports = new apgconnect();


window.__APGconnect__callback = function(data){

    var keyword_array = data.apg_keywords;

};
