package salaries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo {

    public static void main(String[] args) {
        try {

            Map<String,Salary> map =
                    Files.lines(Paths.get("src\\Salaries.csv")) //Files.lines : 한 라인씩 읽어서 String stream 만들어줌.
                            .skip(1)
                            .map(x -> {
                                String[] spl = x.split(",");
                                return new Salary(
                                        LocalDate.of(Integer.parseInt(spl[0]), 1, 1),
                                        spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                            })
                            //.collect(Collectors.toList());
                            .collect(Collectors.toMap(
                                    x -> String.valueOf(new Random().nextInt()), x->x //yearID랑 playerID를 결합해도 중복값이 있어서 랜덤값 줌.
                            ));

            map.forEach((k,v) -> System.out.println(k+":"+v));

            //System.out.println(list);

//            Stream.of("a", "b", "c", "d",1,2)
//                    .forEach(System.out::println);

//            long sum = LongStream.range(1, 10000000).sum();
//            System.out.println(sum);

//            IntStream.generate(() -> 1) //무한 stream
//                    .limit(10) //10개 제한걸기
//                    .forEach(System.out::println);
//
//            Random r = new Random(); //Random Object 만듦
//            r.ints(1,7)//r.ints() <-무한 stream
//                    .limit(10000)




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}