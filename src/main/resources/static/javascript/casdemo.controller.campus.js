(function() {

    function CampusJsController($scope, App, dataProvider) {
        $scope.url = App.URL.API.CAMPUS;
        $scope.campuses = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.campuses = data;
            }, $scope.url);
        }
    }
    casdemoApp.controller("CampusJsController", CampusJsController);

}());
