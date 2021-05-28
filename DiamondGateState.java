package diamond;

import java.util.Collection;

public abstract class DiamondGateState {

    protected enum State{IDLE, OPENEXIT, OPENENTRY,  CLOSEDEXIT, RETURN};


    protected DiamondGate context;

    public DiamondGateState(DiamondGate context) {
        this.context = context;
    }

    public abstract void entry_scan(String key);

    public abstract void exit_scan(String key);

    public abstract void entry_sensor_activated();

    public abstract void exit_sensor_activated();

    public abstract void pay_fine();

    public abstract void return_book(String userID);

    protected boolean hasPaid();

    protected boolean hasReturned(String userID);

    public abstract void time_out();

    public abstract State getState();

}
