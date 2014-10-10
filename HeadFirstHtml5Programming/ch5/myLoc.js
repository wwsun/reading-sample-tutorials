/**
 * Created by Weiwei on 10/6/2014.
 */

window.onload = getMyLocation;

var ourCoords = {
    latitude: 31.885601399999995,
    longitude: 118.8138982
};

function getMyLocation() {
    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(displayLocation, displayError);
    } else {
        alert("Oops, no geolocation support!")
    }
}

function displayLocation(position) {
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;

    var div = document.getElementById("location");
    div.innerHTML = "you are at Latitude: " + latitude + ", Longitude: " + longitude;

    var km = computeDistance(position.coords, ourCoords);
    var distance = document.getElementById("distance");
    distance.innerHTML = "you are " + km + " km from the WickedlySmart HQ";

    showMap(longitude, latitude);
}

function displayError(error) {
    var errorTypes = {
        0: "Unknown error",
        1: "Permission denied by user",
        2: "Position is not available",
        3: "Request timed out"
    };

    var errorMessage = errorTypes[error.code];
    if(error.code ==0 || error.code == 2) {
        errorMessage = errorMessage + " " + error.message;
    }
    var div = document.getElementById("location");
    div.innerHTML("errorMessage");
}

function computeDistance(startCoords, destCoords) {
    var startLatRads = degreesToRadians(startCoords.latitude);
    var startLongRads = degreesToRadians(startCoords.longitude);
    var destLatRads = degreesToRadians(destCoords.latitude);
    var destLongRads = degreesToRadians(destCoords.longitude);

    var Radius = 6371; //radius of the Earth in km
    var distance = Math.acos(Math.sin(startLatRads) * Math.sin(destLatRads) +
                            Math.cos(startLatRads) * Math.cos(destLatRads) *
                            Math.cos(startLongRads - destLongRads)) * Radius;

    return distance;
}

function degreesToRadians(degree){
    var radians = (degree * Math.PI)/180;
    return radians;
}

function showMap(longitude, latitude){
    var map = new BMap.Map("container");
    var point = new BMap.Point(longitude,latitude);
    var marker = new BMap.Marker(point);
    map.centerAndZoom(point, 15);
    map.addOverlay(marker);
}