(function() {

    function RoleJsController($scope, dataProvider) {
        const URL_LOAD = '/casdemo/api/roles';
        $scope.roles = [];

        $scope.init = function() {
            $scope.loadData();
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(data) {
                $scope.roles = data;
            }, URL_LOAD);
        }
    }
    casdemoApp.controller("RoleJsController", RoleJsController);

})();
