(function() {

    function RoleJsController($scope, App, dataProvider) {
        $scope.roles = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.roles = data;
            }, App.URL.API.ROLE);
        }
    }
    casdemoApp.controller("RoleJsController", RoleJsController);

})();
