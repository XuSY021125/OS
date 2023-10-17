import java.util.LinkedList;
import java.util.Queue;

public class ElevatorAlgorithm {
    private int currentFloor;
    private boolean isMovingUp;
    private Queue<Integer> floorQueue;

    public ElevatorAlgorithm() {
        currentFloor = 0;
        isMovingUp = true;
        floorQueue = new LinkedList<>();
    }

    public void requestFloor(int floor) {
        floorQueue.offer(floor); // 加入请求楼层到队列中
    }

    public void processRequests() {
        while (!floorQueue.isEmpty()) {
            int targetFloor = floorQueue.poll(); // 取出队列中的下一个目标楼层

            if (targetFloor > currentFloor) {
                moveUp(targetFloor);
            } else if (targetFloor < currentFloor) {
                moveDown(targetFloor);
            } else {
                System.out.println("Elevator is already on floor " + targetFloor);
            }
        }
    }

    private void moveUp(int targetFloor) {
        while (currentFloor < targetFloor) {
            currentFloor++;
            System.out.println("Elevator is on floor " + currentFloor);
        }

        System.out.println("Elevator has arrived at floor " + currentFloor);
    }

    private void moveDown(int targetFloor) {
        while (currentFloor > targetFloor) {
            currentFloor--;
            System.out.println("Elevator is on floor " + currentFloor);
        }

        System.out.println("Elevator has arrived at floor " + currentFloor);
    }

    public static void main(String[] args) {
        ElevatorAlgorithm elevator = new ElevatorAlgorithm();
        elevator.requestFloor(5);
        elevator.requestFloor(3);
        elevator.requestFloor(1);
        elevator.processRequests();
    }
}

