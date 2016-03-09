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
            .when('/fourth', {
                templateUrl: '/fourth.html'
            })
            .otherwise({ redirectTo: '/first'});
    }]);