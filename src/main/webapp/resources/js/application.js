"use strict";

var app = angular.module("examples", ["ngRoute"])
    .config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when('/first', {
                templateUrl: '/first.html'
            })
            .when('/second', {
                templateUrl: '/second.html'
            })
            .when('/third', {
                templateUrl: '/third.html',
                controller: 'ThirdPageController'
            })
            .otherwise({ redirectTo: '/first'});
    }]);