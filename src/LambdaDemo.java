import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * Lambda表达式示例
 */
public class LambdaDemo {

    /**
     * 无参 无返回值
     */
    @Test
    public void test1(){
        Runnable runnable = () -> System.out.println("无参无返回值");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("无参无返回值");
            }
        });
        new Thread(() -> System.out.println("无参无返回值")).start();
    }

    /**
     * 一个参数 无返回值
     */
    @Test
    public void test2(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        //只有一个参数时，左侧参数的()可以省略
        Consumer<String> consumer = s -> System.out.println("一个参数，无返回值.");
    }

    /**
     * 多个参数 有返回值
     */
    @Test
    public void test3(){
        BinaryOperator<Long> bo1 = new BinaryOperator<Long>() {
            @Override
            public Long apply(Long aLong, Long aLong2) {
                return null;
            }
        };
        //当方法体中只有一行内容时，return关键字和大括号{}可以省略
        //左侧参数的数据类型可以省略，因为可由编译器推断得出
        BinaryOperator<Long> bo = (l1, l2) -> l1 + l2;
        System.out.println(bo.apply(1L, 1L));
    }
}
