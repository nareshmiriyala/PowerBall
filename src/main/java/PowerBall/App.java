package PowerBall;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { Map<Integer,Map<Integer,Integer>> finalMap=new HashMap<Integer, Map<Integer, Integer>>();
       DataReader dataReader=new DataReader();
        List<PowerBallResult> powerBallResults = dataReader.readerDataFromCSV("src/test/resources/Powerball.csv");
        for(int i=1;i<=7;i++) {
            Map<Integer, Integer> repeatedNumbersWithCount = getRepeatedNumbersWithCount(powerBallResults, i);

           finalMap.put(i,sortByValue(repeatedNumbersWithCount));
//            System.out.println("Position :"+i);
//            printMap(sortByValue(repeatedNumbersWithCount));
        }
        for(int i=1;i<8;i++) {
            printGuess(finalMap, i);
        }


    }

    private static void printGuess(Map<Integer, Map<Integer, Integer>> finalMap, int i) {
        System.out.print("Guessed Number:");
        Iterator it=finalMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            Map<Integer,Integer> map = (Map<Integer, Integer>) pair.getValue();
            List<Integer> indexMap=new ArrayList<Integer>(map.keySet());
            System.out.print(indexMap.get(i-1) + " ");
        }
        System.out.println("\n");
    }

    public static void printMap(Map mp ) {
        Iterator it = mp.entrySet().iterator();
        int i=1;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(i++ + ":Number " + pair.getKey() + " appeared " + pair.getValue() + " times");

        }
    }
    public static Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    private static Map<Integer,Integer> getRepeatedNumbersWithCount(List<PowerBallResult> powerBallResults, int i) {
        Map<Integer,Integer> countMap=new HashMap<Integer,Integer>();
        for(PowerBallResult result:powerBallResults){

                int value = getMethod(result,i);
                if(value>0) {
                    if (countMap.containsKey(value)) {
                        countMap.put(value, countMap.get(value) + 1);
                    } else {
                        countMap.put(value, 1);
                    }
                }
        }
        return countMap;
    }

    private static int getMethod(PowerBallResult result,int i) {
        switch (i){
            case 1: return result.getNumberOne();
            case 2: return result.getNumberTwo();
            case 3: return result.getNumberThree();
            case 4: return result.getNumberFour();
            case 5: return result.getNumberFive();
            case 6: return result.getNumberSix();
            case 7: return result.getPowerBall();
        }
        return 0;
    }


}
class ValueComparator implements Comparator {

    Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}

