import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Process{
    String name;
    int priority;
    int burstTime;

    public Process(String name, int priority, int burstTime) {
        this.name = name;
        this.priority = priority;
        this.burstTime = burstTime;
    }
}

public class GrabPriority {
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
        int currentTime = 0;
        System.out.println("时间\t进程\t优先级\t执行时间");

        while (!processes.isEmpty()) {
            Process currentProcess = processes.get(0);

            // 执行当前进程
            System.out.println(currentTime + "\t" + currentProcess.name + "\t" + currentProcess.priority + "\t" + currentProcess.burstTime);
            currentTime += 1;
            currentProcess.burstTime -= 1;

            // 检查当前进程是否执行完毕
            if (currentProcess.burstTime == 0) {
                processes.remove(0);
            }

            // 更新优先级
            processes.sort(Comparator.comparingInt(p -> p.priority));

            // 重新排序后，检查是否有更高优先级的进程到达
            if (!processes.isEmpty() && processes.get(0).priority > currentProcess.priority) {
                continue;
            }

            // 切换到下一个进程
            if (!processes.isEmpty()) {
                processes.add(currentProcess);
            }
        }
    }
}

