package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> productAndPrice = new LinkedHashMap<>();
        Map<String, Double> productAndQuantity = new LinkedHashMap<>();
        Map<String, Double> productAndSum = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"buy".equals(input)) {

            String [] parts = input.split(" ");
            String product = parts[0];
            double price = Double.parseDouble(parts[1]);
            double quantity = Double.parseDouble(parts[2]);
            productAndPrice.putIfAbsent(product,0.0);
            productAndPrice.put(product,productAndPrice.get(product) + price);
            productAndQuantity.putIfAbsent(product,0.0);
            productAndQuantity.put(product,productAndPrice.get(product) + quantity);

            input = sc.nextLine();
        }

        for (Map.Entry<String, Double> stringDoubleEntry : productAndPrice.entrySet()) {
            for (Map.Entry<String, Double> doubleEntry : productAndQuantity.entrySet()) {
                double sum = stringDoubleEntry.getValue() * doubleEntry.getValue();
                productAndSum.putIfAbsent(stringDoubleEntry.getKey(),sum);
            }
        }

        productAndSum
                .forEach((k,v) -> System.out.printf("%s -> %.2f%n",k,v));

    }
}
