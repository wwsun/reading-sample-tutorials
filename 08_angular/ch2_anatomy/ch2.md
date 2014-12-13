Section 2: Anatomy of an Angular Application
=========================
###Declaring Angular's Boundaries with `ng-app`

The `ng-app` directive let's you tell Angular which part of your page it should expect to manage.

	<div ng-app>

	</div>

###Model-View-Controller
                                                                                     
- A model containing data that represents the current state of your application.

		var someText= "Hello world";

- Views that display this data.

		<p>{{someText}}</p>

- Controllers that manage the relationship between your model and your views. The controllers are classes or types you write to tell Angular which objects or primitives make up your model by assigning them to the `$scope` object passed into your controller:

		function TextController($scope) {
			$scope.someText = someText;
		}

The right way to define a controller is as part of something called a module, which provides a namespace for related parts of your application.

	<html ng-app='myApp' >
	<body ng-controller='TextController' >
		<p>{{someText.message}}</p>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" >
		</script>
		<script>
			 var myAppModule = angular. module('myApp' , []);
			 myAppModule. controller('TextController' ,
			 function($scope) {
				 var someText = {};
				 someText. message = 'You have started your journey.' ;
				 $scope. someText = someText;
			 });
		</script>
	</body>
	</html>

###Templates and Data Binding
Templates in Angular applications are just HTML documents that we load from the server or define in a `<script>` tag like any other static resource.

Once in the web browser, Angular expands these templates into your full application by merging your template with data.

The basic startup flow looks like this:

1. A user requests the first page of your application.
2. User browser load `demo.html` page containing your template.
3. Angular loads into the page, waits for the page to be fully loaded, and then looks for `ng-app` to define its template boundaries.
4. Angular traverses the template and looks for directives and bindings. At the end, the app is bootstrapped and the template is converted into view as a DOM.
5. You connect to your server to load additional data you need to show the user as needed.

###Displaying Text
You can display and update text anywhere in your UI using the `ng-bind` directive. It has two equivalent forms:

	<p>{{greeting}}</p>

or

	<p ng-bind="greeting"></p>

You can use `{{}}` in the marjority of your templates. For the data binding you do in your `index.html` page, use `ng-bind` instead. The reason is that the browser loads the HTML page, renders it, and only then does Angular get a chance to interpret it as you intended.

###Separating UI Responsibilities with Controllers
Controllers have three responsibilities in your app:

1. set up the initial state in your application's model
2. expose model and functions to the view (UI template) through `$scope`
3. Watch other parts of the model for changes and take action

Keeping your controllers small and manageable.

###Publishing Model Data with Scopes

The `$scope` object passed to our controllers is the mechanism we use to expose model data to views.

###Observing Model Changes with `$watch`

Possibly the most used of all scope functions is `$watch`, which notifies you when parts of your model change.

	$watch(watchFn, watchAction, deepWatch)

###Organizing Dependencies with Modules 

With modules, and the dependency injection we get from them, we can write our controller much more simply.

	//Create a module to support our shopping views
	var shoppingModule = angular.module('ShoppingModule', []);

In most applications, it will work well enough to create a single module for all the code you create and put all of your dependencies in it.

###Formatting Data with Filters

Filters allow you to declare how to transform data for display to the user within an interpolation in your template.

	{{ 12.9 | currency }}

This bit of code will display the following:
	
	$12.90

Others filters that come with Angular include `date`, `number`, `uppercase`, and more.

###Changing Views with Routes and `$locate`

You create routes in your application by calling functions on the `$routeProvider` service as a configuration block.

	var someModule = angular. module('someModule' , [... module dependencies...])
		someModule. config(function($routeProvider) {
			 $routeProvider.
				 when('url' , {controller: aController, templateUrl: '/path/to/tempate' }).
				 when(... other mappings for your app...).
				 …
				 otherwise(... what to do if nothing else matches...);
	)};

The preceding code says that when the browser's URL changes to the specified URL, Angular will load the template in `/path/to/tempate`, and associate the root element of this template with `aCOntroller` (as if we'd typed `ng-controller=aController`).

The `otherwise()` call in the last line tells the route where to go if nothing else matches.

###Talking to Servers

Angular provides a service called `$http`. It has an extensive list of abstractions that make it easier to talk to servers.

	function ShoppingController($scope, $http) {
		 $http. get('/products' ). success(function(data, status, headers, config) {
		 	$scope. items = data;
		 });
	}

###Changing the DOM with Directives
Directives extend HTML syntax, and are the way to assocaite behavior and DOM transformations with custom elements and attributes.

	var appModule = angular.module('appModule', [...]);
	appModule. directive('directiveName' , directiveFunction);

###Validating User Input
Angular lets you declare valid states for inputs within the form and allow submission only when the entire set of elements is valid.

	<input ng-model="user.first" required> </div>

Notice that we're using the `required` attribute and input types for email and number from HTML5 to do our validation on some of the fields. This works great with Angular, and in older non-HTML5 browsers, Angular will polyfill these with directives that perform the same jobs.

We can use `$valid` property to disable the Submit button when the form isn't completed yet.

	<form name='addUserForm' ng-controller="AddUserController">
		//todo
		
		<button ng-disabled='!addUserForm.$valid'>Submit</button>
	</form>