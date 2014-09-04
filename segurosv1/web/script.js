var app = angular.module("app", ['ngRoute']);

function RemoteResource($http, $q, baseUrl) {
    this.get = function(idSeguro) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;

    };

    this.list = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/SeguroMedico'
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });


        return promise;
    };

    this.insert = function(seguroMedico) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/SeguroMedico',
            data: seguroMedico
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.update = function(idSeguro, seguroMedico) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro,
            data: seguroMedico
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.delete = function(idSeguro) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

}

function RemoteResourceProvider() {
    var _baseUrl;
    this.setBaseUrl = function(baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', '$q', function($http, $q) {
            return new RemoteResource($http, $q, _baseUrl);
        }];
};

app.provider("remoteResource", RemoteResourceProvider);


app.constant("baseUrl", ".");
app.config(['baseUrl', 'remoteResourceProvider',
    function(baseUrl, remoteResourceProvider) {
        remoteResourceProvider.setBaseUrl(baseUrl);
    }
]);

app.value("urlLogo", "http://www.cursoangularjs.es/lib/exe/fetch.php?cache=&media=unidades:04_masdirectivas:medical14.png");
app.run(["$rootScope", "urlLogo", function($rootScope, urlLogo) {
        $rootScope.urlLogo = urlLogo;
    }]);


app.filter("filteri18n", ["$filter", function($filter) {
        var filterFn = $filter("filter");

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
            if (normalize(actual).indexOf(normalize(expected)) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        /** Este es realmente el filtro **/
        function filteri18n(array, expression) {
            //Lo único que hace es llamar al filter original pero pasado
            //la nueva función de comparator
            return filterFn(array, expression, comparator);
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

app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/', {
            templateUrl: "main.html",
            controller: "MainController"
        });

        $routeProvider.when('/seguro/listado', {
            templateUrl: "listado.html",
            controller: "ListadoSeguroController",
            resolve: {
                seguros: ['remoteResource', function(remoteResource) {
                        return remoteResource.list();
                    }]
            }
        });

        $routeProvider.when('/seguro/edit/:idSeguro', {
            templateUrl: "detalle.html",
            controller: "EditSeguroController",
            resolve: {
                seguro: ['remoteResource', '$route', function(remoteResource, $route) {
                        return remoteResource.get($route.current.params.idSeguro);
                    }]
            }
        });

        $routeProvider.when('/seguro/new', {
            templateUrl: "detalle.html",
            controller: "NewSeguroController"
        });

        $routeProvider.otherwise({
            redirectTo: '/'
        });

    }]);

app.controller("NewSeguroController", ['$scope', 'remoteResource', '$location', function($scope, remoteResource, $location) {

        $scope.filtro = {
            ape1: ""
        };

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
        };


        $scope.guardar = function() {
            if ($scope.form.$valid) {
                remoteResource.insert($scope.seguro).then(function() {
                    $location.path("/seguro/listado");
                }, function(bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            } else {
                alert("Hay datos inválidos");
            }
        };

    }]);

app.controller("EditSeguroController", ['$scope', 'seguro', 'remoteResource', '$location', function($scope, seguro, remoteResource, $location) {

        $scope.filtro = {
            ape1: ""
        };

        $scope.sexos = [{
                codSexo: "H",
                descripcion: "Hombre"
            }, {
                codSexo: "M",
                descripcion: "Mujer"
            }];

        $scope.seguro = seguro;


        $scope.guardar = function() {
            if ($scope.form.$valid) {
                remoteResource.update($scope.seguro.idSeguro, $scope.seguro).then(function() {
                    $location.path("/seguro/listado");
                }, function(bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            } else {
                alert("Hay datos inválidos");
            }
        };

    }]);

app.controller("ListadoSeguroController", ['$scope', 'seguros', 'remoteResource', function($scope, seguros, remoteResource) {
        $scope.seguros = seguros;

        $scope.borrar = function(idSeguro) {
            remoteResource.delete(idSeguro).then(function() {
                remoteResource.list().then(function(seguros) {
                    $scope.seguros = seguros;
                }, function(bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            }, function(bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        };

    }]);

app.controller("MainController", ['$scope', function($scope) {

    }]);