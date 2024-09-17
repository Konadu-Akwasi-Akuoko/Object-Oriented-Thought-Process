package com.example.mvc;

class StudentController {
  private Student studentModel;
  private StudentView studentView; // our console in this case

  public StudentController() {
    studentModel = new Student();
    studentView = new StudentView(studentModel);
  }

  private void setStudentName(String name) {
    studentModel.setName(name);
  }

  public String getStudentName() {
    return studentModel.getName();
  }

  private void setStudentRollNo(String rollNo) {
    studentModel.setRollNo(rollNo);
  }

  public String getStudentRollNo() {
    return studentModel.getRollNo();
  }

  public void updateView(String name, String rollNo) {
    setStudentName(name);
    setStudentRollNo(rollNo);
    studentView.printStudentDetails();
  }
}
