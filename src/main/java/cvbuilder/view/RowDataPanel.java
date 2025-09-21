package cvbuilder.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import cvbuilder.model.User;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author hinay
 */
public class RowDataPanel extends JPanel implements ActionListener{
    private JRadioButton mainRadioButton = new JRadioButton();
    private JButton editButton = new JButton("Edit");
    private JButton deleteButton = new JButton("Delete");
    private String content;
    private JTextArea textBox;
    private String selectedText;

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }

    public JRadioButton getMainRadioButton() {
        return mainRadioButton;
    }

    public void setMainRadioButton(JRadioButton mainRadioButton) {
        this.mainRadioButton = mainRadioButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public RowDataPanel(String content, String text)
    {
        this.content = content;
        Border panelBorder = BorderFactory.createTitledBorder("");
        this.setBorder(panelBorder);
        //set name of radio button
        
            mainRadioButton.addActionListener(this);
            mainRadioButton.setActionCommand("Radio");       
        this.add(mainRadioButton); 
        if (content.equals("Reference One")|| content.equals("Reference Two"))
        {        
            this.textBox = new JTextArea(text);
            textBox.setEditable(false);
            this.add(textBox);
        }
        else
        {
            mainRadioButton.setText(text);
            
        }
        //set action listener to edit button and delete button
        editButton.addActionListener(this);
        editButton.setActionCommand("Edit");
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
        //set box layout
               
        this.add(Box.createRigidArea(new Dimension(10, 50)));
        this.add(editButton);
        this.add(Box.createRigidArea(new Dimension(5, 50)));
        this.add(deleteButton);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Radio":
                if (!content.equals("Reference One")&& !content.equals("Reference Two"))
                {
                    this.selectedText = mainRadioButton.getText();
                }
                else
                {
                    this.selectedText = textBox.getText();

                }
                break;
            case "Delete":
                if (!content.equals("Reference One")&& !content.equals("Reference Two"))
                {
                    User.getInstance().deleteInfo(this.content, mainRadioButton.getText());                
                }
                else
                {
                    User.getInstance().deleteInfo(this.content, textBox.getText());  
                }

                Container panel =this.getParent();
                panel.remove(this);
                panel.revalidate();
                panel.repaint();
                break;
            case "Edit":
                if (!content.equals("Reference One")&& !content.equals("Reference Two"))
                {
                    String value = JOptionPane.showInputDialog(null, "Enter New Text", mainRadioButton.getText());
                    if (value!=null)
                    {
                        User.getInstance().editInfo(this.content,  mainRadioButton.getText(),value);
                        mainRadioButton.setText(value);
                    }
                }
                else
                {
                    EditRefereeDialog dialogBox = new EditRefereeDialog(this.textBox, content);
                    
                }
                
                break; 
        }
    }

}
