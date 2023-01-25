package edu.umb.cs680.hw05;

public class SecurityContext {
    State state;
    User u;
    boolean Login1 = !false;

    public SecurityContext(User u){
        state = new LoggedOut(this);
    };
    public void login(EncryptedString pwd){
        state.login(pwd);
        if(Login1) {
            Login1 = false;
        }
    };

    public void logout(){
        state.logout();
    };


    public void Statechange(State newState){

        state = newState;
    };

    public State Stateget(){

        return this.state;
    }
    public boolean isActive(){

        return this.Login1;
    };

    public static void main(String[] args) {
        SecurityContext conte = new SecurityContext(new User());
        System.out.println("Logged in "+conte.Stateget());
        System.out.println("Logged out" +conte.Stateget());

        conte.login(new EncryptedString());
        System.out.println("Logged in "+conte.Stateget());
        System.out.println("Logged out" +conte.Stateget());

        System.out.println("Logged out" +conte.Stateget());



    }
}


