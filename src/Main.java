public class Main {
    public static void main(String[] args) {
        // accounts:
        Account account1 = new Account("hotzenplotz", "hgudowncv", "Hotmail");
        Account account2 = new Account("grimm", "75gf9i3nj", "Kotlin");
        Account account3 = new Account("geißlein", "75ng9023mnf0", "YT");
        Account account4 = new Account("sn1p3r", "vjn39gvnco2093fv", "ABC");
        Account account5 = new Account("udiedg", "gvji2j9032vn", "AAC");
        System.out.println("****************");

        // node1 represent the root node
        Tree base = new Tree();
        System.out.println("****************");

        // accounts were added into the binary tree
        base.insertAccount(account1);
        base.insertAccount(account2);
        base.insertAccount(account3);
        base.insertAccount(account4);
        base.insertAccount(account5);
        System.out.println("****************");

        // check, if the insertion of the accounts is correct
        base.printTreeStructure();
        System.out.println("****************");

        // test of the find-function
        base.findAccount("Hotmail");
        base.findAccount("asd1");
        System.out.println("****************");

        // test of the delete-function
        base.printTreeStructure();
        base.delete(account4);
        base.printTreeStructure();
        base.delete(account1);
        base.printTreeStructure();
        System.out.println("****************");

        // test of account-functions
        System.out.println(account2.getService().equals("Kotlin"));
        System.out.println(account2.getUsername().equals("grimm"));
        System.out.println(account2.getPassword().equals("75gf9i3nj"));
        System.out.println("****************");

        // test of accountNode-functions
        base.findAccount("Kotlin");
        base.findAccount("asd1124354");
    }
}
