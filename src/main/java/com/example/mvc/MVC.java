package com.example.mvc;

public class MVC {
  public static void main(String[] args) {


    StudentController controller = new StudentController();

    controller.updateView("Amalitech", "Amaliro");

    controller.updateView("Mr George", "0123456789");
  }
}
