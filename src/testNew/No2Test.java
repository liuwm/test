package testNew;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class No2Test {
	private int input;
	private String expected; 

	public No2Test(int input,String expected){  
        this.input = input;
        this.expected =  expected;     
    }
	
	@Parameters
	@SuppressWarnings("unchecked")
    public static Collection prepareData(){  
        Object[][] object = {{10,"A"},{16,"10"},{0,"0"},{-1,"-1"},{-16,"-10"}};  
        return Arrays.asList(object);  
    }
	
	@Test
	public void testIntToHex() {
		no2 no = new no2();
		String result = no.intToHex(input);
		Assert.assertEquals(expected, result);
	}

}
