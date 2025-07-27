import java.util.Scanner;

public class UserInterface {
    static void main(String[] args) {
        Tree tree = new Tree();
        boolean exit = true;
        Scanner input = new Scanner(System.in);
        Statements.greetings();
        Statements.actions();
        //
        while (exit) {
            String action = input.nextLine();
            switch (action) {
                case "1":
                    tree.printTreeStructure();
                    break;
                case "2":
                    Statements.insepctAccount();
                    String service = input.nextLine();
                    if (tree.findAccount(service) != null) {
                        System.out.println(tree.findAccount(service).getAccount().getService());
                        System.out.println(tree.findAccount(service).getAccount().getUsername());
                        System.out.println(tree.findAccount(service).getAccount().getPassword());
                        break;
                    } else {
                        System.out.println("No such service");
                        break;
                    }
                case "3":
                    System.out.println("What is the username of this account?");
                    String newUsername = input.nextLine();
                    System.out.println("What is the password of this account?");
                    String newPassword = input.nextLine();
                    System.out.println("What is service of this account?");
                    String newService = input.nextLine();
                    Account newAccount = new Account(newUsername, newPassword, newService);
                    tree.insertAccount(newAccount);
                    break;
                case "4":
                    System.out.println("Whats the service of the account that you want to delete?");
                    String serviceToDelete = input.nextLine();
                    System.out.println("Whats your username on that account?");
                    String usernameToDelete = input.nextLine();
                    System.out.println("And lastly whats your password, so that we can verify you?");
                    String passwordToDelete = input.nextLine();
                    Account accountToDelete = new Account(serviceToDelete, usernameToDelete, passwordToDelete);
                    tree.delete(accountToDelete);
                    break;
                case "5":
                    System.out.println("Thank you for using our software!");
                    exit = false;
            }
        }
    }
}
