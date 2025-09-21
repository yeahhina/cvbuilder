/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.User;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hinay
 */
public class EditRefereeDialog extends JDialog implements ActionListener
{
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Edit:");
    JTextArea textBox = new JTextArea(10,20);    
    JTextArea rowTextBox = new JTextArea(10,20);
    String content;


    
    public EditRefereeDialog(JTextArea rowTextBox, String content)
    {
        this.rowTextBox=rowTextBox;
        this.content=content;
        this.setLayout(new BorderLayout());
        this.setPanel(rowTextBox.getText());
        this.setSize(200,200);
        this.setVisible(true);
        this.setTitle("Edit");
    }
    public void setPanel(String text)
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        textBox.setText(text);
        panel.add(textBox, BorderLayout.CENTER);
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(this);
        editButton.setActionCommand("Edit");
        panel.add(editButton,BorderLayout.SOUTH);
        this.add(panel);
        
    }

    public JTextArea getTextBox() {
        return textBox;
    }

    public void setTextBox(JTextArea textBox) {
        this.textBox = textBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Edit")
        {
           String value = this.getTextBox().getText();
           if (!value.equals(this.rowTextBox.getText()))
            {
                User.getInstance().editInfo(this.content,  rowTextBox.getText(),value);
                rowTextBox.setText(value);
            } 
            this.dispose();
        }
    }
    
}
