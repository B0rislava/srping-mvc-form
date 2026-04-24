package org.exercise.mvc.srpingmvcform.service;

import org.exercise.mvc.srpingmvcform.model.GradingResult;
import org.exercise.mvc.srpingmvcform.model.StudentForm;
import org.springframework.stereotype.Service;

@Service
public class GradingService {

    public GradingResult calculateGrade(StudentForm form) {

        double examPercentage = (form.getEarnedPoints() / form.getMaxPoints()) * 100.0;

        double attendancePercentage = form.getAttendancePercentage();

        double finalScore = 0.9 * examPercentage + 0.1 * attendancePercentage;

        examPercentage = Math.round(examPercentage * 100.0) / 100.0;
        finalScore = Math.round(finalScore * 100.0) / 100.0;

        int grade;
        String gradeLabel;

        if (finalScore >= 90) {
            grade = 6; gradeLabel = "Отличен";
        } else if (finalScore >= 75) {
            grade = 5; gradeLabel = "Много добър";
        } else if (finalScore >= 60) {
            grade = 4; gradeLabel = "Добър";
        } else if (finalScore >= 50) {
            grade = 3; gradeLabel = "Среден";
        } else {
            grade = 2; gradeLabel = "Слаб";
        }

        return new GradingResult(
                form.getStudentName(),
                examPercentage,
                attendancePercentage,
                finalScore,
                grade,
                gradeLabel
        );
    }
}