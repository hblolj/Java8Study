import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Create With 昀尚智能.
 * Data : 2017/9/17
 * Time : 12:01
 */
public class OptionalDemo {

    @Test
    public void test1(){
        Employee e = new Employee(10, "秦舞阳");
        Optional<Employee> optional1 = Optional.of(e);
        Optional<Object> optional2 = Optional.empty();
        Optional<Employee> optional3 = Optional.ofNullable(e);

        optional1.isPresent();
        optional2.orElse(e);
        optional2.orElseGet(() -> new Employee(20, "赵无极"));

        optional3.map(Employee::getName);
        optional3.flatMap(e1 -> Optional.of(e1.getName()));
    }
}
