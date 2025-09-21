/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author hinay
 */
public class NavigationPanel extends JPanel implements ActionListener{
    JButton prevSectionButton = new JButton ("Prev Section");
    JButton nextSectionButton = new JButton("Next Section");
    JButton displayCvButton = new JButton("Display CV");
    MainTab mainUpperTab;
    MainTab userTab;
    MainTab referenceTab;
   
    public NavigationPanel (MainTab mainUpperTab)
    {
        prevSectionButton.addActionListener(this);
        prevSectionButton.setActionCommand("Prev");
        this.add(prevSectionButton);
        displayCvButton.addActionListener(this);
        displayCvButton.setActionCommand("DisplayCV");
        this.add(displayCvButton);
        nextSectionButton.addActionListener(this);
        nextSectionButton.setActionCommand("Next");
        this.add(nextSectionButton);
        this.mainUpperTab = mainUpperTab;
        Component componentUserTab = mainUpperTab.getComponentAt(0);
        userTab = (MainTab) componentUserTab;
        Component componentReferenceTab = mainUpperTab.getComponentAt(1);
        referenceTab = (MainTab) componentReferenceTab;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Prev")
        {
            if (mainUpperTab.getSelectedIndex()==0)
            {
               int index =  userTab.getSelectedIndex();
               if (index>0)
               {
                   userTab.setSelectedIndex(index-1);
               }
            }
            else
            {
                int index = referenceTab.getSelectedIndex();
                if (index==1)
                {
                    referenceTab.setSelectedIndex(0);
                }
            }
        }
        else if (e.getActionCommand()=="Next")
        {
            if (mainUpperTab.getSelectedIndex()==0)
            {
               int index =  userTab.getSelectedIndex();
               if (index<2)
               {
                   userTab.setSelectedIndex(index+1);
               }
            }
            else
            {
                int index = referenceTab.getSelectedIndex();
                if (index==0)
                {
                    referenceTab.setSelectedIndex(1);
                }
            } 
        }
        else
        {
            String CVText = MainViewer.getInstance().getStringOfSelectedPanels();
            DisplayCVDialog dialogBox = new DisplayCVDialog(CVText);
        }
        
    }
    
}
