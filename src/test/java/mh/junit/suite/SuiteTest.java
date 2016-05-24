package mh.junit.suite;

import mh.junit.lifecycle.LifecycleTest;
import mh.junit.lifecycle.Order2Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LifecycleTest.class, Order2Test.class})
public class SuiteTest {
}
