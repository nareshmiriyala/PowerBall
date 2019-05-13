package PowerBall;

import java.util.*;

/**
 * Created by nmiriyal on 4/02/2016.
 */
class PowerBallGuess {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> finalMap = new HashMap<>();
        PowerBallDataReader powerBallDataReader = new PowerBallDataReader();
        List<PowerBallResult> powerBallResults = powerBallDataReader.readerDataFromCSV("src/test/resources/Powerball.csv");
        Map<Integer,Integer> firstDivisionCounts= new HashMap<>();
        for(PowerBallResult result:powerBallResults){
            for(int i=1;i<=8;i++){
                int value=getMethod(result,i);
                if (value > 0) {

                    if (firstDivisionCounts.containsKey(value)) {
                        firstDivisionCounts.put(value, firstDivisionCounts.get(value) + 1);
                    } else {
                        firstDivisionCounts.put(value, 1);
                    }
                }
            }
        }
        System.out.println(firstDivisionCounts.size());
        System.out.println(sortByValue(firstDivisionCounts));
        Map<Integer,Integer> secondDivision= new HashMap<>();
        for(PowerBallResult result:powerBallResults){
                int value=result.getPowerBall();
                if (value > 0) {

                    if (secondDivision.containsKey(value)) {
                        secondDivision.put(value, secondDivision.get(value) + 1);
                    } else {
                        secondDivision.put(value, 1);
                    }
            }
        }
        System.out.println(secondDivision.size());

        System.out.println(sortByValue(secondDivision));

    }
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    private static int getMethod(PowerBallResult result, int i) {
        switch (i) {
            case 1:
                return result.getNumberOne();
            case 2:
                return result.getNumberTwo();
            case 3:
                return result.getNumberThree();
            case 4:
                return result.getNumberFour();
            case 5:
                return result.getNumberFive();
            case 6:
                return result.getNumberSix();
            case 7:
                return result.getNumberSeven();
            case 8:
                return result.getPowerBall();
        }
        return 0;
    }
}
