angular.module("companyApp", []).value('baseUrl', `http://localhost:8080/backend_war_exploded/api/company/`).controller("CompanyController", function ($http, baseUrl) {

    let self = this;
    self.company = undefined;

    self.companies = [];
    self.company = {};

    self.displayForm = false;

    self.showCreateForm = function () {
        self.company = {};
        self.displayForm = true
    }

    self.showUpdateForm = function (company) {
        this.company = company;
        self.displayForm = true
    }

    self.hideForm = function () {
        self.company = undefined;
        self.displayForm = false;
    }

    self.create = function () {
        $http({
            method: "POST",
            url: baseUrl + "create",
            data: self.company
        }).then(function successCallback(response) {
            self.refreshPage();
            window.location.reload();
        }).catch(function errorCallback(response) {
            alert(response.data.error)
        });
    }

    self.update = function (company) {
        this.company = company

        $http({
            method: "PUT",
            url: baseUrl + self.company.id,
            data: self.company
        }).then(function successCallback(response) {
            self.refreshPage();
            window.location.reload();
        }).catch(function errorCallback(response) {
            alert(response.data.error)
        });
    }

    self.delete = function (company) {
        this.company = company

        $http({
            method: "DELETE",
            url: baseUrl + self.company.id
        }).then(function successCallback(response) {
            console.log(response)
            self.refreshPage();
        }).catch(function errorCallback(response) {
            console.log(response)
            alert("Erro! confira o log para ter mais informações")
        });
    }

    self.refreshPage = function () {
        $http({
            method: "GET",
            url: baseUrl
        }).then(function successCallback(response) {
            self.companies = response.data;
            self.company = undefined;
        }).catch(function errorCallback(response) {
            alert("Erro! confira o log para ter mais informações")
        });
    }

    self.refreshPage();
})