package First_exercise;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class Range_expensive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int headsetPrice = Integer.parseInt(sc.nextLine());
        int mousePrice = Integer.parseInt(sc.nextLine());
        int keyboardPrice = Integer.parseInt(sc.nextLine());
        int dispayPrice = Integer.parseInt(sc.nextLine());
        int countForHeadset = 0;
        int countForMouse = 0;
        int countForKeyboards = 0;
        int countForDispays = 0;


        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                countForHeadset++;
            }
            if(i % 3 == 0){
                countForMouse++;
            }
            if((i % 2 == 0) && (i % 3 == 0)){
                countForKeyboards++;
                if (countForKeyboards % 2 == 0){
                    countForDispays++;
                }
            }


        }
        System.out.println(countForHeadset);
        System.out.println(countForMouse);
        System.out.println(countForKeyboards);
        System.out.println(countForDispays);

    }
}
