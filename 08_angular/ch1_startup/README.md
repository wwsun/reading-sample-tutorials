Section 1: Angular Startup
=========================
###Introduction

Angular is a client-side JavaScript Framework for adding interactivity to HTML. In Angular, the template and data get shipped to the browser to be assembled there.

1. Angular helps you organize your JavaScript
2. Angular helps create responsive websites
3. Angular plays well with jQuery
4. Angular is easy to test

###MVC

In Angular applications, the view is the DOM, the controllers are JavaScript classes, and the model data is stored in object properties.

###Data Binding

- A binding, denoted by ``{{}}``
- Expressions are in the binding.
	
		<div ng-controller="HelloController">
	    	<input ng-model="greeting.text"><!--data binding-->
	    	<p>{{greeting.text}}, word</p>
		</div>

###Dependency Injection

1. $scope, $location, etc.
2. Law of Demeter

###Directives

- ng-controller - specifying which controller oversees which part of the view
- ng-model - binds an input to part of the model	

###Modules

1. Where to write pieces of our Angular application.
2. Makes our code more maintainable, testable, and readable.
3. Where to define dependencies for our app.

	
		var app = angular.module('stere',{});
				//arg1: application name
				//arg2: dependencies