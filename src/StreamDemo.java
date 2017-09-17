import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create With 昀尚智能.
 * Data : 2017/9/17
 * Time : 12:01
 * Java8的 Stream使用Demo
 */
public class StreamDemo {

    private List<Employee> employees = Arrays.asList(new Employee(10, "张三"),
            new Employee(15, "李四"),
            new Employee(20, "网二"),
            new Employee(25, "码子"),
            new Employee(30, "Zard"),
            new Employee(30, "刘昂星"),
            new Employee(18, "阿福"));

    private Employee[] employees2 = new Employee[]{new Employee(10, "张三"),
            new Employee(15, "李四"),
            new Employee(20, "网二"),
            new Employee(25, "码子"),
            new Employee(30, "Zard"),
            new Employee(30, "刘昂星"),
            new Employee(18, "阿福")};

    /**
     * 创建Stream流
     */
    @Test
    public void CreateStream(){
        //集合创建流
        Stream<Employee> stream = employees.stream();//返回一个顺序流
        Stream<Employee> employeeStream = employees.parallelStream();//返回一个并行流
        //数组创建流
        Stream<Employee> stream1 = Arrays.stream(employees2);
        //值创建流
        Stream<Employee> stream2 = Stream.of(new Employee(18, "山鸡"));
        Stream<Employee> stream3 = Stream.of(new Employee(18, "山鸡"), new Employee(21, "浩南"));
        //由函数创建流
//        Stream.iterate();//迭代
//        Stream.generate();//生成
    }

    /**
     * 中间操作之筛选和切片
     */
    @Test
    public void test1(){
        employees.stream().filter(e -> e.getAge() > 20);
        employees.stream().distinct();//通过生成元素的hashCode和equals去除重复元素
        employees.stream().limit(5);//截断流，使其元素不超过给定数量
        employees.stream().skip(3);//跳过元素，返回一个扔掉了前n个元素的流。
    }

    /**
     * 中间操作之映射
     */
    @Test
    public void test2(){
        employees.stream().map(e -> e.getName());//将集合中的每一个元素映射成一个新元素
        employees.stream().flatMap(e -> Stream.of(e.getName()));//将集合中的每一个元素映射成一个新的流，然后把所有的流串成一个流
    }

    /**
     * 中间操作之排序
     */
    @Test
    public void test3(){
        employees.stream().sorted();//产生一个新流，按自然排序
        employees.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge());//产生一个新流，按比较器排序
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge));//产生一个新流，按比较器排序
    }

    /**
     * 终止操作之查找与匹配
     */
    @Test
    public void test4(){
        employees.stream().allMatch(e -> e.getAge() > 20);//检查是否匹配所有元素
        employees.stream().anyMatch(e -> e.getAge() > 20);//检查是否至少匹配一个元素
        employees.stream().noneMatch(e -> e.getAge() > 20);//检查是否没有匹配所有元素(全部不匹配 ture)
        employees.stream().findFirst();//返回第一个元素
        employees.stream().findAny();//返回任意元素
        employees.stream().count();//返回元素总数
        employees.stream().max(Comparator.comparing(Employee::getName));//返回最大元素
        employees.stream().min(Comparator.comparing(Employee::getName));//返回最小元素
        employees.stream().forEach(System.out::println);//内部迭代
    }

    /**
     * 终止操作之归约
     */
    @Test
    public void test5(){
        employees.stream().map(Employee::getAge).reduce(0, (e1, e2) -> e1 + e2);//归约，可以将流中元素按照指定的二元运算反复结合起来，得到一个值
        employees.stream().map(Employee::getAge).reduce(Integer::sum);//计算所有人的年龄和
    }

    /**
     * 终止操作之收集
     */
    @Test
    public void test6(){
        List<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());//将所有人的姓名收集到集合
    }
}
