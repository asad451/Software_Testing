package diamond;

import java.util.Collection;

public class Return {
    public OpenExit(DiamondGate context) {
        super(context);
    }

    @Override
    public void entry_scan(String key) {

    }

    @Override
    public void exit_scan(String key) {

    }

    @Override
    public void entry_sensor_activated() {

    }

    @Override
    public void exit_sensor_activated() {
    }

    @Override
    public void pay_fine(){

    }

    @Override
    public void return_book(String userID){
        if (context.hasReturned(userID))
    		context.setState(new Idle(context))
    }

    @Override
    public void time_out() {

    }

    @Override
    public State getState() {
        return State.RETURN;
    }    
}