package testNew;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class No3Test {
	private String[] input1;
	private int input2;
	private String expected1;
	private String expected2;
	private String expected3;

	public No3Test(String[] input1,int input2,String expected1,String expected2,String expected3){  
        this.input1 = input1;
        this.input2 = input2;
        this.expected1 =  expected1;
        this.expected2 =  expected2;
        this.expected3 =  expected3;
    }
	
	static String[] str1 = {"A","B","D","G","H","C","F"};
	static String[] str2 = {"A","B","D","G","H","C"};
	static String[] str3 = {"A","B","D","G","H"};
	
	@Parameters
	@SuppressWarnings("unchecked")
    public static Collection prepareData(){  
        Object[][] object = {{str1,3,"ABGHDCF","GHBCFDA","G H C F "},{str2,2,"ABGHDC","GHBCDA","B D "},{str3,-1,"ABGHD","GHBDA","Error"},{str3,4,"ABGHD","GHBDA","Error"}};  
        return Arrays.asList(object);  
    }
	
	@Test
	public void testTreeLevel() {
		no3 no = new no3();
		String result = no.TreeLevel(no.createTree(input1), input2);
		Assert.assertEquals(expected3, result);
	}

	@Test
	public void testPreTraverse() {
		no3 no = new no3();
		String result = no.preTraverse(no.createTree(input1));
		Assert.assertEquals(expected1, result);
	}

	@Test
	public void testPostTraverse() {
		no3 no = new no3();
		String result = no.postTraverse(no.createTree(input1));
		Assert.assertEquals(expected2, result);
	}

}
