public class AccountNode {
    Account account;
    AccountNode parent;
    AccountNode leftChild;
    AccountNode rightChild;

    public AccountNode(Account account) {
        this.account = account;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Account getAccount() {return account;}

    public void setAccount(Account account) {this.account = account;}

    public AccountNode getParent() {return parent;}

    public void setParent(AccountNode parent) {this.parent = parent;}

    public AccountNode getLeftChild() {return leftChild;}

    public void setLeftChild(AccountNode leftChild) {
        this.leftChild = leftChild;
        if(leftChild != null) {
            leftChild.setParent(this);
        }
    }

    public AccountNode getRightChild() {return rightChild;}

    public void setRightChild(AccountNode rightChild) {
        this.rightChild = rightChild;
        if(rightChild != null) {
            rightChild.setParent(this);
        }
    }

    public boolean hasLeftChild() {return this.leftChild != null;}

    public boolean hasRightChild() {return this.rightChild != null;}

    public boolean IsLeaf() {return this.leftChild == null && this.rightChild == null;}
}
