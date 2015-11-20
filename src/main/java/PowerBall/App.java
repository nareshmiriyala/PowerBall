package PowerBall;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> finalMap = new HashMap<Integer, Map<Integer, Integer>>();
        DataReader dataReader = new DataReader();
        List<PowerBallResult> powerBallResults = dataReader.readerDataFromCSV("src/test/resources/Powerball.csv");
//        List<PowerBallResult> powerBallResults = dataReader.readerDataFromCSV("src/test/resources/PowerballUnitl2013.csv");
        for (int i = 1; i <= 7; i++) {
            Map<Integer, Integer> repeatedNumbersWithCount = getRepeatedNumbersWithCount(powerBallResults, i);
            finalMap.put(i, sortByValue(repeatedNumbersWithCount));
            System.out.println("Position :" + i);
            printMap(sortByValue(repeatedNumbersWithCount));
        }
        for (int i = 1; i <= 10; i++) {
            printGuess(finalMap, i);
        }

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

    private static void printGuess(Map<Integer, Map<Integer, Integer>> finalMap, int i) {
        System.out.print("Guessed Number "+i+":");
        Iterator it = finalMap.entrySet().iterator();
        List<Integer> guessSet = new ArrayList<Integer>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Map<Integer, Integer> map = (Map<Integer, Integer>) pair.getValue();
            List<Integer> indexMap = new ArrayList<Integer>(map.keySet());
            if (guessSet.contains(indexMap.get(i - 1))) {
                guessSet.add(indexMap.get(i));
            } else {
                guessSet.add(indexMap.get(i - 1));
            }
            // System.out.print(indexMap.get(i - 1) + " ");
        }
        System.out.println(guessSet);
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        int i = 1;
        int count = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(i++ + ":Number " + pair.getKey() + " appeared " + pair.getValue() + " times");
            count = count + (Integer) pair.getValue();

        }
        System.out.println("Total count is:" + count);
    }

    private static Map<Integer, Integer> getRepeatedNumbersWithCount(List<PowerBallResult> powerBallResults, int i) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (PowerBallResult result : powerBallResults) {

            int value = getMethod(result, i);
            if (i == 7 && value > 20) {
                continue;
            }
            if (value > 0) {

                if (countMap.containsKey(value)) {
                    countMap.put(value, countMap.get(value) + 1);
                } else {
                    countMap.put(value, 1);
                }
            }
        }
        return countMap;
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
