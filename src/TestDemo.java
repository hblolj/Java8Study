import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestDemo {

    List<Employee> employees = Arrays.asList(
      new Employee(10, "张三"), new Employee(20, "李四"),
      new Employee(30, "王二"), new Employee(22, "码子"),
      new Employee(18, "搜狗")
    );

    @Test
    public void test1(){
        Collections.sort(employees, (x, y) -> {
            if (x.getAge() == y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        });
        employees.forEach(System.out::println);
    }

    //方法引用
    //对象::实例方法名
    @Test
    public void test2(){
        PrintStream ps = System.out;
        Consumer<String> consumer = (x) -> ps.println();
        Consumer<String> consumer1 = System.out::println;
        consumer.accept("Hello, Lambda");
    }

    //对象::实例方法名
    //Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法的参数列表和
    //返回类型保持一致
    @Test
    public void test3(){
        Employee employee = new Employee(11, "xx");
        Supplier<String> supplier = () -> employee.getName();
        Supplier<String> supplier1 = employee::getName;
        supplier.get();
    }

    //类::静态方法名
    //Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法的参数列表和
    //返回类型保持一致
    @Test
    public void test4(){
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compare;
    }

    //类::实例方法名
    //若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是示例方法的
    //的参数时，可以使用ClassName::method
    @Test
    public void test5(){
        BiPredicate<String, String> bi1 = (x, y) -> x.equals(y);
        BiPredicate<String, String> bi2 = String::equals;
        bi2.test("xxx","xxx");
    }

    //构造器引用 ClassName::new
    @Test
    public void test6(){
        Supplier<Employee> supplier = () -> new Employee();
        Supplier<Employee> supplier1 = Employee::new;
        supplier1.get();
    }

    @Test
    public void test7(){
        employees.stream().filter(e -> e.getAge() > 18).collect(Collectors.toList()).forEach(System.out::println);
    }


}
