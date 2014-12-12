/**
 * Created by Weiwei on 12/4/2014.
 */

function HelloController($scope) {
    $scope.greeting = { text: 'Hello'};
}


window.onload = function () {
    function CartController($scope) {
        $scope.items = [
            {title: 'Paint pots', quantity: 8, price: 3.95},
            {title: 'Polka dots', quantity: 17, price: 12.95},
            {title: 'Pebbles', quantity: 5, price: 6.95}
        ];
        $scope.remove = function(index) {
            $scope.items.splice(index, 1);
        };
    }
};
