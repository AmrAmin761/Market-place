/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elkom
 */
public class creditcard_2 {
    public static boolean checkstring(String str){
        boolean isvalid= true;
        for(int i =0; i<str.length(); i++){
            char ch =str.charAt(i);
            if(ch>='a' && ch<='z'||ch>='A'&&ch<='Z'){
                continue;
            }
            isvalid = false;
        }
        if(isvalid){
            System.out.print("true ");
            return true;
        }
        System.out.print("false ");
        return false;
    
    }
    //check the holder name
    public static boolean check_holder_name(String name){
        if(checkstring(name)){
            return true;
        }else{
            return false;
        }
    }
    // check the card number
    public static boolean check_card_num(String card_num){
        if(card_num.length()==16 && card_num.matches("[0-9]+")){
            
            return true;
        
        }else{
            
             return false;
        }
    
    }
    // check the expiration month and year
        public static boolean check_expiration(int year,int month,int cur_year,int cur_month){
        if(month>12&&cur_month>12){
           // System.out.print("invalid input");
            return false;
        
        }else if(year>cur_year||month>cur_month &&year>cur_year ){
          //  System.out.print(" val");
            return true;
        }else{
          //  System.out.print("not val");
            return false;
        }
    }
        //check the ccv number
        public static boolean check_ccv(String ccv){
            if(ccv.length()==3&&ccv.matches("[0-9]+")){
                System.out.print("valid input");
                return true;
            }else{
                System.out.print("invalid input");
                
                return false;
            }
        }  
    public static int transactions(String holder_nam,String card_nn,int year,int month,String CCV,int withdraw_money,int money){
        int c_y = 2022;
        int c_m =6;
        if(!check_card_num(card_nn)){
            System.out.print("invalid input card");
            return 0;
        }else if(!check_holder_name(holder_nam)){
             System.out.print("invalid input name");
             return 0;
        }else if(!check_expiration(year,month,c_y,c_m)){
             System.out.print("invalid input date");
             return 0;
       }else if(!check_ccv(CCV)){
           System.out.print("invalid input cccv");
           return 0;
        }
        
        // check if the card exist in data base
        //fetch the wallet related to the user account and store it in varilabe wallet 
        int wallet=0;
        if(withdraw_money>money){
            System.out.print("insufficient money");
            return 0;
         }else{
           wallet = wallet + withdraw_money;
           money = money -withdraw_money;
           System.out.print("current balance"+money);
           System.out.print("current wallet"+wallet);
            // update values in data base
           return wallet;
           
           // update values in data base
            }
    }        
}
