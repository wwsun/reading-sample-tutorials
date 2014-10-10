window.onload = function() {

//    var url = "http://localhost:63342/html5programming/ch6/sales.json";
//    var request = new XMLHttpRequest();
//
//    request.open("GET", url);
//    request.onload = function() {
//        if(request.status == 200) {
//            updateSales(request.responseText)
//        }
//    };
//    request.send(null);


};

//function updateSales(responseText){
function updateSales(sales){
    var salesDiv = document.getElementById("sales");
   // salesDiv.innerHTML = responseText;
   // var sales = JSON.parse(responseText);

    for(var i=0; i<sales.length; i++){
        var sale = sales[i];
        var div = document.createElement("div");
        div.innerHTML = sale.name + " sold " + sale.sales + " gumballs";
        salesDiv.appendChild(div);
    }
}