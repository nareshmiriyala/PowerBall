package PowerBall;

import java.util.*;

/**
 * Created by nmiriyal on 4/02/2016.
 */
public class PowerBallGuess {
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> finalMap = new HashMap<Integer, Map<Integer, Integer>>();
        DataReader dataReader = new DataReader();
        List<PowerBallResult> powerBallResults = dataReader.readerDataFromCSV("src/test/resources/Powerball.csv");
        Map<Integer,Integer> firstDivisionCounts=new HashMap<Integer, Integer>();
        for(PowerBallResult result:powerBallResults){
            for(int i=1;i<=6;i++){
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
        Map<Integer,Integer> secondDivision=new HashMap<Integer, Integer>();
        for(PowerBallResult result:powerBallResults){
                int value=getMethod(result,7);
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
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {

            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
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
                return result.getPowerBall();
        }
        return 0;
    }
}
