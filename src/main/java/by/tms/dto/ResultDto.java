package by.tms.dto;

import javax.validation.constraints.NotBlank;

public class ResultDto {
    @NotBlank(message = "Field cant be empty")
    private String lessonTheme;
    @NotBlank(message = "Field cant be empty")
    private String studentSurname;

    private int performance;

    public ResultDto() {
    }

    public ResultDto(String lessonTheme, String studentSurname, int performance) {
        this.lessonTheme = lessonTheme;
        this.studentSurname = studentSurname;
        this.performance = performance;
    }

    public String getLessonTheme() {
        return lessonTheme;
    }

    public void setLessonTheme(String lessonTheme) {
        this.lessonTheme = lessonTheme;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "lessonTheme='" + lessonTheme + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", performance=" + performance +
                '}';
    }
}
