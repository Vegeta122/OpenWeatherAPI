var weather=angular.module("weather",[]);

weather.controller('location',['$scope',function($scope){
    $scope.city="";
    $scope.weatherDataDTO={};
    $scope.getWeather=function(city){
        $scope.city=city;
        $http.post('/getJson',$scope.city).success(function(data){
            $scope.weatherDataDTO=data;
        });
    }
    
}]);