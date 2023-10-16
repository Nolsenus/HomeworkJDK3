public class Calculator {
    public static <T extends Number> double add(T first, T second) {
        return first.doubleValue() + second.doubleValue();
    }

    public static <T extends Number> double subtract(T from, T amount) {
        return from.doubleValue() - amount.doubleValue();
    }

    public static <T extends Number> double multiply(T first, T second) {
        return first.doubleValue() * second.doubleValue();
    }

    public static <T extends Number> double divide(T dividend, T divisor) {
        return dividend.doubleValue() / divisor.doubleValue();
    }
}
