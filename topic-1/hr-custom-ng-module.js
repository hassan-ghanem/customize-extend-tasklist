'use strict';
define('hr-custom-ng-module', [
        'angular'
    ], function (angular) {

    var customModule = angular.module('hr.custom.module', []);

    customModule.config(['$httpProvider', function ($httpProvider) {
                // initialize get if not there
                if (!$httpProvider.defaults.headers.get) {
                    $httpProvider.defaults.headers.get = {};
                }

                // disable IE ajax request caching
                $httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
                // extra
                $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
                $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
            }
        ]);

    customModule.factory('EmployeeService', ['$http', '$q', 'Uri', function ($http, $q, Uri) {

                return {

                    getEmployee: function (userId) {

                        return $http.get(Uri.appUri('/camunda/hr-rest/:engine/employee/') + userId)
                        .then(
                            function successCallback(response) {

                            return response.data;
                        },
                            function errorCallback(err) {

                            console.error('Error while fetching employee');

                            return $q.reject(err);
                        });
                    }
                };
            }
        ]);

    return customModule;
});
