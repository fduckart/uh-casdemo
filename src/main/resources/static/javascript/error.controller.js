/*global casdemoApp*/
/*eslint no-undef: "error"*/

(function() {
    "use strict";

    function ErrorJsController($scope, $window, $log, App, dataProvider) {
        $scope.submit = function() {
            var data = "What is the What?";
            dataProvider.saveData(function(data) {
                $log.info("FeedyJsController.ok; data: ", data);
                var error = encodeURI(data);
                $window.location.href = App.URL.FEEDBACK + error;
            }, App.URL.API.ERROR + "666");
        };
    }
    casdemoApp.controller("ErrorJsController", ErrorJsController);

}());
