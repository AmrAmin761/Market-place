public static Vector facts() throws SQLException
        {
            Vector facts=new Vector();
            String Query="select count(*) from person";                 //number of users
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));
            Query="select count(UID) , UID from makes group by `UID`  order BY (count(UID)) DESC";  //most valuable person
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));            
            Query="select count(*) from online_order";                  //number or orders
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));               
            Query="select sum(checkout_price) from online_order";       //income
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));       
            
            Query="select Price , ID from item group by Price order by Price DESC"; //most valuable price
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));               
            return facts;
        }