/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.version;

import java.awt.Component;
import javax.swing.ImageIcon;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


  public class MyRender extends DefaultTableCellRenderer {

public MyRender() {
    // TODO Auto-generated constructor stub
}


public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column,ImageIcon icon) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
            row, column);

    int neededRow=0; // set the needed row here in which the icon to be dispayed
    int neededcolumn=0; // set the needed column here in which the icon to be dispayed

    if(row==neededRow && column==neededcolumn)
    {
        setIcon(icon);
    }

    return this;
}
}