package section10.quiz;

import section3.quiz.GovermentBuilding;

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

        ArrayList<GovermentBuilding> buildings = new ArrayList<>();
        buildings.add(new GovermentBuilding(10, 60, "C.I.A"));
        buildings.add(new GovermentBuilding(20, 50, "F.B.I."));
        buildings.add(new GovermentBuilding(30, 40, "NASA"));
        buildings.add(new GovermentBuilding(40, 30, "C.I.A"));
        buildings.add(new GovermentBuilding(50, 20, "C.I.A"));
        buildings.add(new GovermentBuilding(60, 10, "NASA"));

        Map<String, List<GovermentBuilding>> groupedBuildings = buildings.stream().collect(Collectors.groupingBy((building) -> building.getAgency()));
        System.out.println(groupedBuildings);
    }
}
