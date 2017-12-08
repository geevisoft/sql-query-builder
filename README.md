# SQL Query Builder

Just another SQL query builder focused on Java legacy projects. 
You will not have to modify any of your existing code to start using this when adding new functionality in your project.

## Getting Started

Load [SqlQueryBuilder.jar](SqlQueryBuilder.jar) as a library in your project

### Prerequisites

It's built on Java 6, so it will fit in most of your projects.

### Samples

###### Select query
```java
String builder = new SqlQueryBuilder();
String query = builder
    .select()
    .from("Users")
    .innerJoin("Clients", "ClientID", "ID")
    .whereEqual("LastName", "Doe")
    .orderBy("FirstName")
    .query();
```

###### Update query
```java
String builder = new SqlQueryBuilder();
String query = builder
    .update("Users")
    .set("FirstName", "John")
    .set("Age", 21)
    .whereEqual("ID", 1)
    .query();
```

###### Insert query
```java
String builder = new SqlQueryBuilder();
String query = builder
    .insertInto("Users")
    .value("FirstName", "John")
    .value("LastName", "Doe")
    .value("Age", 21)
    .query();
```

###### Delete query
```java
String builder = new SqlQueryBuilder();
String query = builder
    .delete("Users")
    .whereEquals("ID", 1)
    .query();
```

###### More examples
You have more examples in the [test project](SqlQueryBuilderTest).


## Contributing

No rules yet.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Avoid to write raw queries in old projects where no framework was used.
* Don't have to edit any other file except the one where you "want" to add functionality.

