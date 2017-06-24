(function() {

    function CampusJsController($scope, dataProvider) {
        const URL_CAMPUS_LOAD = '/casdemo/api/campuses';
        $scope.campuses = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.campuses = data;
            }, URL_CAMPUS_LOAD);
        }
    }
    casdemoApp.controller("CampusJsController", CampusJsController);

})();
