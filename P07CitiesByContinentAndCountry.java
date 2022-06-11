package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        while(n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new LinkedList<>());
            continents.get(continent).get(country).add(city);

        }

        for (var continent : continents.entrySet()) {
            System.out.println(continent.getKey() + ":");
            Map<String, List<String>> countries = continent.getValue();
            for (var country : countries.entrySet()) {
                String cities = String.join(", ", country.getValue());
                System.out.printf("  %s -> %s%n", country.getKey() , cities);
            }

        }
    }
}
