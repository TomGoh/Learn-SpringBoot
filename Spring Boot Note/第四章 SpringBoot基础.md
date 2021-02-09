# SpringBoot基础

[toc]

## 1.  了解Spring Boot

### Spring Boot的项目结构

Spring Boot的项目多有三个结构组成：

- `src/main/java` 入口类以及程序的开发目录，在该目录下进行业务开发，创建实体层、控制器曾以及数据连接层等。
- `src/maim/resource` 资源文件目录，主要存放静态文件和配置文件
  - `static`  用于存放包括CSS、JS以及图片等静态文件
  - `templates` 用于存放模板文件
  - `application.peoperties` 用于存放项目运行时的配置数据。
- `src/test/java` 测试程序所在的目录

如图所示：

![image-20210209194356723](https://gitee.com/TomGoh/img/raw/master/img/20210209194359.png)

### SpringBoot的入口类

在Spring Boot项目中会创建一个用于启动、名为“项目名+Application”的入口类。

在入口类中默认加入`@SpringBootApplication`的注解。

在IDEA自动生成的Spring Boot入口类中，默认的类对象以及`main`函数如下：

```Java
@SpringBootApplication
public class Chapter4Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }

}
```

其中使用了`SpringApplication.run()`的静态方法，将该项目对应的入口类和参数`args` 传入其中以启动该入口类。

## 2. Spring Boot 常用注解

**注解(Annotation)**用来定义一个类、属性或方法，以便程序能够被编译处理，相当于一个说明文件。

### 系统级注解

|        注解        |                 说明                 |
| :----------------: | :----------------------------------: |
|    `@Override`     | 用于修饰方法，表示该方法重写父类方法 |
|   `@Deprecated`    |      用于修饰方法表明方法已过时      |
| `@SupressWarnings` |     告知编译器忽略某些编译器警告     |

其中，`@SupressWarnings`的属性与用法如下：

|    属性值     |                  忽略的警告类别                  |
| :-----------: | :----------------------------------------------: |
|   `unused`    |                   未使用的变量                   |
|  `unchecked`  |                   未检查的转化                   |
|  `resource`   |               泛型，即未指定的类型               |
|    `path`     |      在类中的路径（源文件中有不存在的路径）      |
| `deprecation` |       使用了某些废弃或不赞成使用的类或方法       |
| `fallthrough` |          `switch`语句执行到底无`break`           |
|   `serial`    | 实现了`Serializable`，但未定义`serialVersionUID` |
|  `rawtypes`   |              没有传递带有泛型的参数              |
|     `all`     |                     所有警告                     |

使用示例：

```Java
@SuppressWarnings({"unused"})
public String getHello(){
	String result="";
	return "Hello!";
}
```

### Spring Boot使用在类名上的注解

|     注解名称      |           使用位置           |                             说明                             |
| :---------------: | :--------------------------: | :----------------------------------------------------------: |
| `@RestController` |            类名上            |           作用相当于`@ResponseBody`与`@Controller`           |
|   `@Controller`   |            类名上            |           声明此类为一个Spring MVC Controller对象            |
|    `@Service`     |            类名上            |            声明一个业务处理类（实现类而非接口类）            |
|   `@Repositiry`   |            类名上            |           声明一个数据库访问类（实现类而非接口类）           |
|   `@Component`    |            类名上            | 代表其是交与Spring管理恶的类，使用在`@Service`与`@Repository`之外的对象 |
| `@Configuration`  |            类名上            |             声明一个配置类，常与`@Bean`配合使用              |
|    `@Resource`    | 类名上，属性或构造函数方法上 |                   默认按`byName` 自动注入                    |
|   `@Autowired`    | 类名上，属性或构造函数方法上 |                    默认按`byType`自动注入                    |
| `@RequestMapping` |         类名或方法上         |   用在类上时表示所有的响应请求的方法都是以该地址作为父路径   |
| `@Transactional`  |         类名或方法上         |                         用于事务处理                         |
|   `@Qualifier`    |         类名或属性上         | 为Bean指定名称而后使用名称引用Bean对象，常与`Autowired`一同使用 |



### Spring Boot使用在方法上的注解

|    注解名称     |  使用位置  |                             说明                             |
| :-------------: | :--------: | :----------------------------------------------------------: |
| `@RequestBody`  | 方法参数前 |               用来处理`Content-Type`类型的数据               |
| `@PathVariable` | 方法参数前 |               将URL获取的参数映射到方法参数上                |
|     `@Bean`     |   方法上   |       声明该方法的返回结果是一个由Spring容器管理的Bean       |
| `@ResponseBody` |   方法上   | 将控制器中方法返回的对象转化为指定格式后写入Response对象的body数据区 |

