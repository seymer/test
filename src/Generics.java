import java.util.*;

public class Generics {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("John");
        System.out.printf("List<String> names: %s%n", names);

        Map<Integer, String> idToName = new HashMap<Integer, String>();
        idToName.put(0, "John");
        System.out.printf("Map<Integer, String> idToName: %s%n", idToName);

        List<List<String>> listOfList = new ArrayList<List<String>>();
        List<String> sublist1 = new ArrayList<String>();
        sublist1.add("A String inside sublist1");
        listOfList.add(sublist1);

        List<String> sublist2 = new LinkedList<String>();
        sublist2.add("A String inside sublist2");
        listOfList.add(sublist2);
        System.out.printf("List<List<String>> listOfList: %s%n", listOfList);

        List bag = new ArrayList();
        bag.add(new Integer(0));
        bag.add(new Integer(1));
        bag.add(new Double(2008.6));
        bag.add("a string");
        List<Number> numbersInBag = extractElements(bag, Number.class);
        System.out.printf("All elements in bag: %s%nNumber elements in bag: %s%n",
                bag, numbersInBag);
        List<Integer> integersInBag = extractElements(bag, Integer.class);
        System.out.printf("All elements in bag: %s%nInteger elements in bag: %s%n",
                bag, integersInBag);
    }

    private static <T> List<T> extractElements(List bag, Class<T> type) {
        List<T> result = new ArrayList<T>();
        for (Object e : bag) {
            if (type.isAssignableFrom(e.getClass())) {
                result.add((T) e);
            }
        }
        return result;
    }
}
