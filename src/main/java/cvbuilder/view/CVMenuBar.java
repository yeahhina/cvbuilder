/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;


import cvbuilder.model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author hinay
 */
public class CVMenuBar extends JMenuBar implements ActionListener {
    
    private JMenu fileMenu;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem saveCustomCVFile;
    JMenuItem quit;

    public CVMenuBar() 
    {
        //creates open file menu to bar
        fileMenu = new JMenu("Open File...");
        //creates open file option and sets up button
        openFile = new JMenuItem("Open File...");
        openFile.addActionListener(this);
        openFile.setActionCommand("OpenFile");
        //create save file option and set it up
        saveFile = new JMenuItem("Save");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("Save");
        saveCustomCVFile = new JMenuItem("Save Custom CV");
        saveCustomCVFile.addActionListener(this);
        saveCustomCVFile.setActionCommand("SaveCustomCV");
        //creates quit option
        quit = new JMenuItem("Quit");
        quit.addActionListener(this);
        quit.setActionCommand("Quit");
        // adds options to bar
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveCustomCVFile);
        fileMenu.add(quit);
        //add bar to window
        this.add(fileMenu);
    }
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "OpenFile":
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    System.out.println("You chose to open this file: "+ fileChooser.getSelectedFile().getName());
                    User.getInstance().readCSV(fileChooser.getSelectedFile().getName());
                    MainViewer.getInstance().reloadComponents(); 
                }
                break;
            case "Save":
                JFileChooser fileChooserSave = new JFileChooser();
                FileNameExtensionFilter filterSave = new FileNameExtensionFilter("CSV Files", "csv");
                fileChooserSave.setFileFilter(filterSave);
                int returnValueSave = fileChooserSave.showSaveDialog(null);
                if (returnValueSave == JFileChooser.APPROVE_OPTION)
                {
                    System.out.println("You chose to open this file: "+ fileChooserSave.getSelectedFile().getName());
                    User.getInstance().createCSV(fileChooserSave.getSelectedFile().getName());
                }
                break;
            case "SaveCustomCV":
                JFileChooser fileChooserSaveCV = new JFileChooser();
                FileNameExtensionFilter filterSaveCV = new FileNameExtensionFilter("CSV Files", "csv");
                fileChooserSaveCV.setFileFilter(filterSaveCV);
                int returnValueSaveCV = fileChooserSaveCV.showSaveDialog(null);
                if (returnValueSaveCV == JFileChooser.APPROVE_OPTION)
                {
                    System.out.println("You chose to open this file: "+ fileChooserSaveCV.getSelectedFile().getName());
                    User.getInstance().createCSVForCV(fileChooserSaveCV.getSelectedFile().getName());
                }
                break;
            case "Quit":
            {
                //this is causing it to close
                MainViewer.getInstance().dispose();
            }
        }
    }
    
}
