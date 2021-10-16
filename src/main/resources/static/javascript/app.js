/*global casdemoApp*/
/*eslint no-undef: "error"*/

"use strict";
var casdemoApp = angular.module("casdemoApp", [ "ui.grid", "ui.grid.pagination" ]);

casdemoApp.constant("App", {
    Campus: {
        "MANOA": "7",
        "SYSTEM": "11"
    },
    Url: {
        FEEDBACK: "/casdemo/feedback/",
        Api: {
            CAMPUS: "/casdemo/api/campuses",
            ERROR: "/casdemo/api/error/",
            HOLIDAY: "/casdemo/api/holidays",
            ROLE: "/casdemo/api/roles"
        }
    }
});