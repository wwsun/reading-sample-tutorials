/**
 * Created by Weiwei on 10/5/2014.
 */

var fido = {
    name: "well",
    weight: 40,
    breed: "mixed",
    loves: ["walks", "fetching balls"]
};

var movie1 = {
    title: "Plan 9 from outer space",
    genre: "Cult classic",
    rating: 5,
    showtimes: ["3:00 pm","7:00 pm","11:00 pm"],
    getNextShowing: function() {
        var now = new Date().getTime();

        for(var i=0; i < this.showtime.length; i++){
            var showtime = getTimeFromString(this.showTimes[i]);
            if((showtime - now) > 0){
                return "Next showing of " + this.title + " is " + this.showtimes[i];
            }
        }


        return null;
    }
};

var movie2 = {
    title: "Forbidden Planet",
    genre: "Classic Sci-fi",
    rating: 5,
    showtimes: ["5:00 pm","9:00 pm"]
};

function getTimeFromString(timeString){
    var theTime = new Date();
    var time = timeString.match(/(\d+)(?::(\d\d))?\s*(p?)/);
    theTime.sethours(parseInt(time[1]) + (time[3] ? 12:0));
    theTime.setMinutes(parseInt(time[2]) || 0);
    return theTime.getTime();
}

var nextShowing = getNextShowing(moive1);
alert(nextshowing);
nextShowing = getNextShowing(movie2);
alert(nextshowing);