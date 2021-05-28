package diamond;

import java.util.Collection;

public class ClosedExit {

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
        if (context.hasPaid())
        	context.setState(new Return(context))
    }

    @Override
    public void return_book(String userID){

    }

    @Override
    public void time_out() {

    }

    @Override
    public State getState() {
        return State.CLOSEDEXIT;
    }
}