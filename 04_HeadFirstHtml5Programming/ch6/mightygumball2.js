/**
 * Created by Weiwei on 10/6/2014.
 */

window.onload = function () {
    setInterval(handleRefresh, 3000);
    handleRefresh();
};

function handleRefresh() {
    //alert("I'm live");
    var url = "http://gumball.wickedlysmart.com?callback=updateSales" +
            "&random="+(new Date()).getTime();

    var newScriptElement = document.getElementById("script");
    newScriptElement.setAttribute("src", url);
    newScriptElement.setAttribute("id","jsonp");

    var oldScriptElement = document.getElementById("jsonp");
    var head = document.getElementsByTagName("head")[0];
    if(oldScriptElement == null) {
        head.appendChild(newScriptElement);
    }else{
        head.replaceChild(newScriptElement);
    }
}

function updateSales(sales){
    var salesDiv = document.getElementById("sales");
    for(var i=0; i<sales.length; i++){
        var sale = sales[i];
        var div = document.createElement("div");
        div.innerHTML = sale.name + " sold " + sale.sales + " gumballs";
        salesDiv.appendChild(div);
    }
}