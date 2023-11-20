import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Process {
    String name;
    int priority;
    int burstTime;

    public Process(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
    }
}

public class NonPriority {
    public static void main(String[] args) {
        // 创建进程列表
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 3, 8));
        processes.add(new Process("P2", 1, 6));
        processes.add(new Process("P3", 4, 9));
        processes.add(new Process("P4", 2, 4));

        // 按照优先级排序
        Collections.sort(processes, Comparator.comparingInt(p -> p.priority));

        execute(processes);
    }

    public static void execute(List<Process> processes) {
        int totalTime = 0;
        System.out.println("进程\t优先级\t执行时间\t等待时间");

        for (Process process : processes) {
            System.out.print(process.name + "\t" + process.priority + "\t" + process.burstTime);

            // 计算等待时间
            int waitingTime = totalTime;
            System.out.println("\t" + waitingTime);

            // 更新总执行时间
            totalTime += process.burstTime;
        }
    }
}