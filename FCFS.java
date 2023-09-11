import java.util.ArrayList;
public class Process {
    int pid; // 进程ID
    int arrivalTime; // 到达时间
    int burstTime; // 执行时间

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
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
