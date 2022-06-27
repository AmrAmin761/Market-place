package parallel;
import java.util.ArrayList;




public class cart {
  ArrayList<Item> itemlist = new ArrayList<Item>(); 
 

    public cart() {
    }
    
   public void empty()
     {
       itemlist.clear();
     } 
     
        public void add(Item anitem)
    {
  
     for(int i = 0; i < itemlist.size(); i++)
     {
     Item item = itemlist.get(i);
      if(anitem.id == item.id)                       // already in the cart?
      {
       item.quantity += anitem.quantity;              // yes, just update the quantity
       return;
      }
     }
     itemlist.add(anitem);                             // no, add it as a new item
    }
        
        
       public void remove(int id)
    {
  
     for(int i = 0; i < itemlist.size(); i++)
     {
      Item item = itemlist.get(i);
      if(id == item.id)                             // item in the cart?
      {
       itemlist.remove(i);                          // remove it
       break;
      }
     }
    
    
    }   
  
    
    } 
