public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("hotzenplotz", "hgudowncv", "Hotmail");
        Account account2 = new Account("grimm", "75gf9i3nj", "Kotlin");
        Account account3 = new Account("geißlein", "75ng9023mnf0", "YT");

        AccountNode node1 = new AccountNode(account1);
        AccountNode node2 = new AccountNode(account2);
        AccountNode node3 = new AccountNode(account3);

        Tree base = new Tree(node1);

        System.out.println(node1 == base.getRoot());
        base.insertAccount(account2);
        System.out.println(node1.hasLeftChild());
        System.out.println(node1.hasRightChild());


    }
}
