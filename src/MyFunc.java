/**
 * 函数式接口中使用泛型
 */
@FunctionalInterface
public interface MyFunc<T> {
    T getValue(T t);
}
