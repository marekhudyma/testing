package mh.mockito.util;

public class SampleClass implements SampleInterface {

    @Override
    public int methodWithArguments(final int value, final String str) {
        if(str != null) {
            return value + str.length();
        } else {
            return value;
        }
    }

    @Override
    public int methodWithoutArguments() {
        return 13;
    }

    @Override
    public void method() {

    }

}
