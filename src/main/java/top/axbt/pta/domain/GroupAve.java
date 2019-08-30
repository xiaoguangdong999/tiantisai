package top.axbt.pta.domain;

import java.util.List;

public class GroupAve {

    private List<Double> ave;

    private double high;



    public GroupAve() {
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public List<Double> getAve() {
        return ave;
    }

    public void setAve(List<Double> ave) {


        this.ave = ave;
    }

}
