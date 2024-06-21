# [addViewControllers]

The difference between `addViewControllers()` configuration view controller and ordinary controller class:
**Using `addViewControllers()`:**

advantage:
- Simple and direct, no need to write controller classes and methods
- Suitable for static resource mapping and simple redirection scenarios
- Mapping priority is higher than normal controller methods
- Centralized management of view mapping for easy maintenance

disadvantages:
- Unable to process complex business logic
- Limited to simple view rendering or redirection

example:
```java
public void addViewControllers(ViewControllerRegistry registry)
    {
    registry.addViewController("/welcome").setViewName("welcome");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/").setViewName("login");
    }
```

**normal controller classes and methods:**

advantage:
- Can perform complex business logic processing
- Support various HTTP methods (GET, POST, PUT, DELETE, etc.)
- You can use model objects to pass data to the view
- More flexible and powerful

disadvantages:
- Need to write more code (controller classes and methods)
- Relatively more complex to maintain
- Mapping priority is lower than view controller

example:
```java
@GetMapping("/welcome")
public String welcome(Model model) 
    {
    model.addAttribute("message", "Welcome to our application!");
    return "welcome";
    }
```

# [extand and implement]
Usually in actual projects, the two methods are used in combination, 
which not only takes advantage of the simplicity of the view controller, 
but also implements complex business logic processing through ordinary controllers

In Java, both `extend` and `implement` are used to implement inheritance, but there are some differences:

1. `extend` is used for inheritance relationships between classes:
    - A class can only `extend` (inherit) one parent class
    - Subclasses will inherit the non-private fields and methods of the parent class
    - Subclasses can override the methods of the parent class, or add their own new methods and fields

2. `implement` is used for the implementation relationship between classes and interfaces:
    - A class can `implement` one or more interfaces
    - The class needs to provide specific implementations of all methods in the interface
    - The interface only defines method signatures and cannot contain method implementations

So, in this code:

```java
public interface RoleService extends CrudService<Type, Reference>{ }
```

The `extends` keyword is used because:

- `RoleService` is an interface
- It inherits (extends) another generic interface `CrudService<Type, Reference>`
- The relationship between interfaces is an extend relationship rather than an implement relationship.

If you change it to a class, you need to use the `implements` keyword to implement the interface, for example:

```java
public class RoleServiceImpl implements RoleService<Role, Long>, AnotherInterface { }
```

In general, `extend` is used for inheritance between classes, and `implement` is used for 
the implementation relationship between classes and interfaces. Use `extend` to extend between interfaces.




# [child interface extend parent interface]
Using the `extend` keyword to extend interfaces has the following main functions and advantages:

1. **Function inheritance and reuse**
    - Sub-interfaces can inherit all method signatures defined in the parent interface without repeated definitions
    - Can effectively reuse the functions of existing interfaces to avoid code duplication

2. **Function Extension**
    - In addition to inheriting the methods of the parent interface, a sub-interface can also define new methods to extend its functionality.
    - Conducive to the functional evolution and version upgrade of the interface

3. **Interface separation**
    - Through expansion, a huge interface can be separated into multiple small interfaces
    - Comply with the "loosely coupled principles" and reduce the coupling between different implementation classes

4. **Hierarchy**
    - Interface extension can form a clear hierarchy and inheritance relationship
    - Conducive to the organization and management of code, improving the readability and maintainability of code

5. **Code Refactoring**
    - The interface design can be reconstructed and optimized by extending the interface without destroying the existing implementation class.
    - Improve code scalability and flexibility

Through interface extension, we can reuse and share the function definitions of existing interfaces to the maximum extent, and at the same time, 
we can extend and evolve the interface as needed. This modular and layered design idea helps to build a robust, flexible and maintainable object-oriented system.

-If the implementation class needs to use the unique functions of the sub-interface, then it should implement the sub-interface.

-If the implementing class only needs to use the basic functions of the parent interface, then implementing the parent interface is enough.

-If the implementation class needs to use both the basic functions of the parent interface and the extended functions of the sub-interface, then it can choose to implement both the parent interface and the sub-interface.