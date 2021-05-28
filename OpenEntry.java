package diamond;

import java.util.Timer;
import java.util.TimerTask;

public class OpenEntry extends DiamondGateState {

    public OpenEntry(DiamondGate context){
        super(context);
        TimerTask task = new TimerTask() {
            public void run() {
                context.time_out();
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 5000L;
        timer.schedule(task, delay);
    }

    @Override
    public void entry_scan(String key) {

    }

    @Override
    public void exit_scan(String key) {

    }

    @Override
    public void entry_sensor_activated() {
        context.incrementVisitors();
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
        context.setState(new Idle(context));
    }

    @Override
    public State getState() {
        return State.OPENENTRY;
    }
}
