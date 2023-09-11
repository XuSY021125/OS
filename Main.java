import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 0, 6));
        processes.add(new Process(2, 2, 4));
        processes.add(new Process(3, 4, 8));

        int currentTime = 0;
        for (Process process : processes) {
            if (process.arrivalTime > currentTime) {
                currentTime = process.arrivalTime;
            }
            System.out.println("执行进程 " + process.pid);
            currentTime += process.burstTime;
        }
    }
}