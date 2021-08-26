package com.engeto;

import java.math.BigDecimal;

public class StateTax {
    String state;
    String stateFullName;
    int basicVAT;
    Double reducedVAT;
    boolean parkingVAT;


    //konstrutory
    public StateTax(String state, String stateFullName, int basicVAT, Double reducedVAT, boolean parkingVAT) throws TaxException{
        this.state = state;
        this.stateFullName = stateFullName;
        this.basicVAT = basicVAT;
        this.reducedVAT = reducedVAT;
        this.parkingVAT = parkingVAT;
    }

   public StateTax () throws TaxException{

   }

    //gettery a settery
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateFullName() {
        return stateFullName;
    }

    public void setStateFullName(String stateFullName) {
        this.stateFullName = stateFullName;
    }

    public int getBasicVAT() {
        return basicVAT;
    }

    public void setBasicVAT(int basicVAT) {
        this.basicVAT = basicVAT;
    }

    public double getReducedVAT() {
        return reducedVAT;
    }

    public void setReducedVAT(Double reducedVAT) {
        this.reducedVAT = reducedVAT;
    }

    public boolean isParkingVAT() {
        return parkingVAT;
    }

    public void setParkingVAT(boolean parkingVAT) {
        this.parkingVAT = parkingVAT;
    }

    @Override
    public String toString() {
        return "\b" + "\b" + stateFullName + " (" + state + "): "
                 + basicVAT +  " %" + "\n";

    }
}