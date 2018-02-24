(function() {
    'use strict';

    function ErrorJsController($scope, $window, App, dataProvider) {
        $scope.submit = function() {
            var data = 'What is the What?';
            dataProvider.saveData(function(data) {
                console.log('FeedyJsController.ok; data: ', data);
                var error = encodeURI(data);
                $window.location.href = App.URL.FEEDBACK + error;
            }, App.URL.API.ERROR + '666');
        };
    }
    casdemoApp.controller("ErrorJsController", ErrorJsController);

})();
