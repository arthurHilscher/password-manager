public class Account implements Comparable<Account> {
    private String username;
    private String encryptedPassword;
    private String service;

    public Account(String username, String encryptedPassword, String service) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.service = service;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return encryptedPassword;}

    public void setPassword(String password) {this.encryptedPassword = password;}

    public String getService() {return service;}

    public void setService(String service) {this.service = service;}

    @Override
    public int compareTo(Account otherAccount) {
        return this.service.compareTo(otherAccount.service);
    }
}
