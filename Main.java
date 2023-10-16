public class Main {
    public static void main(String[] args) {
        compareArraysShowcase();
        calculatorShowcase();
        pairShowcase();
        myCollectionShowcase();
    }

    public static void myCollectionShowcase() {
        System.out.println("---------------Collection with iterator---------------");
        MyCollection<Integer> test = new MyCollection<>(2);
        System.out.println("New collection:" + test);
        for (int i = 0; i < 10; i++) {
            test.add(i);
            System.out.printf("After adding %d:%n", i);
            System.out.println(test);
        }
        for (int i = 0; i < 12; i += 2) {
            test.remove(i);
            System.out.printf("After removing %d:%n", i);
            System.out.println(test);
        }
        int sum = 0;
        for (int i = 0; i < test.length(); i++) {
            sum += test.get(i);
        }
        System.out.println("Sum of remaining elements with regular for: " + sum);
        sum = 0;
        for (Integer item : test) {
            sum += item;
        }
        System.out.println("Sum of remaining elements with for each: " + sum);
        System.out.println("Remaining elements printed out with for each:");
        for (Integer item : test) {
            System.out.print(item + " ");
        }
        System.out.println("\n---------------------------------------------");
    }

    public static <T> String arrayToString(T[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        String className = array.getClass().getName();
        sb.append(className.substring(className.lastIndexOf(".") + 1).replace(";", ""));
        sb.append('{');
        for (int i = 0 ; i < array.length - 1; i++) {
            sb.append(array[i]);
            sb.append(", ");
        }
        if (array.length > 0) {
            sb.append(array[array.length - 1]);
        }
        sb.append('}');
        return sb.toString();
    }

    public static <T> String compareArraysString(T[] arr1, T[] arr2) {
        return String.format("%s and %s - %s", arrayToString(arr1), arrayToString(arr2), compareArrays(arr1, arr2));
    }

    public static void compareArraysShowcase() {
        System.out.println("---------------Comparing Arrays---------------");
        Integer[] a = null;
        Integer[] b = null;
        System.out.println(compareArraysString(a, b));
        Integer[] testArr1 = {1, 2, 3};
        System.out.println(compareArraysString(testArr1, testArr1));
        System.out.println(compareArraysString(testArr1, a));
        Integer[] testArr2 = {1, 2, 3};
        Integer[] testArr3 = {1, 2, 3, 4};
        Integer[] testArr4 = {0, 1, 2};
        String[] testArr5 = {"1", "2", "3"};
        System.out.println(compareArraysString(testArr1, testArr2));
        System.out.println(compareArraysString(testArr1, testArr3));
        System.out.println(compareArraysString(testArr1, testArr4));
        System.out.println(compareArraysString(testArr1, testArr5));
        System.out.println("---------------------------------------------");
    }

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.getClass() != arr2.getClass()) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void calculatorShowcase() {
        System.out.println("---------------Calculator---------------");
        Integer a = 2;
        Double b = 4.5;
        Float c = 1.2f;
        System.out.printf("%d + %.2f = %.2f%n", a, b, Calculator.add(a, b));
        System.out.printf("%.2f - %.2f = %.2f%n", b, c, Calculator.subtract(b, c));
        System.out.printf("%.2f * %.2f = %.2f%n", c, b, Calculator.multiply(c, b));
        System.out.printf("%.2f / %d = %.2f%n", b, a, Calculator.divide(b, a));
        System.out.println("---------------------------------------------");
    }

    public static void pairShowcase() {
        System.out.println("---------------Pairs---------------");
        String someString = "Some String";
        Integer someInteger = 123;
        Pair<Integer, String> pairIntStr = new Pair<>(someInteger, someString);
        Pair<Integer, Integer> pairIntInt = new Pair<>(someInteger, someInteger);
        Pair<String, String> pairStrStr = new Pair<>(someString, someString);
        System.out.printf("%s (getFirst: %d, getSecond: %s)%n", pairIntStr, pairIntStr.getFirst(), pairIntStr.getSecond());
        System.out.printf("%s (getFirst: %d, getSecond: %d)%n", pairIntInt, pairIntInt.getFirst(), pairIntInt.getSecond());
        System.out.printf("%s (getFirst: %s, getSecond: %s)%n", pairStrStr, pairStrStr.getFirst(), pairStrStr.getSecond());
        System.out.println("---------------------------------------------");
    }
}
