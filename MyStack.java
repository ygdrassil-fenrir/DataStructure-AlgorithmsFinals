/*
Leader: Serafica, France Aaron D.

Members:
Aquino, Samantha Jane
Baltazar, Eyannah Lawrence
Ramirez, Loreta
Refrea, Jerick
*/

import java.util.Scanner;
import java.util.Stack;
import java.util.InputMismatchException;

public class MyStack {

    // Method that pushes an element into the stack
    static void addElement(Stack<String> stack, String name) {
        stack.push(name);

        System.out.println("Name: " + name + " has been added into the stack.\n");
    }

    // Method that pops an element on the stack
    static void removeElement(Stack<String> stack) {
        if(!stack.empty()) {
            System.out.println("Name: " + stack.pop() + " has been removed to the Stack.\n");
        }else {
            System.out.println("The stack is empty! Unable to remove an element.\n");
        }
    }

    // Method that peeks the top element on the stack
    static void peekElement(Stack<String> stack) {
        if(!stack.empty()) {
            System.out.println("The name on the top of the stack is: " + stack.peek() + ".\n");
        }else {
            System.out.println("The stack is empty! Unable to remove an element.\n");
        }
    }


    // Method that searches an element in the stack and show its index position in the stack
    static void searchElement(Stack<String> stack, String name) {
        if(!stack.empty()) {
            if(stack.contains(name)) {
                System.out.println("Name: " + name + " is found at index " + stack.indexOf(name) + " in the stack.\n");
            }else {
                System.out.println("Name: " + name + " is not found in the stack.\n");
            }
        }else {
            System.out.println("The stack is empty! Unable to remove an element.\n");
        }
    }

    public static void main(String[] args) {
        // Stack declaration
        Stack<String> stack = new Stack<>();

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
                    <<< Stack Data Type Implementation >>>
                    
                    1. Add an element at the Top of the Stack.
                    2. Remove an element from the Top of the Stack.
                    3. Peek which object is at the Top of the Stack.
                    4. Search for an Element in the Stack.
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
                        // Prompts the user to input the name they want to push into the stack
                        System.out.print("Please input the name that you want to add in the stack.\nResponse: ");
                        addElement(stack, sc.nextLine());
                        break;

                    case 2:
                        // Removes the top-element on the stack
                        removeElement(stack);
                        break;

                    case 3:
                        // Peeks the top-element on the stack
                        peekElement(stack);
                        break;

                    case 4:
                        // Prompts the user to input the name they want to search in the stack
                        System.out.print("Please input the name that you want to search in the stack.\nResponse: ");
                        searchElement(stack, sc.nextLine());
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
