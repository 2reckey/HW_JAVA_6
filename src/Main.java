public class Main {
    public static void main(String[] args) {
        Tasks.task_1(10,1);
        int n=100000000;
        Tasks.task_2(n, -1); //не нашли
        Tasks.task_2(n, (int)(Math.random()*n/2)); //нашли
        System.out.println(Tasks.task_3(0,10));
    }
}