package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double totalSum = 0;
        int totalCount = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalSum += subject.score();
                totalCount++;
            }
        }

        return totalSum / totalCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil takenPupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject s : takenPupil.subjects()) {
                sum = sum + s.score();
                count++;
            }
            double avg = sum / count;
            Label label = new Label(takenPupil.name(), avg);
            result.add(label);
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Set<String> uniqueSubjects = new HashSet<>();
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                uniqueSubjects.add(subject.name());
            }
        }

                for (String subjectName : uniqueSubjects) {
                    double sum = 0;
                    int count = 0;

                    for (Pupil pupil2 : pupils) {
                        for (Subject subject2 : pupil2.subjects()) {
                            if (subject2.name().equals(subjectName)) {
                                sum += subject2.score();
                                count++;
                            }
                        }
                    }
                    double avg = sum / count;
                    result.add(new Label(subjectName, avg));
                }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            if (best == null || sum > best.score()) {
                best = new Label(pupil.name(), sum);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectSums = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectSums.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }

        Label best = null;
        for (Map.Entry<String, Double> entry : subjectSums.entrySet()) {
            if (best == null || entry.getValue() > best.score()) {
                best = new Label(entry.getKey(), entry.getValue());
            }
        }
        return best;
    }
}