package org.example.services.filterService.stratergies;

public class GreaterThanStrtergy implements ComparisonStratergy{

    @Override
    public boolean compare(double inputValue, double compareValue){
        return inputValue>=compareValue;
    }
}
