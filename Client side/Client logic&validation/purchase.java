public class Purchase {
    public String purchase(List<item> v, User u) {
        int sum = 0;
        
        for (Object x:v){
            sum += x.get_price();
        }
        
        if (sum >= u.get_wallet()){
            return "Sorry, you don't have enough amount in your wallet";
        }
        else{
            if(Server.purchase(v)){
                return "Purchase successful";      
            }
            else{
                return "Sorry, Purchase unsuccessful";
            }
        }
    }
}
