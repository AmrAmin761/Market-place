public Reports() throws SQLException, IOException, ClassNotFoundException {
        Vector parameters=Logic.functions.facts();
        initComponents();
        USERS.setText(parameters.get(0).toString());
        MVU.setText("Client ID: "+parameters.get(1).toString());
        NUMBEROFORDERS.setText(parameters.get(2).toString());
        INCOME.setText(parameters.get(3).toString());
        MVI.setText(parameters.get(4).toString());
    }