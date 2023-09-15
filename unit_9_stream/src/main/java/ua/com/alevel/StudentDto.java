package ua.com.alevel;

public class StudentDto {

    private String fullName;

    public StudentDto(Student student) {
        this.fullName = student.getFirstName() + " " + student.getLastName();
    }

    public StudentDto() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
