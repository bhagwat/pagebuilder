angular.module('pagebuilder', ['ngResource', 'ui.router', 'ui.bootstrap'])
	.constant('_', window._)

	.factory('RestApiService', ['$resource', function ($resource) {
		return {
			dataType: $resource('/api/v1/dataType/:id', {id: '@id'}),
			template: $resource('/api/v1/template/:id', {id: '@id'}),
			model: $resource('/api/v1/model/:id', {id: '@id'}),
			page: $resource('/api/v1/page/:id', {id: '@id'})
		};
	}])

	.config(['$locationProvider',
		function ($locationProvider) {
			$locationProvider.html5Mode({
				enabled: true,
				requireBase: true
			});
		}])

	.config(function ($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/model/list');
		$stateProvider
			.state('page', {
				url: '/page',
				template: "<div ui-view></div>"
			})
			.state('page.list', {
				url: '/list',
				templateUrl: '/assets/partials/pageList.html',
				controller: 'PageListController',
				controllerAs: 'pageList',
				resolve: {
					pages: ['RestApiService', function (RestApiService) {
						return RestApiService.page.query();
					}]
				}
			})
			.state('page.create', {
				url: '/createEdit/:id',
				templateUrl: '/assets/partials/pageCreate.html',
				controller: 'PageCreateController',
				controllerAs: 'pageCreate',
				resolve: {
					page: ['RestApiService', '$stateParams', function (RestApiService, $stateParams) {
						if ($stateParams.id) {
							return RestApiService.page.get({id: $stateParams.id});
						} else {
							return {template: {}};
						}
					}],
					templates: ['RestApiService', function (RestApiService) {
						return RestApiService.template.query({short: true});
					}]
				}
			})
			.state('template', {
				url: '/template',
				template: "<div ui-view></div>"
			})
			.state('template.list', {
				url: '/list',
				templateUrl: '/assets/partials/templateList.html',
				controller: 'TemplateListController',
				controllerAs: 'templateList',
				resolve: {
					templates: ['RestApiService', function (RestApiService) {
						return RestApiService.template.query();
					}]
				}
			})
			.state('template.create', {
				url: '/createEdit/:id',
				templateUrl: '/assets/partials/templateCreate.html',
				controller: 'TemplateCreateController',
				controllerAs: 'templateCreate',
				resolve: {
					template: ['RestApiService', '$stateParams', function (RestApiService, $stateParams) {
						if ($stateParams.id) {
							return RestApiService.template.get({id: $stateParams.id});
						} else {
							return {};
						}
					}],
					models: ['RestApiService', function (RestApiService) {
						return RestApiService.model.query({short: true});
					}]
				}
			})
			.state('model', {
				url: '/model',
				template: "<div ui-view></div>"
			})
			.state('model.list', {
				url: '/list',
				templateUrl: '/assets/partials/modelList.html',
				controller: 'ModelListController',
				controllerAs: 'modelList',
				resolve: {
					models: ['RestApiService', function (RestApiService) {
						return RestApiService.model.query();
					}]
				}
			})
			.state('model.create', {
				url: '/createEdit/:id',
				templateUrl: '/assets/partials/modelCreate.html',
				controller: "ModelCreateController",
				controllerAs: "modelCreate",
				resolve: {
					dataTypes: ['RestApiService', function (RestApiService) {
						return RestApiService.dataType.query();
					}],
					model: ['RestApiService', '$stateParams', function (RestApiService, $stateParams) {
						if ($stateParams.id) {
							return RestApiService.model.get({id: $stateParams.id});
						} else {
							return {};
						}
					}]
				}
			})
	})

	.controller('ModelListController', ['models', function (models) {
		var vm = this;
		vm.models = models;
	}])

	.controller('ModelCreateController',
		['RestApiService', 'dataTypes', 'model', function (RestApiService, dataTypes, model) {
			var vm = this;
			vm.dataTypes = dataTypes;
			vm.model = model;

			vm.removeAttribute = function (attribute) {
				var idx = vm.model.attributes.indexOf(attribute);
				if (idx >= 0) {
					vm.model.attributes.splice(idx, 1);
				}
			};

			vm.addAttribute = function (attribute) {
				vm.model.attributes = vm.model.attributes || [];
				vm.model.attributes.push({});
			};

			vm.save = function () {
				RestApiService.model.save(vm.model);
			}
		}])

	.controller('TemplateListController', ['templates', function (templates) {
		var vm = this;
		vm.templates = templates;
	}])

	.controller('TemplateCreateController', ['RestApiService', 'template', 'models',
		function (RestApiService, template, models) {
			var vm = this;
			vm.template = template;
			vm.models = models;
			vm.save = function () {
				RestApiService.template.save(vm.template);
			}
		}])

	.controller('PageListController', ['pages', function (pages) {
		var vm = this;
		vm.pages = pages;
	}])

	.controller('PageCreateController', ['RestApiService', 'page', 'templates',
		function (RestApiService, page, templates) {
			var vm = this;
			vm.page = page;
			vm.page.attributeValues = vm.page.attributeValues || [];
			vm.page.tempalate = vm.page.tempalate || {model: {}};
			vm.templates = templates;

			vm.fetchModel = function () {
				RestApiService.model.get({id: vm.page.template.model.id}, function (model) {
					vm.page.template.model = model;
					prepareAttributeValues();
				})
			};

			vm.save = function () {
				RestApiService.page.save(vm.page);
			};

			function prepareAttributeValues() {
				var newOrderedAttributeValues = [];
				angular.forEach(vm.page.template.model.attributes, function (attribute) {
					var attributeValue = _.find(vm.page.attributeValues, function (av) {
						return av.attribute.id === attribute.id;
					});
					newOrderedAttributeValues.push(attributeValue || {attribute: attribute});
				});
				vm.page.attributeValues = newOrderedAttributeValues;
			}

			if (vm.page && vm.page.template && vm.page.template.model) {
				prepareAttributeValues();
			}
		}])

	.component('navigationBar', {
		templateUrl: '/assets/partials/navbar.html',
		replace: true
	})

	.component('attributeEditor', {
		templateUrl: '/assets/partials/attributeEditor.html',
		controller: [function () {

		}],
		controllerAs: 'attributeEditor',
		bindings: {
			attribute: '=',
			dataTypes: '<'
		}
	})

	.component('attributeValueEditor', {
		templateUrl: '/assets/partials/attributeValueEditor.html',
		controller: [function () {
			var vm = this;
		}],
		controllerAs: 'attributeValueEditor',
		bindings: {
			attributeValue: '=',
			attribute: '<'
		}
	});

