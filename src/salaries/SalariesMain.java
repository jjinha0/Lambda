package salaries;

import javafx.util.converter.LocalDateStringConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalariesMain {
    public static void main(String[] args) {
        List<Salary> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Salaries.csv"));
            String line = "";
            line = br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(","); //split안하려면 외부라이브러리인 CSVReader를 이용한다.
                list.add(new Salary(LocalDate.of(Integer.parseInt(splitted[0]), 1, 1),
                        splitted[1], splitted[2], splitted[3], Integer.parseInt(splitted[4])));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


        //1.1900년대 평균연봉 구하기
        OptionalDouble average = list.stream()
//                .filter(x -> (x.getYearID().isAfter(LocalDate.of(1985, 1, 1))) &&
//                        (x.getYearID().isBefore(LocalDate.of(2000, 1, 1))))
                .filter(x -> x.getYearID().getYear() < 2000) //위에 두줄을 한줄로
                .mapToInt(a -> a.getSalary())
                .average();
        System.out.printf("1900년대 평균 연봉은 %.2f입니다.\n",average.getAsDouble());

        //2.전체 레코드의 평균연봉을 구하세요
        OptionalDouble averageOfAll = list.stream()
                .mapToInt(a -> a.getSalary())
                .average();
        System.out.println(averageOfAll.getAsDouble());

        //3.최고 연봉자와 최소 연봉자를 구하세요
        OptionalInt max = list.stream()
                .mapToInt(a -> a.getSalary())
                .max();
        System.out.println(max.getAsInt());

        OptionalInt min = list.stream()
                .mapToInt(a -> a.getSalary())
                .min();
        System.out.println(min.getAsInt());

        //4.NL의 최고 연봉을 구하세요.
        OptionalInt nl = list.stream()
                .filter(x -> x.getLgID().equals("NL"))
                .mapToInt(a -> a.getSalary())
                .max();
        System.out.println(nl.getAsInt());

        //5.NYY구단의 평균연봉을 구하세요
        OptionalDouble nyy = list.stream()
                .filter(x -> x.getTeamID().equals("NYY"))
                .mapToInt(a -> a.getSalary())
                .average();
        System.out.println(nyy.getAsDouble());

        //6.최상위연봉자 10명의 평균을 구하세요
        OptionalDouble avgBest10 = list.stream()
                .sorted(((o2, o1) -> o1.getSalary() - o2.getSalary()))
                .limit(10)
                .mapToInt(a -> a.getSalary())
                .average();
        System.out.printf("%.2f",avgBest10.getAsDouble());


    }
}
