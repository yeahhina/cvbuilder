/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import cvbuilder.model.User;
import java.awt.BorderLayout;
import static java.awt.SystemColor.text;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hinay
 */
public class DisplayCVDialog extends JDialog implements ActionListener
{
    JPanel panel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel label = new JLabel("CV:");
    JTextArea textBox = new JTextArea(10,20);    
    String content;
    public DisplayCVDialog(String cvData)
    {
        this.textBox.setText(cvData);
        this.textBox.setEditable(false);
        this.setPanel();
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("Display CV");
       
    }
    public void setPanel()
    {
        this.buttonPanel.setLayout(new BorderLayout());
        //set up button panel
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("Save");
        JButton printButton = new JButton("Print");
        printButton.addActionListener(this);
        printButton.setActionCommand("Print");
        JButton copyButton = new JButton("Copy/Paste");
        copyButton.addActionListener(this);
        copyButton.setActionCommand("Copy");
        this.buttonPanel.add(saveButton, BorderLayout.NORTH);
        this.buttonPanel.add(printButton,BorderLayout.CENTER);
        this.buttonPanel.add(copyButton,BorderLayout.SOUTH);
        //set up main panel
        this.panel.setLayout(new BorderLayout());
        this.panel.add(label,BorderLayout.NORTH);
        this.panel.add(textBox,BorderLayout.CENTER);
        this.panel.add(buttonPanel,BorderLayout.SOUTH);
        this.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Save")
        {
            JFileChooser fileChooserSaveCV = new JFileChooser();
            FileNameExtensionFilter filterSaveCV = new FileNameExtensionFilter("CSV Files", "csv");
            fileChooserSaveCV.setFileFilter(filterSaveCV);
            int returnValueSaveCV = fileChooserSaveCV.showSaveDialog(null);
            if (returnValueSaveCV == JFileChooser.APPROVE_OPTION)
            {
                System.out.println("You chose to open this file: "+ fileChooserSaveCV.getSelectedFile().getName());
                User.getInstance().createCSVForCV(fileChooserSaveCV.getSelectedFile().getName());
            }
        }
        if (e.getActionCommand()=="Print")
        {
            System.out.println(this.textBox.getText());
        }
        if (e.getActionCommand()=="Copy")
        {
            Clipboard clipboard = getSystemClipboard();
            clipboard.setContents(new StringSelection(this.textBox.getText()), null);
        }
    }

    private Clipboard getSystemClipboard() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        return defaultToolkit.getSystemClipboard();    }
    
}
