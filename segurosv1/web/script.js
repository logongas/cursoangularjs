var app = angular.module("app", ['ngRoute']);

function RemoteResource($http,$q, baseUrl) {
  this.get = function(idSeguro) {
    var defered=$q.defer();
    var promise=defered.promise;
    
    $http({
      method: 'GET',
      url: baseUrl + '/datos' + idSeguro + '.json'
    }).success(function(data, status, headers, config) {
      defered.resolve(data);
    }).error(function(data, status, headers, config) {
      defered.reject(status);
    });
    
    return promise;
    
  }
  this.list = function() {
    var defered=$q.defer();
    var promise=defered.promise;    
    
    $http({
      method: 'GET',
      url: baseUrl + '/listado_seguros.json'
    }).success(function(data, status, headers, config) {
      defered.resolve(data);
    }).error(function(data, status, headers, config) {
      defered.reject(status);
    });
    
    
    return promise;
  }
}

function RemoteResourceProvider() {
  var _baseUrl;
  this.setBaseUrl = function(baseUrl) {
    _baseUrl = baseUrl;
  }
  this.$get = ['$http','$q',function($http,$q) {
      return new RemoteResource($http,$q, _baseUrl);
  }];
}

app.provider("remoteResource", RemoteResourceProvider);


app.constant("baseUrl", ".");
app.config(['baseUrl', 'remoteResourceProvider',
  function(baseUrl, remoteResourceProvider) {
    remoteResourceProvider.setBaseUrl(baseUrl);
  }
]);

app.value("urlLogo", "http://www.cursoangularjs.es/lib/exe/fetch.php?cache=&media=unidades:04_masdirectivas:medical14.png");
app.run(["$rootScope", "urlLogo",function($rootScope, urlLogo) {
    $rootScope.urlLogo = urlLogo;
}]);


app.filter("filteri18n",["$filter",function($filter) {
  var filterFn=$filter("filter");
   
  /** Transforma el texto quitando todos los acentos diéresis, etc. **/
  function normalize(texto) {
    texto = texto.replace(/[áàäâ]/g, "a");
    texto = texto.replace(/[éèëê]/g, "e");
    texto = texto.replace(/[íìïî]/g, "i");
    texto = texto.replace(/[óòôö]/g, "o");
    texto = texto.replace(/[úùüü]/g, "u");
    texto = texto.toUpperCase();
    return texto;
  }
    
  /** Esta función es el comparator en el filter **/
  function comparator(actual, expected) {
      if (normalize(actual).indexOf(normalize(expected))>=0) {
        return true;
      } else {
        return false;
      }
  }
   
  /** Este es realmente el filtro **/
  function filteri18n(array,expression) {
    //Lo único que hace es llamar al filter original pero pasado
    //la nueva función de comparator
    return filterFn(array,expression,comparator)
  }
   
  return filteri18n;
   
}]);


app.directive('caDatepicker', [function(dateFormat) {
  return {
    restrict: 'A',
    link: function($scope, element, attributes) {
    
      element.datepicker({
        dateFormat: attributes.caDatepicker,
        onSelect: function() {
          $(this).trigger('change');
        }
      });
    }
  };
}]);

app.config(['$routeProvider',function($routeProvider) {
 
  $routeProvider.when('/', {
    templateUrl: "main.html",
    controller: "MainController"
  }); 
 
  $routeProvider.when('/seguro/listado', {
    templateUrl: "listado.html",
    controller: "ListadoSeguroController",
    resolve: {
      seguros:['remoteResource',function(remoteResource) {
        return remoteResource.list();
      }]
    }
  });
     
  $routeProvider.when('/seguro/edit/:idSeguro', {
    templateUrl: "detalle.html",
    controller: "DetalleSeguroController",
    resolve: {
      seguro:['remoteResource','$route',function(remoteResource,$route) {
        return remoteResource.get($route.current.params.idSeguro);
      }]
    }
  });
   
  $routeProvider.otherwise({
        redirectTo: '/'
  });   
 
}]);
 

app.controller("DetalleSeguroController", ['$scope', 'seguro',function($scope, seguro) {

    $scope.filtro = {
      ape1: ""
    }

    $scope.sexos = [{
      codSexo: "H",
      descripcion: "Hombre"
    }, {
      codSexo: "M",
      descripcion: "Mujer"
    }];


    $scope.seguro = {
      nif: "",
      nombre: "",
      ape1: "",
      edad: undefined,
      sexo: "",
      casado: false,
      numHijos: undefined,
      embarazada: false,
      coberturas: {
        oftalmologia: false,
        dental: false,
        fecundacionInVitro: false
      },
      enfermedades: {
        corazon: false,
        estomacal: false,
        rinyones: false,
        alergia: false,
        nombreAlergia: ""
      },
      fechaCreacion: new Date()
    }

    $scope.seguro = seguro;


  $scope.guardar=function() {
    if ($scope.form.$valid) {
      alert("Los datos aqui se habrían enviado al servidor  y estarían validados en la parte cliente");
    }else {
      alert("Hay datos inválidos");
    }
  }

}]);

app.controller("ListadoSeguroController", ['$scope', 'seguros',function($scope, seguros) {
    $scope.seguros = seguros;
}]);

app.controller("MainController", ['$scope',function($scope) {

}]);