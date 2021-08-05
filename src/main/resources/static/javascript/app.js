/*global casdemoApp*/
/*eslint no-undef: "error"*/

"use strict";
var casdemoApp = angular.module("casdemoApp", [ "ui.grid", "ui.grid.pagination" ]);

casdemoApp.constant("App", {
    CAMPUS: {
        "MANOA": "7",
        "SYSTEM": "11"
    },
    URL: {
        CAMPUS_LOAD: "/casdemo/api/campuses",
        FEEDBACK: "/casdemo/feedback/",
        API: {
            CAMPUS: "/casdemo/api/campuses",
            ERROR: "/casdemo/api/error/",
            HOLIDAY: "/casdemo/api/holidays",
            ROLE: "/casdemo/api/roles"
        }
    }
});