package quickSorting;

public class testing {
	int a, b;
	String s, t;

	void internalAssign(String passed) {
		passed= "hi";
	}

	String concatenate(String a, String b) {
		return a + b;
	}

	void nulltesting(testing t){
		t=new testing();
		t.s="assigned";
	}
	public static void main(String[] args) {
		testing test=new testing();
		test.s=null;
		System.out.println("s assigned as null s="+test.s);
		test.internalAssign(test.s);
		System.out.println("check if internal assign worked s="+test.s);
//		testing nullTest=null;
		testing nullTest=new testing();
		test.concatenate(test.s, test.t);
		test.nulltesting(nullTest);
		System.out.println("null testing variable"+nullTest);
		System.out.println("null testing s="+nullTest.s);
	}
}
