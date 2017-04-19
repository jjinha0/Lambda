package sortingparks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class ParksMain {
    public static void main(String[] args) {
        List<Park> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Parks.csv"));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(","); //split안하려면 외부라이브러리인 CSV Reader를 이용한다.
                list.add(new Park(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5]));
            }

//
//            //alias값이 있는 애들만 list만들기
//            Predicate<Park> p = new Predicate<Park>() {
//                @Override
//                public boolean test(Park park) {
////                    if(park.getPark_alias() == null || park.getPark_alias().equals("")) {
////                        return true;
////                    }
////                    else {
////                        return false;
////                    }
//                    //위에 if else문 한줄로 줄이기
//                    return park.getPark_alias() == null || park.getPark_alias().equals("");
//                }
//            };
//            //Lambda로 한줄로 쓰기
//            list.removeIf(p -> p.getPark_alias() == null || p.getPark_alias().equals("")); //알아서 for문돌리면서 제거해줌(직접 for문 돌리는 건 명령형언어/ 이건 함수형 언어 스타일)
//            System.out.println(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //State 오름차순 정렬
//        Collections.sort(list, (o1,o2) -> o1.getState().compareTo(o2.getState()));//compareTo라는 함수는 o1이 더 크면 - o2가 더 크면 + 리턴
//        for (Park e : list) {
//            System.out.println(e);
//        }
        //바로 위 for문을 Lambda식 한줄로!
        //list.forEach(n -> System.out.println(n));

        //1.sort : parkname의 글자수별로
        Collections.sort(list, ((o1, o2) -> o1.getPark_name().length() - o2.getPark_name().length()));
        list.forEach(n -> System.out.println(n));

        //2.filtering : 국가가 US가 아닌 것
        list.removeIf(p -> p.getCountry().equals("US"));
        list.forEach(a -> System.out.println(list));

    }
}
