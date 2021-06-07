package WorkingWithAbstraction.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] initialStates = scan.nextLine().split("\\s+");
        int numberOfUpdates = Integer.parseInt(scan.nextLine());
        List<TrafficLight> lights = new ArrayList<>();
        for (String initialLightState : initialStates) {
            TrafficLight light = new TrafficLight(LIGHT_STATE.valueOf(initialLightState));
            lights.add(light);
        }
        for (int i = 0; i < numberOfUpdates; i++) {
            for (TrafficLight light : lights) {
                light.update();
                System.out.print(light.getState() + " ");
            }
            System.out.println();
        }
    }
}
