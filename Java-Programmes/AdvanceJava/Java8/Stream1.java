import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Set;

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,5,4,6,55);
        System.out.println(list);

        // `**filter**` 
        // *Question:* Fetch all numbers from a list that are greater than 5.
        List<Integer> big5 =  list.stream().filter(a->a>5).collect(Collectors.toList());
        big5.forEach(x->System.out.print(x+" "));
        System.out.println();

        // `**map**` 
        // *Question:* Transform a list of strings into a list of their uppercase versions
        List<String> names = Arrays.asList("rahul", "sonu", "Bob", "Candy");
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        upper.forEach(x->System.out.println(x));
        System.out.println();

        // `**flatMap**` 
        // *Question:* Given a list of lists of strings, flatten them into a single set of strings.
        List<List<Integer>> nestedList = Arrays.asList(
          Arrays.asList(2,5,8),
          Arrays.asList(5,10,15)  
        );

        Set<Integer> flatSet = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        flatSet.forEach(x->System.out.print(x+" "));
        System.out.println();

        // `**distinct**` 
        // *Question:* Remove duplicates from a list of integers.
        List<Integer> duplicates = Arrays.asList(10,5,4,6,55, 5, 10);
        duplicates.stream().distinct().forEach(System.out::println);
        System.out.println();

        // `**sorted**` 
        // *Question:* Sort a list of names in reverse alphabetical order.
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();

        // `**peek**` 
        // *Question:* Print each element in a list while converting them to uppercase.
        List<String> peekUpper =  names.stream().peek(x->System.out.println("Original: "+x)).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(peekUpper);

        // `**limit**` 
        // *Question:* Fetch the first 3 elements from a list of integers.
        list.stream().limit(3).forEach(x->System.out.print(x+" "));
        System.out.println();

        // `**skip**` 
        // *Question:* Skip the first 4 elements and fetch the remaining elements from a list of integers.
        list.stream().skip(4).forEach(x->System.out.print(x+" "));
        System.out.println();

        // `**reduce**` 
        // *Question:* Compute the sum of all numbers in a list.
        // List<Integer> list = Arrays.asList(10,5,4,6,55);
        Optional<Integer> sum = list.stream().reduce((a,b)->a+b);
        System.out.println("SUM: "+sum.get());

        // `**max and min**` 
        // *Question:* Find the max and min element in a list.
        Optional<Integer> max = list.stream().max(Comparable::compareTo);
        System.out.println("Max: "+max.get());

        Optional<Integer> min = list.stream().min(Comparable::compareTo);
        System.out.println("Min: "+min.get());

        // `**toArray**` 
        // *Question:* Convert a list of string into a array.
        String[] nameArr = names.stream().toArray(String[]::new);
        Arrays.stream(nameArr).forEach(name->System.out.print(name+", "));
        System.out.println();

        // `**anyMatch**` 
        // *Question:* check if any name starts with 's'.
        boolean isStartS = names.stream().anyMatch(name->name.startsWith("s"));
        System.out.println("Any name start with 's' : "+isStartS);

        // `**findFirst**` 
        // *Question:* Find first odd number in the list.
        Optional<Integer> firstOdd = list.stream().filter(x->x%2!=0).findFirst();
        System.out.println(firstOdd);

        // `**Collectors.joining**` 
        // *Question:* Concatenate all names in the list into a single string seperate by comma.
        String fullName = names.stream().collect(Collectors.joining(","));
        System.out.println("Fullname: "+fullName);
    }
}
