package utabooapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int generate(List<Double> events) {

        Collections.sort(events);
        int max = 0;
        int count = 0;
        for (double event : events) {
            String[] ev = new String[2];

            ev[0] = String.valueOf((long) event);
            ev[1] = String.valueOf(event - (long) event);
            double em = Double.valueOf(ev[1]);
            if (Math.abs(em - 0.1) < 0.0001) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count--;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list = new ArrayList<Double>();
        String marker;
        while (scanner.hasNext()) {
            String event = scanner.next();
            long timeStamp = scanner.nextLong();

            if (event.equals("ENTER")) {
                list.add(timeStamp + 0.1);
            } else if (event.equals("EXIT")) {
                list.add(timeStamp + 0.0);
            } else {
                System.out.println("Invalid input");
                //return;
            }
        }
        System.out.println(generate(list));

    }
}
