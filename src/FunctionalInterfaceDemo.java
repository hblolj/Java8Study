import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式表达式示例
 */
public class FunctionalInterfaceDemo {

    @Test
    public void test1(){
        System.out.println(toUpperString(t -> t.toUpperCase(), "hblolj"));
    }

    //作为参数传递Lambda表达式  注意类型要匹配
    public String toUpperString(MyFunc<String> mf, String str){
        return  mf.getValue(str);
    }

    /**
     * 消费型接口
     * 参数类型T 返回类型Void
     */
    @Test
    public void testConsumer(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hblolj");
    }

    /**
     * 供给型接口
     * 参数类型Void 返回类型T
     */
    @Test
    public void testSupplier(){
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "hblolj";
            }
        };
        Supplier<String> supplier = () -> "hblolj";
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口
     * 参数类型T 返回类型R
     */
    @Test
    public void testFunction(){
        Function<String ,String> function1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        Function<String ,String> function = s -> s.toUpperCase();
        System.out.println(function.apply("hblolj"));
    }

    /**
     * 断定型接口
     * 参数类型T 返回类型Boolean
     */
    @Test
    public void testPredicate(){
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "hblolj".equals(s);
            }
        };
        Predicate<String> predicate2 = s -> "hblolj".equals(s);
        System.out.println(predicate2.test("hblolj"));
    }
}
