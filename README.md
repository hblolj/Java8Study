## 1.Lambda表达式   
**1.1 什么是Lambda表达式**  
lambda表达式是一个匿名函数，即没有函数名的函数。  
  
**1.2 Lambda表达式可以做什么**  
替代了Java中原先使用匿名内部类的地方。使代码更加简洁，将关注的重点放在真正需要关注的地方上，提高可读性，更加灵活。 

**1.3 怎么使用Lambda表达式**  
lambda表达式引用了新的操作符'->'，他将lambda表达式分为两个部分:  
左侧: 指定lambda表达式需要的所有参数  
右侧: 指定Lambda体，即Lambda表达式要执行的功能。  

## 2.函数式接口(Functional Interface) ##
**2.1 什么是函数式接口**  
只包含一个抽象方法的接口  

**2.2 函数式接口可以做什么**  
作为参数传递Lambda表达式，可以通过Lambda表达式来创建该接口  

**2.3 怎样使用使用函数式接口**  
定义一个只包含一个抽象方法的接口，可以在接口上使用@FunctionalInterface来检测、标示该接口是一个函数式接口  

**2.4 Java内置四大核心函数式接口**  
消费型接口  Comsumer<T>  
供给型接口  Supplier<T>  
函数型接口  Function<T, R>  
断定型接口  Predicate<T>  

## 3.方法引用、构造器引用、数组引用 ##
**3.1 方法引用是什么**  
当Lambda表达式要表达的操作已经有方法实现了，可以直接引用这个方法来替代Lambda表达式。

**3.2 方法引用可以做什么**  
引用一个方法，替代Lambda表达式
 
**3.3 怎么使用方法引用**  
对象::实例方法  
类::静态方法  
类::实例方法  

## 4.Stream  
**4.1 Stream是什么**  
Stream是用于操作数据源生成的元素序列，Java8给Collection接口增加了两个默认方法，他们可以返回一个Stream.  
Stream有下面几个特点：  
1. Stream自己不会存储元素。  
2. Stream不会改变源对象。相反，他会返回一个持有结果的新Stream。
3. Stream操作是延迟执行的。这意味着他们会等到需要结果的是否才执行。  
  
**4.2 Stream可以做什么**  
Stream针对常见的的集合数据处理，Stream API提供了一种高效且易于使用的数据处理方式。  
采用了链式操作，将重点放在了对数据的操作上，易于理解。

**4.3 Stream怎么用**  
1. 创建Stream  
从一个数据源(集合、数组),获取一个流  
2. 中间操作    
对数据源的数据进行处理  
3. 终止操作  
一个终止操作，执行中间操作链，并产生结果  

详细使用方法见Github上的代码  

## 5.Optional防止空指针   
**5.1 Optional是什么**  
Optional<T>类是一个容器类，代表一个值存在或不存在，原来用null表示一个值不存在，现在Optional可以更好的表达这个概念。并且可以避免空指针异常。
  
**5.2 Optional可以做什么**  
避免空指针异常  
  
**5.3  怎么使用Optional**  
Optional.of(T t) : 创建一个Optional实例  
Optional.empty() : 创建一个空的Optional实例  
Optional.ofNullable(T t) : 若 t 不为null,创建Optional实例，否则创建空实例。  
isPresent() : 判断是否包含值  
orElse(T t) : 如果调用对象包含值，返回该值，否则返回t  
orElseGet(Supplier s) : 如果调用对象包含值，则返回值，否则返回 s 获取的值  
map(Function f) : 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()  
flatMap(Function mapper) : 与 map 类似，要求返回值必须是Optional


