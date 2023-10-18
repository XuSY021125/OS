import java.util.Arrays;

public class SSTF {
    public static void main(String[] args) {
        int[] arrivalTime = {0, 2, 4, 5};     // 进程到达时间
        int[] burstTime = {7, 4, 1, 4};       // 进程的执行时间
        int numProcesses = arrivalTime.length; // 进程数量
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses]; // 周转时间

        // 按到达时间对进程进行排序
        int[] sortedArrivalTime = Arrays.copyOf(arrivalTime, numProcesses);
        Arrays.sort(sortedArrivalTime);

        // 计算等待时间和周转时间
        int currentTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            int index = findProcess(arrivalTime, sortedArrivalTime[i]);
            int burstTimeOfCurrentProcess = burstTime[index];
            waitingTime[index] = currentTime - arrivalTime[index];
            currentTime += burstTimeOfCurrentProcess;
            turnaroundTime[index] = waitingTime[index] + burstTimeOfCurrentProcess;
        }

        System.out.println("进程\t到达时间\t执行时间\t等待时间\t周转时间");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i + 1) + "\t" + arrivalTime[i] + "\t\t" + burstTime[i] +
                    "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }

    public static int findProcess(int[] arrivalTime, int process) {
        for (int i = 0; i < arrivalTime.length; i++) {
            if (arrivalTime[i] == process) {
                return i;
            }
        }
        return -1;
    }
}

