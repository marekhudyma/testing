package mh.junit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(Fast.class)
@ExcludeCategory(Slow.class)
@SuiteClasses(CategoryTest.class)
public class Category2Test {

}

