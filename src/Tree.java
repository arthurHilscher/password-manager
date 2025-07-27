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

    public AccountNode findAccount(String service) {
        return find(this.root, service);
    }

    private AccountNode find(AccountNode node, String service) {
        if (node == null) return null;

        if (node.getAccount().getService().equals(service)) return node;

        int comparison = service.compareTo(node.getAccount().getService());

        if (comparison < 0) {
            return find(node.getLeftChild(), service);
        } else {
            return find(node.getRightChild(), service);
        }
    }

    public void insertAccount(Account account){
        if(this.root == null){
            this.root = new AccountNode(account);
        }
        else{
            insert(this.root, account);
        }
    }

    private void insert(AccountNode node, Account account){
        int comparison = account.getService().compareTo(node.getAccount().getService());
        if(comparison < 0){
            if(node.hasLeftChild()){
                insert(node.getLeftChild(), account);
            }
            else{
                AccountNode leftAccount = new AccountNode(account);
                node.setLeftChild(leftAccount);
            }
        }
        else if(comparison > 0){
            if(node.hasRightChild()){
                insert(node.getRightChild(), account);
            }
            else{
                AccountNode rightAccount = new AccountNode(account);
                node.setRightChild(rightAccount);
            }
        }
    }

    public void delete(Account account){
        if(this.root == null){
            System.out.println("Delete called on an empty tree");
        }
        this.root = deleteNode(this.root, account);
        if(this.root == null){
            System.out.println("Tree is empty");
        }
    }

    private AccountNode deleteNode(AccountNode node, Account account){
        if(node == null){
            System.out.println("No such account found");
            return null;
        }

        int comparison = account.getService().compareTo(node.getAccount().getService());

        if(comparison < 0){
            node.setLeftChild(deleteNode(node.getLeftChild(), account));
        }
        else if(comparison > 0){
            node.setRightChild(deleteNode(node.getRightChild(), account));
        }
        else{
            System.out.println("Following account was found: " + account);

            if(!node.hasLeftChild()){
                return node.getRightChild();
            }
            else if(!node.hasRightChild()){
                return node.getLeftChild();
            }
        }
        return node;
    }
}