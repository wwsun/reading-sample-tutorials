/**
 * Created by Weiwei on 10/8/2014.
 */

window.onload = function () {
    var worker = new Worker("worker.js");

    worker.postMessage("ping");

    //receive message from worker
    worker.onmessage = function (event) {
        var message = "Worker says " + event.data;
        document.getElementById("output").innerHTML = message;
    }
};
