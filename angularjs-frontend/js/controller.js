'use strict';

var bookListController = angular.module("bookListControllers", []);

bookListController.controller('bookListController', ['$scope', 'BookList',
  function($scope) {

    $scope.bookList = [];

    BookList.get({},
      function success(response) {
        console.log(response);
        $scope.bookList = response;
      },
      function error(errorResponse) {
        console.error(errorResponse);
      }
    );
  }]);
