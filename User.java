public class User {

    private String login;
    private String password;

    public void SetLogin(String login) 
    {
        this.login = login;
    }

    public void SetPassword (String password)
    {
        this.password = password;
    }

    public Boolean authentificate(String password) {
        Boolean IsAuthentified = false;
        if(this.password.equals(password)) {
            IsAuthentified = true;
        }
        return IsAuthentified;
    }
}