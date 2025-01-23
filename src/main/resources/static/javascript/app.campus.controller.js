/*eslint no-undef: "error"*/

(function() {
    "use strict";

    function CampusJsController($scope, App, dataProvider) {
        $scope.campuses = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.campuses = data;
            }, App.Url.Api.CAMPUS);
        };
    }
    casdemoApp.controller("CampusJsController", CampusJsController);

})();
