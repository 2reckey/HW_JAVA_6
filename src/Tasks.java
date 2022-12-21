import java.util.Arrays;

public class Tasks {
    //Дано натуральное число n. Выведите все числа от 1 до n.
    public static void task_1(int n, int i) {
        if (i <= n) {
            System.out.println(i);
            task_1(n, i + 1);
        }
    }

    //Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
    // Используйте перебор и двоичный поиск для решения этой задачи.
    // Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
    public static void task_2(int n, int el) {
        int[] elements = generateArray(n);
        long time = System.nanoTime();
        System.out.println("Перебор: " + HaveNormEl(elements, el) + "   " + (System.nanoTime() - time));
        time = System.nanoTime();
        System.out.println("Бинарный поиск: " + HaveBinEl(elements, el, 0, elements.length - 1)
                + "   " + (System.nanoTime() - time));
    }

    public static boolean HaveNormEl(int[] elements, int el) {
        for (int element : elements) {
            if (element == el) return true;
        }
        return false;
    }

    public static boolean HaveBinEl(int[] elements, int el, int left, int right) {
        int mid = left + (right - left) / 2;
        int mid_el = elements[mid];
        if (mid_el == el) return true;
        else if (left == right) return false;
        else if (mid_el < el) return HaveBinEl(elements, el, mid + 1, right);
        else return HaveBinEl(elements, el, left, mid - 1);
    }

    public static int[] generateArray(int n) {
        int[] elements = new int[n];
        for (int i = 0; i < n; ++i) {
            elements[i] = (int) (Math.random() * n / 2);
        }
        Arrays.sort(elements);
        return elements;
    }

    //Найдите корень уравнения cos(x^5)+ x^4-345.3*x-23=0 на отрезке [0;10] с точностью по x не хуже 0.001.
    // Известно, что на этом промежутке корень единственный.
    // Используйте для этого метод деления отрезка пополам (и рекурсию).
    public static double task_3(double left, double right) {
        double x = left + (right - left) / 2.;
        double func_x = f(x);
        if (Math.abs(func_x) < 0.001) return x;
        if (func_x < 0) return task_3(x, right);
        else return task_3(left, x);
    }

    public static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }
}
