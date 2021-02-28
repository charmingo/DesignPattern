interface Strategy {
   public int executeStrategy(int num1, int num2);
}

class OperationAdd implements Strategy{
    @Override
    public int executeStrategy(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy{
    @Override
    public int executeStrategy(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy{
    @Override
    public int executeStrategy(int num1, int num2) {
        return num1 * num2;
    }
}

class Context {
    private Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public int executeStrategy(int num1, int num2){
        return strategy.executeStrategy(num1, num2);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy s = new OperationAdd();
        context.setStrategy(s);
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        
        s = new OperationSubstract();
        context.setStrategy(s);
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        
        s = new OperationMultiply();
        context.setStrategy(s);
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}

/*
 * Output:
 * 10 + 5 = 15
 * 10 - 5 = 5
 * 10 * 5 = 50
 */
