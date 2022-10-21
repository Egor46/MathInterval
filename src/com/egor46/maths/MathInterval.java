package com.egor46.maths;

public class MathInterval {

    public double intervalStart, intervalEnd;
    public char startSymbol, endSymbol;


    /**
     * @param interval
     * Accept a mathematics interval as constructor parameter. Ex. (x;y) [x;y)
     * If one of the bounds is Negative/Positive Infinity set it as -oo or oo respectively
     */
    public MathInterval(String interval){
        String[] start_end = interval.split(";");
        if (start_end.length>2) throw new IndexOutOfBoundsException("not an interval");
        switch(start_end[0]){
            case "-oo": this.intervalStart = Float.NEGATIVE_INFINITY;
            case "oo" : throw new ArithmeticException("cannot cast positive infinity as an interval start");
            default:
                this.startSymbol = start_end[0].charAt(0);
                this.intervalStart = Float.parseFloat(start_end[0].substring(1));
    } switch (start_end[1]) {
            case "-oo": throw new ArithmeticException();
            case "oo": this.intervalEnd = Float.POSITIVE_INFINITY;
            default:
                this.endSymbol = start_end[1].charAt(start_end[1].length()-1);
                this.intervalEnd = Float.parseFloat(start_end[1].substring(0, start_end[1].length()-1));
        }
    }
    private MathInterval(char startSymbol, double intervalStart, double intervalEnd, char endSymbol){
        this.intervalEnd = intervalEnd;
        this.intervalStart = intervalStart;
        this.startSymbol = startSymbol;
        this.endSymbol = endSymbol;
    }

    public void printIntervalBorders() {
        System.out.printf("%c%f;%f%c%n",startSymbol,intervalStart,intervalEnd,endSymbol);
    }

    public double leftEndpoint(){
        return intervalStart;
    }

    public double rightEndpoint(){
        return intervalEnd;
    }

    public static MathInterval unite(MathInterval interval1, MathInterval interval2){
        double int1Start = interval1.leftEndpoint(), int2Start = interval2.leftEndpoint();
        double int1End = interval1.rightEndpoint(), int2End = interval2.rightEndpoint();
        char int1S = interval1.startSymbol, int2S = interval2.startSymbol,
                int1E = interval1.endSymbol, int2E = interval2.endSymbol;
        char startS,endS;
        double maxEnd,minStart;
        maxEnd = Math.max(int1End, int2End);
        minStart = Math.min(int1Start, int2Start);
        endS = int1End > int2End ? int1E : int2E;
        startS = int1Start < int2Start ? int1S : int2S;
        return new MathInterval(startS, minStart,maxEnd,endS);
    }
}
