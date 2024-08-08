# Rules

In this package we have the rules that are used to validate the product domain object.
Even if your rule is in the domain object, it is a good practice to have a rule that validates it.
The rule will just call the object.validate() method but it may concentrate the validation layer in this package.

If you presume that the rules are simple, you can combine them in a single class (this is the problem of clean architecture, we generate a lot of classes). 
If you think that the rules are complex, you have to create a class for each rule and respect the SRP principle.

A rule also can call another rule.
A rule can call output ports.