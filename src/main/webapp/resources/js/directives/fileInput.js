'use strict';

app.directive('fileinput', function() {
    return {
        restrict: 'E',
        templateUrl: '/fileform.html',
        replace: true,
        scope: true,
        link: function($scope, element, attrs) {
            var input = $(element.find("input"));
            var label = $(element.find("span")[0]);
            var button = $(element.find("button")[0]);

            var emptyText = "File not chosen";

            button.focus(function() {
                input.focus();
            });

            button.add(label).click(function() {
                input.click();
            });

            var file_api = ( window.File && window.FileReader
                && window.FileList && window.Blob ) ? true : false;

            input.change(function() {
                var file_name;
                if( file_api && input[ 0 ].files[ 0 ] )
                    file_name = input[ 0 ].files[ 0 ].name;
                else
                    file_name = input.val().replace( "C:\\fakepath\\", '' );

                if( ! file_name.length ) {
                    label.text(emptyText);
                } else {
                    label.text(file_name);
                }
            }).change();
        }
    }
})