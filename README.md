# Animal Website CRUD API
## CRUD MVC App using JPA/Hibernate, Postgres, and FreeMarker.

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/AJ000-sys/animal-website-crud-api.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/uncg-csc340/su25-jpa-crud-api/blob/3149ec363e4aae4baebe6f755df7d4c2d79c9d2c/pom.xml#L32) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/uncg-csc340/su25-jpa-crud-api/blob/main/src/main/resources/application.properties) This file  is the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.

## Notes:
### Java - [Spring ORM with JPA and Hibernate](https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac)
- We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.
- JPA (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks to make concrete implementations.
- Hibernate: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.
Spring ORM allows seamless integration of Hibernate and JPA, making database interactions more manageable and reducing boilerplate code.
### CatX Java classes have different purposes: Separation of concerns!
- [Entity](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/Cat.java)
  - The Cat class is annotated as an `@Entity `. This is used to map class attributes to database tables and SQL types.
  - We also annotated with `@Table` to give Hibernate directions to use this specific table name. This is optional but it helps with naming conventions.
  - Any Entity must have at least one attribute that is annotated as an `@Id`. In our case it's conveniently the `catId` attribute.
    - We are also using an autogeneration strategy for the ID. This way we are not manually assigning IDs to our cats. This is optional.
       - For this reason, we also added a constructor to make a Cat without an ID.
  - An Entity must have a no-argument constructor.
- [Repository](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatController.java)
  - We are using an extension of the JPA Repository that comes with prebuilt database operations such as select all, select by id, select by any other reference, insert, delete, etc.
  - Annotate it as a `@Repository`.
  - We parametrize this using our object and its ID type.
    - `public interface CatRepository extends JpaRepository<Cat, Long>` => We want to apply the JPA repository operations on the `Cat` type. The `Cat` has an ID of type `long`.
- [Service](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatService.java)
  - Annotated as a `@Service`.
  - It is the go-between from controller to database. In here we define what functions we need from the repository. A lot of the functions are default functions that our repository inherits from JPA (save, delete, findAll, findByX), some of them are custom made (getHonorsStudents, getStudentsByName).
  - It asks the repository to perform SQL queries.
  - The Repository class is [`@Autowired`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatRepository.java). This is for injecting the dependency to the repository. Do not use a constructor to make a Repository object, you will get errors.
- [Controller](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatController.java#L13)
  - Note this is a `@Controller` and not a `@RestController`. This is the MVC Controller that returns views instead of objects.
  - All the methods view names. The template engine will find the template with this name and render a view.
  - Return `"redirect:/link/to/redirect"` - if there is not necessarily a view attached to an action. e.g. going back to list after deleting one item.
  - Model attribute names and objects using `model.addAttribute("catsList", service.getAllCats());` 
  - The Service class is [`@Autowired`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatController.java#L17). Do not use a constructor.
- Views
  - All views live in [`src/main/resources/templates`](https://github.com/AJ000-sys/animal-website-crud-api/tree/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/resources/templates).
     - These are `.ftlh` files. They are FreeMarker templates. They work exactly like html to build pages, but they are used by the server to append data from the database.
     - You should configure you Visual Studio Code to associate `.ftlh` files with `html`.
       - Settings (Control +comma) -> Search "association" Add Item -> Key: *.ftlh, value: html ->OK.
     - You can also create subfolders in the templates folder. For example if you wanted views for the cat to be in one folder you can create a `cats` subfolder and put all the cat views in there. Then your Controller would have to `return "cats/cats-list";` 
  - [`cat-list.ftlh`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/resources/templates/cat-list.ftlh)
    - [`<#list catsList as cat>`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/resources/templates/cat-list.ftlh#L25) => "Loop through Cat list and make a table row for each Cat"
    - [`<td>${cat.name}</td>`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/resources/templates/cat-list.ftlh#L28) => "The text content for this this table data element should be whatever the cat name is".
  - For any form that sends POST requests with a form body, the input attribute "name" should match the data field.
  - Remember that any view must have a correspoding mapping. Any web page that is displayed MUST have a mapping in a controller to show the view.
    - If you wanted to have a page that is a standalone form, you must make a mapping in the controller that returns the form page as a view.
    - Our server is running on Port 8081, if you open the web page directly in the browser, it is not served on localhost, it is just a file and will not have data from the database. If you open it from VSCode, it is hosted on Port 3000, which also will not connect to our database and server.
    - In this example, the form for creating a new cat is its own page, therefore we must have a mapping to show that page.
      - We have a [`@GetMapping`](https://github.com/AJ000-sys/animal-website-crud-api/blob/7ef4d3c3494d001aa312b3529170d8369dffc90d/src/main/java/com/example/Animal/Website/CRUD/API/CatController.java#L34) that shows us the form in our controller.
      - Clicking on the Create New Cat button will hit this endpoint and return the form as a view.
    - **PLEASE NOTE: Web Browsers only allow GET and POST requests (unless you use additional JavaScript)! So we replace PUT mappings with POST mappings, and the DELETE with a GET!**
- On the browser go to: `http://localhost:8081/cats`