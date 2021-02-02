package tests;

public class Test5 {

	
	public static void main(String[] args) 
	{
		program1();
		
	}
		public static void program1()
		{
	for(int i=1;i<=100;i++)
	{
		if(i%3==0 && i%5==0)
		{
			System.out.print("Resolver"+" ");
		}
		else if(i%5==0)
		{
			System.out.print("MFive"+"  ");
		}
		else  if(i%3==0)
		{
			System.out.print("MThree"+"  ");
		}
			
		else
		{
		System.out.print(i+"  ");
		}
	}
		}
	

	

}
