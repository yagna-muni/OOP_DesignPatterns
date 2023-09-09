package edu.umb.cs680.hw06;

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

    public void login(EncryptedString password){
        state.login(password);
        LocalDateTime currentTime = LocalDateTime.now();
        list.add(currentTime);
        isActive = true;
    }

    public void loginFail(EncryptedString password){
        state.loginFail(password);
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

}
