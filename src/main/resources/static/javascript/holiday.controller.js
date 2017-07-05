(function() {
    'use strict';

    function HolidayJsController($scope, dataProvider) {
        const URL_HOLIDAY_LOAD = '/casdemo/api/holidays';
        $scope.years = [];

        $scope.init = function() {
            var date = new Date();
            var year = date.getFullYear();
            $scope.yearCode = year.toString();
            $scope.maxYear = year;
            $scope.years = [];
            $scope.years.push(year);

            dataProvider.loadData(function(d) {
                var data = d.data;
                $scope.holidays = data;
                for (var i = 0; i < data.length; i++) {
                    var y = parseInt(data[i].year);
                    if ($scope.years.indexOf(y) < 0) {
                        $scope.years.push(y);
                    }
                }
                $scope.years.sort(function(a, b) {
                    return b - a
                });
            }, URL_HOLIDAY_LOAD);

        };
    }
    casdemoApp.controller("HolidayJsController", HolidayJsController);

    function HolidayGridJsController($scope, holidayJsService) {
        var options = {
            pageNumber: 1,
            pageSize: 10,
            sort: null
        };

        holidayJsService.getHolidays(options.pageNumber, options.pageSize).success(function(data) {
            $scope.gridOptions.data = data.content;
            $scope.gridOptions.totalItems = data.totalElements;
        });

        $scope.gridOptions = {
            paginationPageSizes: [ 10, 15, 20, 250 ],
            paginationPageSize: options.pageSize,
            enableColumnMenus: false,
            useExternalPagination: true,
            columnDefs: [ {
                name: 'description'
            }, {
                name: 'observedDate'
            }, {
                name: 'officialDate'
            } ],
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
