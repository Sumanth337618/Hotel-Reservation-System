public class UserSession {
    private static UserSession instance;
    private User loggedInUser;

    private UserSession() { }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(User user) {
        this.loggedInUser = user;
    }

    public User getUser() {
        return loggedInUser;
    }

    public void clearSession() {
        loggedInUser = null;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
}
