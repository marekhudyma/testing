package mh.junit.theories;


import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(Theories.class)
public class Theories3Test {

    public static class IntSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(final ParameterSignature sig) {
            List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            list.add(PotentialAssignment.forValue("number1", 1));
            list.add(PotentialAssignment.forValue("number2", 2.0));
            list.add(PotentialAssignment.forValue("number3", 3.0));
            return list;
        }
    }

    @Theory
    public void theoryAdd(@ParametersSuppliedBy(IntSupplier.class) Number number1,
                          @ParametersSuppliedBy(IntSupplier.class) Number number2) throws Exception {
        System.out.println(number1 + " + " + number2 + " = " + (number1.doubleValue() + number2.doubleValue()));
    }

}
