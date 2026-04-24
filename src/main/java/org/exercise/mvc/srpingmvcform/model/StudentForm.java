package org.exercise.mvc.srpingmvcform.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentForm {

    @NotBlank(message = "Name cannot be blank")
    private String studentName;

    @Min(value = 0, message = "Points cannot be negative")
    private double earnedPoints;

    @Min(value = 1, message = "Max points need to be greater than 0")
    private double maxPoints;

    @Min(value = 0, message = "Attendance cannot be less than 0")
    @Max(value = 100, message = "Attendance cannot be greater than 100")
    private double attendancePercentage;

    public StudentForm() {}

    // ръчни getter-и и setter-и, понеже имах проблеми с lombok
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public double getEarnedPoints() { return earnedPoints; }
    public void setEarnedPoints(double earnedPoints) { this.earnedPoints = earnedPoints; }

    public double getMaxPoints() { return maxPoints; }
    public void setMaxPoints(double maxPoints) { this.maxPoints = maxPoints; }

    public double getAttendancePercentage() { return attendancePercentage; }
    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }
}