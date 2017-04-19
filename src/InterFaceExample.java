import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class InterFaceExample {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "kim", "lee", "park", "choi", "ryu", "jin"
        );

        Comparator c = new MyComparator();
        Collections.sort(list,c ); //정렬 방법을 넣어준다. c에 들어있는 MyComparator Class에 정의 되어있는 방법으로 list를 정렬

    }
}
