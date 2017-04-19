import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class SortingExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList( "200", "100", "150", "1000", "250", "300",
                                            "500",  "5000", "10000");
//        Comparator c = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) { //빼서 양수면 앞에가 큰거 음수면 뒤에가 큰거
//                return Integer.parseInt(o1) - Integer.parseInt(o2);
//            }
//        };
//        Collections.sort(list, c);


        //위에 6줄을 1줄의 Lambda함수로 만든 것.
        Collections.sort(list, (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2)) ;

        System.out.println(list);
    }
}
