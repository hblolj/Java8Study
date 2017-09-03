import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用、构造器引用、数组引用
 * 方法引用分为三种:
 * 对象::实例方法
 * 类::静态方法
 * 类::实例方法
 */
public class QuoteFunctionDemo {

    //对象::实例方法
    @Test
    public void test1(){
        //原本Lambda表达式
        Consumer<String> consumer = (s) -> System.out.println(s);
        //方法引用  引用的方法的参数列表要与抽象方法的参数匹配
        Consumer<String> consumer1 = System.out::println;
    }

    //类::静态方法
    @Test
    public void test2(){
        //Lambda表达式
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        //方法引用
        Comparator<Integer> comparator1 = Integer::compare;
    }

    //类::实例方法
    //若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时
    //可以使用ClassName::method
    @Test
    public void test3(){
        //Lambda表达式
        BiPredicate<String, String> bi = (x, y) -> x.equals(y);
        //方法引用
        BiPredicate<String, String> bi1 = String::equals;
        bi1.test("hblolj", "hblolj");
    }

    //构造器引用
    //ClassName::new
    @Test
    public void test4(){
        //Lambda表达式
        Supplier<Employee> supplier = () -> new Employee();
        //构造器引用
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee = supplier1.get();
    }

    //数组引用
    //type[]::new
    @Test
    public void test5(){
        //Lambda表达式
        Function<Integer, String[]> fun = (s) -> new String[s];
        //数组引用
        Function<Integer, String[]> fun1 = String[]::new;
        String[] apply = fun1.apply(1);
    }
}
