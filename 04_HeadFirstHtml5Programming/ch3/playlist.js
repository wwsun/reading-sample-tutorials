/**
 * Created by Weiwei on 10/5/2014.
 */

window.onload = init;

function init(){
    var btn = document.getElementById("addBtn");
    btn.onclick = handlerBtnClick;
    loadPlaylist();
}

function handlerBtnClick() {
    var textInput = document.getElementById("songTextInput");
    var songName = textInput.value;
    if(songName != "" ){
        //alert("Adding: " + songName);
        var li = document.createElement("li");
        li.innerHTML = songName;

        var ul = document.getElementById("playlist");
        ul.appendChild(li);
        save(songName);
    } else {
        alert("Please input something!");
    }
}