public static Vector facts() throws SQLException, IOException, ClassNotFoundException
        {
            Client c = new Client();
            c.RequestFunction("report");
            Vector facts=c.RecieveVector();
            c.CloseSocket();
            return facts;
            
        }
