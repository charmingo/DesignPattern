interface State {
    public void doAction(Context context);
}

class StartState implements State {
    
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(new StopState());
    }
    
    public String toString(){
        return "Start State";
    }
}

class StopState implements State {
    
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(new StartState());	
    }
    
    public String toString(){
        return "Stop State";
    }
}

class Context {
    private State startState = new StartState();
    private State stopState = new StopState();
    private State state;
    
    public Context(){
        state = startState;
    }
    
    public void setState(State state){
        this.state = state;	
    }
    
    public State getState(){
        return state;
    }
    
    public void doAction() {
        state.doAction(this);
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        
        System.out.println(context.getState().toString());
        context.doAction();
        
        System.out.println(context.getState().toString());
        context.doAction();
        
    }
}

/*
 * Start State
 * Player is in start state
 * Stop State
 * Player is in stop state
 */

