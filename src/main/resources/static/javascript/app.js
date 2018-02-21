'use strict';
var casdemoApp = angular.module('casdemoApp', [ 'ui.grid', 'ui.grid.pagination' ]);

casdemoApp.constant('App', {
    CAMPUS: {
        'MANOA': '7',
        'SYSTEM': '11'
    },
    URL: {
        CAMPUS_LOAD: '/casdemo/api/campuses',
        FEEDBACK: '/casdemo/api/feedabck'
    }
});