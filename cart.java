
import java.util.ArrayList;




public class cart {
    ArrayList<item> itemlist = new ArrayList<item>(); 
 

    public cart() {
    }
    
   public void empty()
     {
       itemlist.clear();
     } 
     
        public void add(item anitem)
    {
  
     for(int i = 0; i < itemlist.size(); i++)
     {
     item item = itemlist.get(i);
      if(anitem.ID == item.ID)                       // already in the cart?
      {
       item.Amount += anitem.Amount;              // yes, just update the quantity
       return;
      }
     }
     itemlist.add(anitem);                             // no, add it as a new item
    }
        
        
       public void remove(int ID)
    {
  
     for(int i = 0; i < itemlist.size(); i++)
     {
      item item = itemlist.get(i);
      if(ID == item.ID)                             // item in the cart?
      {
       itemlist.remove(i);                          // remove it
       break;
      }
     }
    
    
    }  
       
       	public  void printList()
	{
		System.out.println("your cart contains: ");
		for(Object i : itemlist )
		{
			System.out.println(((item) i).getAmount() + " " + ((item) i).getBrand() + " Costing" +" "+ ((item) i).getPrice() +" " + "for each" );
		}

	} 
  
    
    } 
