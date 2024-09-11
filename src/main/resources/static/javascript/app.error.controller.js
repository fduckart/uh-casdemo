/*eslint no-undef: "error"*/

(function() {
    "use strict";

    function ErrorJsController($scope, $window, $log, App, dataProvider) {
        $scope.submit = function() {
            dataProvider.saveData(function(data) {
                $log.info("ErrorJsController.ok; data: ", data);
                const error = encodeURI(data);
                $window.location.href = App.Url.FEEDBACK + error;
            }, App.Url.Api.ERROR + "666");
        };
    }
    casdemoApp.controller("ErrorJsController", ErrorJsController);

})();
