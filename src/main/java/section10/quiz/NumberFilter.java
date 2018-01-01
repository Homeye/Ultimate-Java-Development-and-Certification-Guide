package section10.quiz;

import section3.quiz.GovernmentBuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberFilter {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add((int) (Math.random() * 100));
        }

        integers = new ArrayList<>(
                integers.stream()
                        .filter((i) -> i < 50)
                .collect(Collectors.toList())
        );

        System.out.println(integers);

        ArrayList<GovernmentBuilding> buildings = new ArrayList<>();
        buildings.add(new GovernmentBuilding(10, 60, "C.I.A"));
        buildings.add(new GovernmentBuilding(20, 50, "F.B.I."));
        buildings.add(new GovernmentBuilding(30, 40, "NASA"));
        buildings.add(new GovernmentBuilding(40, 30, "C.I.A"));
        buildings.add(new GovernmentBuilding(50, 20, "C.I.A"));
        buildings.add(new GovernmentBuilding(60, 10, "NASA"));

        Map<String, List<GovernmentBuilding>> groupedBuildings = buildings.stream().collect(Collectors.groupingBy((building) -> building.getAgency()));
        System.out.println(groupedBuildings);
    }
}
