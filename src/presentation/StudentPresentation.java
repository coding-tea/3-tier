package presentation;

import java.util.Scanner;

import business.StudentBusiness;

public class StudentPresentation {
    public static void main(String[] args) {

        StudentBusiness studentBusiness = new StudentBusiness();

        Scanner scanner = new Scanner(System.in);

        int choise = 0;
        while (choise != 5) {
            System.out.println("Enter from 1 to 5 : ");
            System.out.println(
                    "1 : show all student \n2 : show specific student\n3 : create a new student\n4: delete student\n5 : exit");
            choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    studentBusiness.selectALL();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Enter cin ...");
                    String cin = scanner.nextLine();
                    studentBusiness.find(cin);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter cin ...");
                    String cinCreate = scanner.nextLine();
                    System.out.println("Enter name ...");
                    String nameCreate = scanner.nextLine();
                    System.out.println("Enter age ...");
                    int ageCreate = scanner.nextInt();
                    studentBusiness.create(cinCreate, nameCreate, ageCreate);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Enter cin ...");
                    String cinDelete = scanner.nextLine();
                    studentBusiness.delete(cinDelete);
                    break;

                default:
                    break;
            }
        }

    }
}
