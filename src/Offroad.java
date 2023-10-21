import java.util.*;
import java.util.stream.Collectors;

public class Offroad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> fuelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(fuelStack::push);
        Deque<Integer> consumptionQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(consumptionQueue::offer);
        List<Integer> quantitiesToReach = new ArrayList<>();

        quantitiesToReach = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int counter = 0;

        for (int i = 0; i < 4; i++) {
            int currentFuel = fuelStack.pop();
            int currentConsume = consumptionQueue.poll();
            int currentHeight = quantitiesToReach.get(i);

            if (currentFuel - currentConsume >= currentHeight) {
                counter++;
                System.out.print("John has reached: Altitude " + (i + 1));
                System.out.println();
            } else {
                System.out.print("John did not reach: Altitude " + (i + 1));
                System.out.println();
                System.out.println("John failed to reach the top.");
                break;
            }
        }

        if (counter == 0) {
            System.out.println("John didn't reach any altitude.");
        } else if (counter == 1) {
            System.out.println("Reached altitudes: Altitude 1");
        } else if (counter == 2) {
            System.out.println("Reached altitudes: Altitude 1, Altitude 2");
        } else if (counter == 3) {
            System.out.println("Reached altitudes: Altitude 1, Altitude 2, Altitude 3");
        } else {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}