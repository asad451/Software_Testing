package diamond;

import java.util.Collection;

public class Idle extends DiamondGateState {

    public Idle(DiamondGate context) {
        super(context);
    }

    @Override
    public void entry_scan(String key) {
        if(context.isRegistered(key)){
            context.setState(new OpenEntry(context));
        }
    }

    @Override
    public void exit_scan(String key) {
        if(context.isRegistered(key) && !context.isOverdue(key)){
            context.setState(new OpenExit(context));
        }
        else if(context.isRegistered(key) && context.isOverdue(key)){
        	context.setState(new ClosedExit(context))
        }
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

    }

    @Override
    public void time_out() {

    }

    @Override
    public State getState() {
        return State.IDLE;
    }
}
