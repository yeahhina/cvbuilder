/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author hinay
 */
public class MainViewer extends JFrame{
    
    private static MainViewer instance;
    private List<DataPanel> panels = new ArrayList<>();
    public static MainViewer getInstance()
    {
        if (instance==null)
        {
            instance = new MainViewer();
        }
        return instance;
    }
    public MainViewer()
    { 
        this.setTitle("CvBuilder");
        this.setSize(900,800);     
        this.setLayout(new BorderLayout());    
        this.setWindowElements();          
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void setWindowElements()
    {
        //add menu bar
        this.add(new CVMenuBar(), BorderLayout.NORTH);
        //vreate user tab
        MainTab userTabPanel = new MainTab();
        //create panels for main tab
        DataPanel mainUserTitlePanel = new DataPanel("Title");
        DataPanel mainUserNamePanel = new DataPanel("Name");
        DataPanel mainUserEmailPanel = new DataPanel("Email");
        //add tabs and panels
        userTabPanel.add("Title", mainUserTitlePanel);
        userTabPanel.add("Name", mainUserNamePanel);
        userTabPanel.add("Email", mainUserEmailPanel);
        // set up second tab
        MainTab refereeTabPanel = new MainTab();
        DataPanel referenceOne = new DataPanel("Reference One");
        DataPanel referenceTwo = new DataPanel("Reference Two");
        refereeTabPanel.add("Referee 1",referenceOne);
        refereeTabPanel.add("Referee 2",referenceTwo);
        //set up main tab
        MainTab mainUpperTab = new MainTab();
        mainUpperTab.add("User", userTabPanel);
        mainUpperTab.add("Reference",refereeTabPanel);
        this.add(mainUpperTab);
        NavigationPanel navPanel = new NavigationPanel(mainUpperTab);
        this.add(navPanel, BorderLayout.SOUTH);
        //set up array list
        panels.add(mainUserTitlePanel);
        panels.add(mainUserNamePanel);
        panels.add(mainUserEmailPanel);
        panels.add(referenceOne);
        panels.add(referenceTwo);




    } 
    public void reloadComponents() {
        panels.clear();
        this.getContentPane().removeAll();
        this.setWindowElements(); 
        this.revalidate();
        this.repaint();
}

    public List<DataPanel> getPanels() {
        return panels;
    }

    public void setPanels(List<DataPanel> panels) {
        this.panels = panels;
    }
    public String getStringOfSelectedPanels()
    {
        String cvData = "";
        for (DataPanel panel: MainViewer.getInstance().getPanels())
        {
            if (panel.getIncludeBox().isSelected())
            {
                for (RowDataPanel rowPanel : panel.getRows())
                {
                    if (rowPanel.getMainRadioButton().isSelected())
                    {
                        if (rowPanel.getSelectedText()!=null)
                        {
                            cvData+=rowPanel.getContent()+":";
                            if (rowPanel.getContent()=="Reference One" || rowPanel.getContent()=="Reference Two")
                            {
                                cvData+=System.lineSeparator();
                                
                            }
                            
                            cvData+= rowPanel.getSelectedText();
                            cvData+= System.lineSeparator();
                        }                        
                    }

                }
            }
        }
        return (cvData);
    }

}
