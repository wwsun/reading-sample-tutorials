/**
 * Created by Weiwei on 10/8/2014.
 */

onmessage = pingPong;
function pingPong(event) {
    if(event.data == "ping") {
        postMessage("Pong");
    }
}