import java.util.Scanner;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class MyLinkedList {

    static void addElement(LinkedList<String> linkedList, String name) {
        linkedList.add(name);

        System.out.println("Name: " + name + " has been added to the LinkedList.\n");
    }

    // Function that returns the Parameter "name" if it exists in the LinkedList, if it doesn't it returns null.
    static String searchData(LinkedList<String> linkedList, String name) {
        for (String data : linkedList) {
            if(name.equals(data)) {
                System.out.println("Name: " + data + " has been found!\n");
                return data;
            }
        }

        System.out.println("Name: " + name + " does not exist in the list.\n");
        return "";
    }

    // Function that changes the specified name if it exists in the LinkedList
    static void changeElement(LinkedList<String> linkedList, String name, String newName) {
        for (int i = 0; i < linkedList.size(); i++) {
            if(linkedList.get(i).equals(name)) {
                linkedList.set(i, newName);
                System.out.println("Name: " + name + " has been altered to " + newName + ".");
                return;
            }
        }

        System.out.println("Name: " + name + " does not exist in the list.\n");
    }


    // Function that removes an element in the LinkedList if it exists
    static void removeElement(LinkedList<String> linkedList, String name) {
        if(linkedList.remove(name)) {
            System.out.println("Name: " + name + " has been successfully removed into the list.\n");
        }else {
            System.out.println("Name: " + name + " is not removed! As it is not part of the list.\n");
        }
    }

    public static void main(String[] args) {
        // LinkedList declaration
        LinkedList<String> linkedList = new LinkedList<>();

        // Scanner object declaration
        Scanner sc = new Scanner(System.in);

        // Boolean session variable declaration which determines if the session will continue or not
        boolean session = true;

        // Prompts the user to input their First Name, Middle Initial, and Last Name
        System.out.print("Please Input Your First Name.\nResponse: ");
        String firstName = sc.nextLine();

        System.out.print("Please Input Your Middle Initial.\nResponse: ");
        String middleInitial = sc.nextLine();

        System.out.print("Please Input Your Last Name.\nResponse: ");
        String lastName = sc.nextLine();


        // String instance that stores the concatenated values of the First Name, Middle Initials, and Last Name
        String fullName = firstName + " " + middleInitial + ". " + lastName;

        do {
            // Looping prompt of the program
            System.out.println("\nWelcome " + fullName + "!");
            System.out.println("""
                    <<< LinkedList Data Type Implementation >>>
                    
                    1. Add an element on the List.
                    2. Access/Search for an Element on the List.
                    3. Change/Edit an Element on the List.
                    4. Remove/Delete an Element on the List.
                    5. Exit
                    
                    """);

            byte choice;
            try {
                // Repeats the loop if the numeric value is greater than 5 or less than one
                do {
                    System.out.print("Choose an Option [1..5]: ");
                    choice = sc.nextByte();
                }while(choice < 1 || choice > 5);

                // Necessary Syntax as the previous usage of scanner has a numeric data type input to not skip the next Scanner prompt
                sc.nextLine();

                switch (choice) {
                    case 1:
                        // Prompts the user to insert a name into the LinkedList
                        System.out.print("Please input a name into the list!\nResponse: ");
                        addElement(linkedList, sc.nextLine());

                        System.out.println(linkedList + "\n");

                        break;

                    case 2:
                        // Prompts the user to input the name to search into the LinkedList
                        System.out.print("Please input a name you want to search into the list!\nResponse: ");
                        String result = searchData(linkedList, sc.nextLine());

                        break;

                    case 3:
                        // Prompts the user to input the name they want to alter into the LinkedList
                        System.out.print("Please input a name you want to change into the list!\nResponse: ");
                        String nameToChange = sc.nextLine();

                        // Prompts the user to input the new name of the altered name in the LinkedList
                        System.out.print("Please input a new name you want to put into the list!\nResponse: ");
                        String newName = sc.nextLine();

                        changeElement(linkedList, nameToChange, newName);
                        System.out.println(linkedList + "\n");

                        break;

                    case 4:
                        // Prompts the user to input the name they want to remove into the LinkedList
                        System.out.print("Please input a name you want to remove into the list!\nResponse: ");
                        removeElement(linkedList, sc.nextLine());

                        System.out.println(linkedList +  "\n");

                        break;

                    default:
                        // Default Case that will end the loop
                        session = false;
                        break;
                }
            } catch (InputMismatchException e) {
                // Catches the InputMismatchException in the program

                // Necessary Syntax as the previous usage of scanner has a numeric data type input to not skip the next Scanner prompt
                sc.nextLine();
                System.out.println("Invalid input! Please input a numeric value!\n");
            }

            // Prompts the user if they want to continue the session.
            System.out.print("Try Again [Y/N]?\nResponse: ");
            char response = sc.nextLine().charAt(0);
            if(response != 'y' && response != 'Y') break;
        }while(session);

        // Prints a goodbye message to the user as the program ends
        System.out.println("\nThank you " + fullName + "\nSee you next time!");
    }
}
