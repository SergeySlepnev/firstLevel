package dmdev.mentoring.levelone.coreleveltwo.homework.streams;

import java.util.List;
import java.util.Map;

public class StudentRunner {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Ivan", "Ivanov", 7, List.of(4, 4, 3, 5, 4, 3, 2, 1)),
                new Student("Petr", "Petrov", 21, List.of(4, 4, 3)),
                new Student("Denis", "Stepanov", 9, List.of(5, 4, 3, 5, 2, 2, 1)),
                new Student("Mariya", "Ivanova", 7, List.of(4, 4, 3, 5, 4, 3, 2, 1)),
                new Student("Dasha", "Chrernych", 5, List.of(4, 4, 3, 5)),
                new Student("Anna", "Stepanova", 3, List.of(4, 4, 5, 5, 4, 3, 2, 1)),
                new Student("Lena", "Petrova", 5, List.of(4, 4, 5, 5, 4)),
                new Student("Kris", "Ivanova", 7, List.of(4, 4)),
                new Student("Arnold", "Afanasyev", 3, List.of(4, 5, 3, 4, 2, 3)),
                new Student("Stepan", "Sidorov", 7, List.of(4, 4, 4, 5, 3, 2, 4)),
                new Student("Aleksandr", "Nevsky", 3, List.of(4, 4, 4, 4, 5)),
                new Student("Misha", "Petrov", 3, List.of(4, 4, 5, 4, 3))
        );
        Map<Integer, Double> averageGradeOnCourseWithLimits = Student.getAverageGradeOnCourseWithLimits(students);
        Student.print(averageGradeOnCourseWithLimits);
        Map<Integer, List<String>> studentFullNameOnCourse = Student.getStudentFullNameOnCourse(students);
        Student.print(studentFullNameOnCourse);
        Map<Integer, Map<Double, List<String>>> listOfStudentOnCourseWithAverageGrade = Student.getListOfStudentOnCourseWithAverageGrade(students);
        Student.print(listOfStudentOnCourseWithAverageGrade);
    }
}