package dmdev.mentoring.levelone.coreleveltwo.homework.streams;
/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Student {

    private final static int LIMIT_OF_GRADES = 3;

    private final String firstName;
    private final String lastName;
    private int courseNumber;
    private List<Integer> gradeList;

    public Student(String firstName, String lastName, int courseNumber, List<Integer> gradeList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        //можно ли так писать в конструкторе, чтобы потом не получить NPE? в сеттере такая же логика
        //idea подсказала вот такой код: this.gradeList = Objects.requireNonNullElseGet(gradeList, ArrayList::new);
        if (gradeList == null) {
            this.gradeList = new ArrayList<>();
        } else {
            this.gradeList = gradeList;
        }
    }

    /**
     * Все методы вызвращают TreeMap, чтобы получить готовую сортировку по курсу и по средней оценке.
     * <p>
     * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
     * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
     */
    public static Map<Integer, Double> getAverageGradeOnCourseWithLimits(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGradeList().size() > LIMIT_OF_GRADES)
                .collect(groupingBy(Student::getCourseNumber, TreeMap::new, averagingDouble(student -> student.getGradeList()
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .summaryStatistics()
                        .getAverage())));
    }

    /**
     * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
     * Список студентов данного курса, но только с полями Имя и Фамилия.
     * Список должен быть отсортированы по этим двум полям
     */
    public static Map<Integer, List<String>> getStudentFullNameOnCourse(List<Student> students) {
        return students.stream()
                .sorted(comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(groupingBy(Student::getCourseNumber, TreeMap::new, mapping(Student::getFullName, toList())));
    }

    /**
     * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
     * Объект с двумя полями:
     * Отсортированный список студентов с пункта 2
     * Средняя оценка этих студентов
     */
    // часто ли на практике такое примеяется? Выглядит сложно и нечитабельно.
    public static Map<Integer, Map<Double, List<String>>> getListOfStudentOnCourseWithAverageGrade(List<Student> students) {
        return students.stream()
                .sorted(comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(groupingBy(Student::getCourseNumber, TreeMap::new, groupingBy(student -> student.getGradeList()
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .summaryStatistics()
                        .getAverage(), TreeMap::new, mapping(Student::getFullName, toList()))));
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static void print(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map<?, ?> valueMap) {
                System.out.println(entry.getKey());
                for (Map.Entry<?, ?> mapValue : valueMap.entrySet()) {
                    if (mapValue.getKey() instanceof Double) {
                        System.out.printf("%.3f = %s \n", mapValue.getKey(), mapValue.getValue());
                    } else {
                        System.out.println(mapValue.getKey() + " = " + mapValue.getValue());
                    }
                }
            } else {
                if (entry.getValue() instanceof Double) {
                    System.out.printf("%s = %.3f \n", entry.getKey(), entry.getValue());
                } else {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", courseNumber = " + courseNumber +
                ", gradeList = " + gradeList +
                "}";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public List<Integer> getGradeList() {
        return gradeList;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setGradeList(List<Integer> gradeList) {
        if (gradeList == null) {
            this.gradeList = new ArrayList<>();
        } else {
            this.gradeList = gradeList;
        }
    }
}