var app = angular.module("bookStoreApp", ['ngRoute', 'bookStoreControllers']);

app.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'partials/booklist.html',
        controller: 'bookListController'
      });

      $locationProvider.html5Mode(false).hashPrefix('!');
  }]);
