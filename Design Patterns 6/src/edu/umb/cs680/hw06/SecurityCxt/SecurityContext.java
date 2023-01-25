package edu.umb.cs680.hw06.SecurityCxt;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SecurityContext {
    public boolean loginActive = false;
    public boolean result = true;
    public State state;
    public List<LocalDateTime> localDateTimes = new ArrayList<LocalDateTime>();

    public SecurityContext(User user){ state = LoggedOut.getInstance(this);}

    public void login(EncryptedString encryptedPassword, boolean result){
        state.login(encryptedPassword, result);
        loginActive = true;
        LocalDateTime currentTime = LocalDateTime.now();
        localDateTimes.add(currentTime);
    }

    public void logout(){
        state.logout();
    }
    public void changeState(State States){
        state = States;
    }

    public boolean userLoginStamps(LocalDateTime currentTime){
        boolean frequency = false;

        if(localDateTimes.size() > 0 ){
            LocalDateTime pastLoginTimeStamp = localDateTimes.get(localDateTimes.size()-1);
            double numberofdays = pastLoginTimeStamp.until( currentTime, ChronoUnit.DAYS );
            if(numberofdays < 1) return frequency = true;
            else return frequency = false;
        }
        else return frequency = false;
    }

    public boolean isLoginActive(){
        return loginActive;
    }

    public State getState(){
        return state;
    }

    public static void main(String[] args) {

    }

}
