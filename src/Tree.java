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

    public void findAccount(String service) {
        if(root == null){
            System.err.println("No account with this service: " + service + " was found.");
        }

        assert this.root != null;
        find(this.root, service);
    }

    private AccountNode find(AccountNode node, String service) {
        if(node == null){
            return null;
        }

        if (node.getAccount().getService().equals(service)){
            System.out.println("Found the following account with this service: " + node.getAccount().getService());
            return node;
        }

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
            System.out.println("Inserted account was added to the tree as the root node");
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
                System.out.println("Inserted account was added to the tree as the left child node of: "
                        + node.getAccount().getService());
            }
        }
        else if(comparison > 0){
            if(node.hasRightChild()){
                insert(node.getRightChild(), account);
            }
            else{
                AccountNode rightAccount = new AccountNode(account);
                node.setRightChild(rightAccount);
                System.out.println("Inserted account was added to the tree as the right child node of: "
                        + node.getAccount().getService());
            }
        }
    }

    public void delete(Account account){
        if(this.root == null){
            System.err.println("Delete called on an empty tree");
            System.err.println("Please add a node before deleting one");
        }
        this.root = deleteNode(this.root, account);
    }

    private AccountNode deleteNode(AccountNode node, Account account){
        if(node == null){
            System.err.println("The account with this service: " + account.getService() + " was not found.");
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
            System.out.println("Following account " + account.getService() + " was found and deleted.");

            if(!node.hasLeftChild()){
                return node.getRightChild();
            }
            else if(!node.hasRightChild()){
                return node.getLeftChild();
            }

            AccountNode successorNode = findMin(node.getRightChild());
            System.out.println("Inorder successor for: " + account.getService() + " is: " + successorNode.getAccount().getService());
            node.getAccount().setService(successorNode.getAccount().getService());
            node.setRightChild(deleteNode(node.getRightChild(), successorNode.getAccount()));
        }
        return node;
    }

    private AccountNode findMin(AccountNode node){
        while(node.hasLeftChild()){
            node = node.getLeftChild();
        }
        return node;
    }

    private void treeStructure(AccountNode node, String prefix, boolean isLeft){
        if(node != null){
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getAccount().getService());

            boolean hasLeft = node.hasLeftChild();
            boolean hasRight = node.hasRightChild();

            if(hasLeft){
                treeStructure(node.getLeftChild(), prefix + (isLeft ? "│   " : "    "), hasRight);
            }
            if(hasRight){
                treeStructure(node.getRightChild(), prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }

    public void printTreeStructure(){
        if(root == null){
            System.out.println("The tree is empty.");
            return;
        }
        System.out.println("Tree structure:");
        treeStructure(root, "", false);
    }
}