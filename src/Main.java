import com.egor46.maths.MathInterval;

public class Main {
    public static void main(String[] args){
        MathInterval math = new MathInterval("[10;15]");
        MathInterval math2 = new MathInterval("(1;20]");
        MathInterval math3 = MathInterval.unite(math,math2);
        math3.printIntervalBorders();
    }
}
