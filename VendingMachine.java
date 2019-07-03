import java.util.Scanner;
class VendingMachine
{
	static String[] Item= {"Coke","Pepsi","Soda"};
	static int[] Price = {25,35,45};
	static int[] Qty = {0 ,20, 30};

	//Display item..
	public void display()
	{
		for(int i = 0;i<Item.length;i++)
			System.out.println(i+1 +" "+Item[i]+" "+Price[i]+" "+ Qty[i]);
	}



	//purchase Item....
	public void purchaseItem(int itemNumber)
	{	
		try
		{
			if(Qty[itemNumber-1] <= 0)
				throw new Exception();
				
			makePayment(itemNumber);
				
					
		}
		catch(Exception e)
		{
			System.out.println("Item is not available");
		}
		
	}

	//Payment

	public static void makePayment(int itemNumber)
	{
		Scanner s =new Scanner(System.in);
		System.out.println("Enter the coins of 1,5 or 10");
		System.out.println("Pay Amount = "+Price[itemNumber-1]);
		int money = 0;
		int total =0;

		while(total < Price[itemNumber-1])
		{
			money = s.nextInt();
			if(money == 1 || money == 5 || money == 10)
				total += money;
			else
				System.out.println("Enter the coins of 1 ,5 or 10");
		}

		if(total >= Price[itemNumber-1])
		{
			int restAmount = total - Price[itemNumber-1];
			Qty[itemNumber-1]--;
			if(restAmount != 0)
				System.out.println("Collect Your rest Amount ="+ restAmount);
		}
		System.out.println("Amount Paid , Please Collect Your Item");
		System.out.println();

		
	}


     	// cancellation item 
	public static int returnItem(int itemNumber)
	{
		Qty[itemNumber-1]++;
		return Price[itemNumber-1];
	}
	

	//reset Item
	public static void resetItem(int itemNumber ,int qty)
	{
		Qty[itemNumber-1] += qty;
		
	}
	


	//main method
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		VendingMachine v= new VendingMachine();	
		int itemNumber;	
		while(true)
		{
				v.display();
				System.out.println();
				System.out.println("a. Purchase");	
				System.out.println("b. ReturnItem");
				System.out.println("c. ResetItem");
				System.out.println("d. For exit");
				System.out.println();
				System.out.println("Select choice");
				String ch=s.next();
			switch(ch)
			{
				
				case "a": 
					System.out.println("Enter Item Number");
					 itemNumber = s.nextInt();				
					v.purchaseItem(itemNumber);
					break;
				case "b":
					System.out.println("Enter the  return item number");
					 itemNumber = s.nextInt();
					 returnItem(itemNumber);
					break;
				case "c":
					System.out.println("Enter the item number for update");
					itemNumber=s.nextInt();
					System.out.println("Enter the item qty");
					int qty = s.nextInt();
					 resetItem(itemNumber, qty);
					break;
				case "d": System.exit(0);
					
				default :System.out.println("Enter valid choice");
			}
		}
	}
}

