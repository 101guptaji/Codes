class Test implements AutoCloseable {
	public void close() throws Exception
	{
		System.out.println("File closed");
		throw new Exception("OH NO");
	}
}

public class TryWithResources {
	
	public static void main(String[] args) {
		
		/*Test test1 = new Test();
		try {
			test1.close();
		}*/
		try(Test test1 = new Test())//<- try with resources 
		{
			//automatically call close method even if it get exception 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
