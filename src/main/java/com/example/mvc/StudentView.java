package com.example.mvc;

class StudentView {

  private Student studentModel;

  public StudentView(Student student) {
    this.studentModel = student;
  }

  public void printStudentDetails() {
    System.out.println("Student:");
    System.out.println("Name: " + studentModel.getName());
    System.out.println("Roll No: " + studentModel.getRollNo());
  }
}
