var bookListServices = angular.module('bookListServices', ['ngResource']);

bookListServices.factory('BookList', ['$resource',
  function($resource) {
    return $resource("http://localhost:8080/book/book", {}, {
      get: {method: 'GET', cache: false, isArray: true},
      save: {method: 'POST', cache:false, isArray: false},
      delete: {method: 'DELETE', cache:false, isArray: false}
    });
  }]);
