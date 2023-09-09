package edu.umb.cs680.hw10.fs.securityContext;

import edu.umb.cs680.hw10.fs.securityContext.EncryptedString;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SecurityContext {
    public boolean isActive;
    public State state;
    public List<LocalDateTime> list;

    public SecurityContext(User user){
        isActive = false;
        state = LoggedOut.getInstance(this);
        list = new ArrayList<LocalDateTime>();
    }

    public void changeState(State newState){
        state = newState;
    }

    public void login(EncryptedString pwd){
        state.login(pwd);
        LocalDateTime currentTime = LocalDateTime.now();
        list.add(currentTime);
        isActive = true;
    }

    public void logout(){
        state.logout();
        isActive = false;
    }

    public boolean userFrequency(LocalDateTime currentTime){
        boolean result = false;
        if(list.size() > 0 ){
            LocalDateTime recentTime = list.get(list.size()-1);
            long numberofdays = recentTime.until( currentTime, ChronoUnit.DAYS );
            if(numberofdays < 1){
                result = true;
            }
            else{
                result = false;
            }
        }
        else{
            result = false;
        }
        return result;
    }

    public boolean isActive(){
        return isActive;
    }

    public State getState(){
        return state;
    }

    public static void main(String[] args) {
        SecurityContext context = new SecurityContext(new User());
        System.out.print("Default State: ");
        System.out.println(context.getState().getClass().getName());
        System.out.print("\nTrying to Login ...");
        context.login(new EncryptedString());
        System.out.print("\nLogin State: ");
        System.out.print(context.getState().getClass().getName());
        System.out.print("\nIs Login Active: ");
        System.out.println(context.isActive());
        System.out.print("\nTrying to Logout ...");
        context.logout();
        System.out.print("\nLogin State: ");
        System.out.print(context.getState().getClass().getName());
        System.out.print("\nIs Login Active: ");
        System.out.println(context.isActive());
        System.out.print("\nIs Frequent User: ");
        System.out.println(context.userFrequency(LocalDateTime.now()));
        System.out.print("Check if Login Active after an hour: ");
        System.out.println(context.userFrequency(LocalDateTime.now().plusHours(1)));
        System.out.print("Check if Login Active after a day: ");
        System.out.println(context.userFrequency(LocalDateTime.now().plusDays(1)));
        context = null;
    }
}
