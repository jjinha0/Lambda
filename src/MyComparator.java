import java.util.Comparator;

/**
 * Created by danawacomputer on 2017-04-19.
 */

//interface인 Comparator를 class로 하기위한 작업
public class MyComparator implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length(); //글자 갯수 순서
    }
}
