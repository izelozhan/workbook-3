package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("/c:/Users/izel/pluralsight/workbook-3/PayrollCalculator/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] tokens = input.split("\\|");

                if (tokens[0].equals("id")) {
                    continue;
                }

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hours = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee newEmployee = new Employee(id, name, hours, payRate);
                System.out.println("Employee Information");
                System.out.println("ID: " + newEmployee.getEmployeeId() );
                System.out.println("NAME: " + newEmployee.getName());
                System.out.println("HOURS: " + newEmployee.getHoursWorked());
                System.out.println("PAY RATE: " + newEmployee.calculateGrossPay());
                System.out.println("\n");
            }
            bufReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
