package diamond;

import java.util.Collection;

public class DiamondGate {

    DiamondGateState state;
    protected Collection<String> registered;
    protected Collection<String> overdue;
    protected int visitors;

    public DiamondGate(Collection<String> registered, Collection<String> overdue){
        this.registered = registered;
        this.overdue = overdue;
        this.visitors = 0;
        this.state = new Idle(this);
    }

    public DiamondGate(Collection<String> registered){      //constructor for entry without checking overdue - for testing
        this.registered = registered;
        this.visitors = 0;
        this.state = new Idle(this);
    }

    ////State Machine operations

    public void entry_scan(String key){
        state.entry_scan(key);
    }

    public void exit_scan(String key){
        state.exit_scan(key);
    }

    public void entry_sensor_activated(){
        state.entry_sensor_activated();
    }

    public void exit_sensor_activated(){
        state.exit_sensor_activated();
    }

    public void pay_fine(){

    }

    public void return_book(String userID){

    }

    public void time_out(){
        state.time_out();
    }

    ////Context operations

    protected void setState(DiamondGateState state){
        this.state = state;
    }

    public DiamondGateState.State getState(){
        return state.getState();
    }

    protected boolean isRegistered(String s){
        return registered.contains(s);
    }

    protected boolean isOverdue(String o){
        return overdue.contains(o);
    }

    protected boolean hasPaid(){
        return true;        //assuming user has paid the fine
    }

    protected boolean hasReturned(String userID){
        if (this.isOverdue(id) && this.hasPaid()){
            overdue.remove(id);
            return true;
        }
        else
            return false;
    }

    protected void incrementVisitors(){
        visitors++;
    }

    protected void decrementVisitors(){
        visitors--;
    }

}
