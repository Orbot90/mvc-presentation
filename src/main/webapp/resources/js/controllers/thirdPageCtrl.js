'use strict';

app.controller('ThirdPageController', ['$scope', '$http',
    function($scope, $http) {

        $scope.form = {};

        $scope.send = function() {
            $scope.errors = null;
            $scope.response = null;
            var model = {
                name: $scope.form.name,
                email: $scope.form.email
            };

            $http({
                method: 'POST',
                url: '/thirdpagepost',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: $.param(model)
            }).success(function(data) {
                $scope.lock = false;
                $scope.response = data;
            }).error(function(data) {
                $scope.lock = false;
                $scope.errors = data ? data.fieldErrors : null;
            });
            $scope.lock = true;
        }
    }]);