package PowerBall;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by nmiriyal on 4/02/2016.
 */
class OzLottoGuess {
  public static void main(String[] args) {
    Map<Integer, Map<Integer, Integer>> finalMap = new HashMap<>();
    OzLottoDataReader ozLottoResultReader = new OzLottoDataReader();
    List<OzLottoResult> ozLottoResults = ozLottoResultReader.readerDataFromCSV("src/test/resources/OzLotto.csv");
    Map<Integer, Integer> firstDivisionCounts = new HashMap<>();
    for (OzLottoResult result : ozLottoResults) {
      for (int i = 1; i <= 10; i++) {
        int value = getMethod(result, i);
        if (value > 0) {

          if (firstDivisionCounts.containsKey(value)) {
            firstDivisionCounts.put(value, firstDivisionCounts.get(value) + 1);
          }
          else {
            firstDivisionCounts.put(value, 1);
          }
        }
      }
    }
    System.out.println(firstDivisionCounts.size());
    System.out.println(sortByValue(firstDivisionCounts));
//    Map<Integer, Integer> secondDivision = new HashMap<>();
//    for (OzLottoResult result : ozLottoResults) {
//      int value = getSupplOne(result);
//      if (value > 0) {
//
//        if (secondDivision.containsKey(value)) {
//          secondDivision.put(value, secondDivision.get(value) + 1);
//        }
//        else {
//          secondDivision.put(value, 1);
//        }
//      }
//    }
//    System.out.println(secondDivision.size());
//
//    System.out.println(sortByValue(secondDivision));
//    Map<Integer, Integer> thisSupp = new HashMap<>();
//    for (OzLottoResult result : ozLottoResults) {
//      int value = result.getSuppTwo();
//      if (value > 0) {
//
//        if (thisSupp.containsKey(value)) {
//          thisSupp.put(value, thisSupp.get(value) + 1);
//        }
//        else {
//          thisSupp.put(value, 1);
//        }
//      }
//    }
//    System.out.println(thisSupp.size());
//
//    System.out.println(sortByValue(thisSupp));

  }

  private static int getSupplOne(OzLottoResult result) {
    return result.getSupplOne();
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

  private static int getMethod(OzLottoResult result, int i) {
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
      case 9:
        return result.getSupplOne();
      case 10:
        return result.getSuppTwo();
    }
    return 0;
  }
}
