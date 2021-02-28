/*
 * 描述
 * 单例 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，那么我们称这种设计模式为单例。
 * 例如，对于 class Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。
 * 你的任务是设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例。
 * 
 * Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. 
 * For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.
 
 * 样例
 * 在 Java 中:
 * 
 * 	A a = A.getInstance();
 * 	A b = A.getInstance();
 * 
 * a 应等于 b.
 * 
 * 挑战
 * 如果并发的调用 getInstance，你的程序也可以正确的执行么？
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 *  
 */
 
 /*
  * 编写单例模式需要考虑的事情 
  * 单例模式：任何时候获取的对象，应该是同一个 
  * 1. 需禁止类外使用new关键字构造对象，所以用private关键字修饰构造函数，将其私有化 
  * 2. 因为不能使用new关键字构建对象，所以我们需要暴露一个方法给外部，作为单例对象与外界沟通的唯一方式。使用静态方法是个不错的选择。 
  * 3. 多线程情况下，需要保证对象是单例的。
  */

// lazy singleton
// V1.基本式
// 创建私有静态成员对象，每次获取时返回此对象。
public class Solution{
    private static Solution instance = null;
    // 1. 私有构造函数
    private Soltion() {
    }
    public static Solution getInstance(){
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
}

// V2.静态内部类版
public class Solution{
    private Soltion() {
    }
    static class lazySolution{
        static final Solution instance = new Sotluion();
    }
    
    public static Solution getInstance(){
        return lazySolution.instance;
    }    
}


// lazy singleton
// 线程安全式
// V1
public class Solution{
    private static Solution instance = null;
    private Soltion() {
    }
    public static synchronized Solution getInstance(){
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
}

// V2:双重检查 + synchronized锁懒汉版
public class Solution{
    
    // 1. 私有单例对象，禁止通过 类名.属性 访问
    // 2. 将其声明为静态成员，使得在静态方法中得以访问
    // 3. 使用volatile关键字，消除指令重排序的影响
    private static volatile Solution instance;
    
    // 1. 私有构造函数
    private Soltion(){        
    }
    
    // 静态方法，返回单例对象。双重检查+synchroinzed锁，保证多线程下instance对象唯一
    public static Solution getInstance(){
        if(instance == null){
            synchronized(Solution.class){
                if(instance == null){
                    // 多线程并发访问，只会有一个线程初始化成功
                    instance = new Soltion();
                }
            }
        }
        return instance;            
    }
}

// hungry singleton
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {
    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}

// 枚举类版
public enum Solution{
    INSTANCE;    
    public static Solutin getInstance(){
        return Solution.INSTANCE;
    }
}
