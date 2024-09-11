/*eslint no-undef: "error"*/

(function() {
    "use strict";

    function HolidayJsController($scope, App, dataProvider) {
        $scope.years = [];

        $scope.init = function() {
            const date = new Date();
            const year = date.getFullYear();
            $scope.yearCode = year.toString();
            $scope.years = [year];
            $scope.loadData();
            $scope.years.sort(function(a, b) {
                return b - a;
            });
        };

        $scope.loadData = function() {
            dataProvider.loadData(function(d) {
                const data = d.data;
                $scope.holidays = data;
                for (let i = 0; i < data.length; i++) {
                    const y = parseInt(data[i].year);
                    if ($scope.years.indexOf(y) < 0) {
                        $scope.years.push(y);
                    }
                }
            }, App.Url.Api.HOLIDAY);
        };

        $scope.searchFilter = function() {
            return function(e) {
                let text = $scope.searchFor;
                if (angular.isUndefined(text)) {
                    return true;
                }
                text = text.trim().toLowerCase();
                if (text === "") {
                    return true;
                } else if (e.description.toLowerCase().indexOf(text) !== -1) {
                    return true;
                } else if (e.observedDateFull.toLowerCase().indexOf(text) !== -1) {
                    return true;
                } else if (e.officialDateFull.toString().indexOf(text) !== -1) {
                    return true;
                }
                return false;
            };
        };
    }
    casdemoApp.controller("HolidayJsController", HolidayJsController);

    function HolidayGridJsController($scope, holidayJsService) {
        const options = {
            pageNumber: 1,
            pageSize: 10,
            sort: null
        };

        holidayJsService.getHolidays(options.pageNumber, options.pageSize).success(function(data) {
            $scope.gridOptions.data = data.content;
            $scope.gridOptions.totalItems = data.totalElements;
        });

        // noinspection JSUnusedGlobalSymbols
        $scope.gridOptions = {
            paginationPageSizes: [10, 15, 20, 250],
            paginationPageSize: options.pageSize,
            enableColumnMenus: false,
            useExternalPagination: true,
            columnDefs: [{
                name: "description"
            }, {
                name: "observedDate"
            }, {
                name: "officialDate"
            }],
            onRegisterApi: function(gridApi) {
                $scope.gridApi = gridApi;
                gridApi.pagination.on.paginationChanged($scope, function(newPage, pageSize) {
                    options.pageNumber = newPage;
                    options.pageSize = pageSize;
                    holidayJsService.getHolidays(newPage, pageSize).success(function(data) {
                        $scope.gridOptions.data = data.content;
                        $scope.gridOptions.totalItems = data.totalElements;
                    });
                });
            }
        };
    }
    casdemoApp.controller("HolidayGridJsController", HolidayGridJsController);

})();
