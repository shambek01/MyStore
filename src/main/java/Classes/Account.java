package Classes;

public class Account {
    private int accountId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;

    public Account(int accountId, String username, String password, String name, String surname, String email) {
        this.accountId = accountId;
        this.login = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
