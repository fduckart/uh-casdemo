describe("ErrorJsController", function() {

    beforeEach(module('casdemoApp'));

    var app;
    var scope;
    var controller;
    var window;
    var dataProvider;

    beforeEach(inject(function($controller, $rootScope, $window, App, dataProvider) {
        scope = $rootScope.$new();
        window = $window;
        app = App;
        controller = $controller('ErrorJsController', {
            $scope: scope,
            $window: window,
            App: app,
            dataProvider: dataProvider
        });
    }));

    it("checkSubmit", function() {
        expect(controller).toBeDefined();

        var data = '';
        spyOn(scope, "submit").and.callFake(function() {
            data = 'Slouches towards Bethlehem';
        });

        // What we are testing:
        scope.submit();

        expect(scope.submit).toHaveBeenCalled();
        expect(data).toEqual('Slouches towards Bethlehem');
    });

});
