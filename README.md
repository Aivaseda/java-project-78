### Hexlet tests and linter status:
[![Actions Status](https://github.com/Aivaseda/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Aivaseda/java-project-78/actions)
[![Actions Status](https://github.com/Aivaseda/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Aivaseda/java-project-78/actions)
### CodeClimate:
[![Maintainability](https://api.codeclimate.com/v1/badges/791a8275484c36506de5/maintainability)](https://codeclimate.com/github/Aivaseda/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/791a8275484c36506de5/test_coverage)](https://codeclimate.com/github/Aivaseda/java-project-78/test_coverage)

# Java project "Validator"
#### A data validator is a library that can check data for correctness
#### Data types that support: string, number, Associative array

## Available parameters for strings
#### required() – requires the data to be any non–empty string
#### minLength() – requires the data to be a string and have a length equal to or greater than the specified value
#### contains() - requires the data to contain the specified substring
## Preview "String validation"
```java
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator validator = new Validator();
        StringSchema stringSchema = validator.string();
        stringSchema.isValid(null); // true
        stringSchema.isValid(""); //true
        stringSchema.required();
        stringSchema.isValid(null); // false
        stringSchema.isValid("");
        stringSchema.isValid(9851);
        stringSchema.isValid("foobar"); //true
```
## Available parameters for numbers
#### required() – requires the data to be any integer, including zero
#### positive() – requires the data to be a positive number
#### range() – requires the data to be in the specified range, including boundary values

## Preview "Number validation"
```java
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

var v = new Validator();
var schema = v.number();
schema.isValid(5); // true
// Until the required() method is called, null is considered valid
schema.isValid(null); // true
schema.positive().isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(10); // true
// Because earlier we called the positive() method
schema.isValid(-10); // false
//  Zero is not a positive number
schema.isValid(0); // false
schema.range(5, 10);
schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
## Available parameters for Associative array
#### required() – requires the data to be an object of the Map
#### sizeof type() – requires that the number of key-value pairs in the Map object must be equal to the specified
#### shape() - allows you to describe validation for the values of the Map object by keys.

```java
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

var v = new Validator();

var schema = v.map();
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));
schema.shape(schemas);

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true
        
Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false
```