import java.util.LinkedList;

public class Tree {
    private AccountNode root;

    public Tree(AccountNode root) {
        this.root = root;
    }

    public Tree() {
        this.root = null;
    }

    public AccountNode getRoot() {
        return this.root;
    }

    public void setRoot(AccountNode root) {
        this.root = root;
    }
}