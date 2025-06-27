package org.example.services.filterService.factories;

import org.example.services.filterService.stratergies.ComparisonStratergy;
import org.example.services.filterService.stratergies.GreaterThanStrtergy;
import org.example.services.filterService.stratergies.LessThanStatergy;
import org.example.services.filterService.stratergies.Operator;

public class CompareFactory {

    private ComparisonStratergy create(Operator comparisonType){
        if(comparisonType.equals(Operator.LESS_THAN)) {
            return new LessThanStatergy();
        }
        else if (comparisonType.equals(Operator.GREATER_THAN_OR_EQUALS)) {
            return new GreaterThanStrtergy();
        }
        return null;
    }
}
