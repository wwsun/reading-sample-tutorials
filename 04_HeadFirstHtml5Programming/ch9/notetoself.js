/**
 * Created by Weiwei on 10/7/2014.
 */

window.onload = init;

function init(){
    var button = document.getElementById("add_button");
    var clearBtn = document.getElementById("clear_button");

    clearBtn.onclick = clearStorage;
    button.onclick = createSticky;

    //var stickyArray = localStorage["stickyArray"];
    var stickyArray = getStickyArray();

    if(!stickyArray) {
        stickyArray = [];
        localStorage.setItem("stickyArray", JSON.stringify(stickyArray));
    } else {
        stickyArray = JSON.stringify(stickyArray);
    }

    for(var i=0; i < stickyArray.length; i++) {
        var key = stickyArray[i];
        var value = localStorage[key];
        //var value = localStorage.getItem(key);
        addStickyToDOM(value);
    }

//    for(var i=0; i<localStorage.length; i++) {
//        var key = localStorage.key(i);
//        if(key.substring(0, 6) == "sticky") {
//            var value = localStorage.getItem(key);
//            addStickyToDOM(value);
//        }
//    }
}

function addStickyToDOM(key, value) {
    var stickies = document.getElementById("stickies");
    var sticky = document.createElement("li");

    sticky.setAttribute("id", key);

    var span = document.createElement("span");
    span.setAttribute("class","sticky");
    span.innerHTML = value;
    sticky.appendChild(span);
    stickies.appendChild(sticky);

    sticky.onclick = deleteSticky;
}

function deleteSticky(e) {
    var key = e.target.id;
    if(e.target.tagName.toLowerCase() == "span") {
        key = e.target.parentNode.id;
    }
    localStorage.removeItem(key);
    var stickyArray = getStickyArray();
    if(stickyArray) {
        for (var i=0; i<stickyArray.length; i++) {
            if(key == stickyArray[i]) {
                stickyArray.splice(i,1);
            }
        }
        localStorage.setItem("stickyArray", JSON.stringify(stickyArray));
        removeStickyFromDOM(key);
    }
}

function removeStickyFromDOM(key) {
    var sticky = document.getElementById(key);
    sticky.parentNode.removeChild(sticky);
}


function createSticky(){
    var value = document.getElementById("note_text").value;
    var currentDate = new Date();
    var time = currentDate.getTime();
    //var key = "sticky_" + localStorage.length;
    var key = "sticky_" + time;

    var stickyArray = getStickyArray();

    //localStorage.setItem(key, value);
    localStorage.setItem(key, value);
    stickyArray.push(key);
    localStorage.setItem("stickyArray", JSON.stringify(stickyArray));
    addStickyToDOM();
}


function getStickyArray() {
    var stickyArray = localStorage.getItem("stickyArray");
    if(!stickyArray) {
        stickyArray = [];
        localStorage.setItem("stickyArray", JSON.stringify(stickyArray));
    } else {
        stickyArray = JSON.parse(stickyArray);
    }

    return stickyArray;
}

function clearStorage(){
    localStorage.clear();
}