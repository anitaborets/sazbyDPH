package com.engeto;

import java.util.Comparator;

public class StateTaxComparator implements Comparator<StateTax> {

    @Override
    public int compare(StateTax o1, StateTax o2) {
        return o2.getBasicVAT() - o1.getBasicVAT();
    }
}
