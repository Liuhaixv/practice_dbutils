package day09;

public class Account {
    long account_id;
    String name;
    String password;

    public Account() {
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
