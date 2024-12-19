import java.util.Scanner;
import java.util.InputMismatchException;

// Class of Node Object
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class MyTree {

    // Method that traverses and prints the data of the tree in Pre-Order Traversal
    static void printPreOrder(Node node) {
        if(node == null) return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Method that traverses and prints the data of the tree in In-Order Traversal
    static void printInOrder(Node node) {
        if(node == null) return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    // Method that traverses and prints the data of the tree in Post-Order Traversal
    static void printPostOrder(Node node) {
        if(node == null) return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        // Scanner object declaration
        Scanner sc = new Scanner(System.in);

        // Boolean session variable declaration which determines if the session will continue or not
        boolean session = true;

        // Root Node declaration
        Node root = new Node(1);

        // Left Sub-tree
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Right Sub-tree
        root.right = new Node(3);
        root.right.right = new Node(6);


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
            System.out.println("\nWelcome " + fullName + "!");
            System.out.println("""
                    <<< LinkedList Data Type Implementation >>>
                    
                    1. Preorder Traversal output.
                    2. Inorder Traversal output.
                    3. Postorder Traversal output.
                    4. Exit
                    
                    """);

            byte choice;
            try {
                // Repeats the loop if the numeric value is greater than 5 or less than one
                do {
                    System.out.print("Choose an Option [1..4]: ");
                    choice = sc.nextByte();
                }while(choice < 1 || choice > 4);

                // Necessary Syntax as the previous usage of scanner has a numeric data type input to not skip the next Scanner prompt
                sc.nextLine();

                switch (choice) {
                    case 1:
                        // Calls the printPreOrder where it prints the value of the nodes in Pre-Order Traversal
                        System.out.println();
                        printPreOrder(root);
                        System.out.println("\n");
                        break;

                    case 2:
                        // Calls the printInOrder where it prints the value of the nodes in In-Order Traversal
                        System.out.println();
                        printInOrder(root);
                        System.out.println("\n");
                        break;

                    case 3:
                        // Calls the printPostOrder where it prints the value of the nodes in Post-Order Traversal
                        System.out.println();
                        printPostOrder(root);
                        System.out.println("\n");
                        break;

                    default:
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
