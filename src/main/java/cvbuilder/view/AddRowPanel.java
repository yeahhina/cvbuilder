/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author hinay
 */
public class AddRowPanel extends JPanel implements ActionListener{
    String content;
    JTextArea textField;

    public AddRowPanel(String content)
    {
        this.content=content;
        Border panelBorder = BorderFactory.createTitledBorder("");
        this.textField = new JTextArea(4,20);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setActionCommand("Add");
        this.setBorder(panelBorder);
        this.add(textField);        
        this.add(Box.createRigidArea(new Dimension(10, 50)));
        this.add(addButton);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Add":
                String value = textField.getText();
                User.getInstance().addInfo(content, value);
                Container parentContainer = this.getParent();
                DataPanel parentPanel = (DataPanel) parentContainer;
                parentContainer.remove(this);
                RowDataPanel rowPanel =  new RowDataPanel(content,value);
                parentPanel.add(rowPanel);
                parentPanel.add(this);
                parentPanel.getRows().add(rowPanel);
                textField.setText(null);
                parentPanel.revalidate();
                parentPanel.repaint();
                break;
                
            
        }
    }
    
    
}
