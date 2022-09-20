package com.egor46.maths;

public class MathInterval {

    public float intervalStart, intervalEnd;
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
                this.endSymbol = start_end[1].charAt(start_end[1].length()-1);
                this.intervalEnd = Float.parseFloat(start_end[1].substring(0, start_end[1].length()-1));
    } switch (start_end[1]) {
            case "-oo": throw new ArithmeticException();
        }
    }

    public void printSetBorders() {
        System.out.println(String.format("%c%f;%f%c",startSymbol,intervalStart,intervalEnd,endSymbol));
    }
}
