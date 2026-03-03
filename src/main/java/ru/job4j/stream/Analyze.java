package ru.job4j.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedHashMap;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
                return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(subject -> subject.score())
                        .average().orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                            double a = pupil.subjects().stream()
                                    .mapToInt(subject -> subject.score())
                                    .average().orElse(0.0);

                            return new Tuple(pupil.name(), a);
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> subjectAvg = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                       subject -> subject.name(),
                        LinkedHashMap::new,
                       Collectors.averagingInt(subject -> subject.score())
                ));
        return subjectAvg.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    double a = pupil.subjects().stream()
                            .mapToInt(subject -> subject.score())
                            .sum();
                    return new Tuple(pupil.name(), a);
                })
                .max((t1, t2) -> Double.compare(t1.score(), t2.score())).orElse(new Tuple("No students", 0.0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {

        Map<String, Double> subjectAvg = stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                        subject -> subject.name(),
                        LinkedHashMap::new,
                        Collectors.summingDouble(subject -> subject.score())
                ));
        return subjectAvg.entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))

                .max((t1, t2) -> Double.compare(t1.score(), t2.score())).orElse(new Tuple("No subjects", 0.0));
    }
    }