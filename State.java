interface State {
    public void doAction();
}

class StartState implements State {    
    private Context context;
    
    public StartState(Context context) {
        this.context = context;
    }
    
    public void doAction() {
        System.out.println("Player is in start state");
        context.changeToStopState();
    }
    
    public String toString(){
        return "Start State";
    }
}

class StopState implements State {
    private Context context;
    
    public StopState(Context context) {
        this.context = context;
    }
    
    public void doAction() {
        System.out.println("Player is in stop state");
        context.changeToStartState();	
    }
    
    public String toString(){
        return "Stop State";
    }
}

class Context {
    private State startState;
    private State stopState;
    private State state;
    
    public Context(){
        startState = new StartState(this);
        stopState = new StopState(this);
        state = startState;
    }
    
    public void setState(State state){
        this.state = state;	
    }
    
    public void changeToStartState() {
        state = startState;
    }

    public void changeToStopState() {
        state = stopState;
    }
    
    public State getState() {
        return state;
    }
    
    public void doAction() {
        state.doAction();
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

