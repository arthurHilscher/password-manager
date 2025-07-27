public class Main {
    public static void main(String[] args) {
        // accounts:
        Account account1 = new Account("hotzenplotz", "hgudowncv", "Hotmail");
        Account account2 = new Account("grimm", "75gf9i3nj", "Kotlin");
        Account account3 = new Account("geißlein", "75ng9023mnf0", "YT");
        Account account4 = new Account("sn1p3r", "vjn39gvnco2093fv", "ABC");
        Account account5 = new Account("udiedg", "gvji2j9032vn", "AAC");

        // accounts were put in AccountNodes
        AccountNode node1 = new AccountNode(account1);
        AccountNode node2 = new AccountNode(account2);
        AccountNode node3 = new AccountNode(account3);
        AccountNode node4 = new AccountNode(account4);
        AccountNode node5 = new AccountNode(account5);

        // node1 represent the root node
        Tree base = new Tree(node1);

        // accounts were added into the binary tree
        base.insertAccount(account1);
        base.insertAccount(account2);
        base.insertAccount(account3);
        base.insertAccount(account4);
        base.insertAccount(account5);

        // check, if the insertion of the accounts is correct
        base.printTreeStructure();
    }
}
