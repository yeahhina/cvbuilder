package cvbuilder.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import cvbuilder.model.User;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 *
 * @author hinay
 */
public class DataPanel extends JPanel implements ActionListener{
    private String name;
    private JScrollPane scrollPane = new JScrollPane(this);
    private JCheckBox includeBox;
    private List<RowDataPanel> rows = new ArrayList<>();

    public List<RowDataPanel> getRows() {
        return rows;
    }

    public void setRows(List<RowDataPanel> rows) {
        this.rows = rows;
    }
  

    public JCheckBox getIncludeBox() {
        return includeBox;
    }

    public void setIncludeBox(JCheckBox includeBox) {
        this.includeBox = includeBox;
    }
    
    ButtonGroup bg = new ButtonGroup();
    private ArrayList<RowDataPanel> rowPanels = new ArrayList();


    public DataPanel(String content)
    {        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(900,800));
        this.setAutoscrolls(true);
        this.scrollPane.setPreferredSize(new Dimension(100,100));
        JPanel includePanel = new JPanel();
        this.includeBox = new JCheckBox("Include");
        includeBox.addActionListener(this);
        includeBox.setActionCommand("Include");
        includePanel.add(includeBox);
        this.add(includePanel);
        switch (content) {
            case "Title":
                for (String text : User.getInstance().getTitles())
                {
                    RowDataPanel panel = new RowDataPanel("Title", text);
                    this.add(panel);
                    this.rows.add(panel);
                }
                AddRowPanel rowPanelTitle = new AddRowPanel(content);
                this.add(rowPanelTitle);
                break;
            case "Name":
                for (String text : User.getInstance().getNames())
                {
                    RowDataPanel panel = new RowDataPanel("Name", text);
                    this.add(panel);
                    this.rows.add(panel);
                }
                AddRowPanel rowPanelName = new AddRowPanel(content);
                this.add(rowPanelName);
                break;
            case "Email":
                for (String text : User.getInstance().getEmails())
                {
                    RowDataPanel panel = new RowDataPanel("Email",text);
                    this.add(panel);
                    this.rows.add(panel);
                }
                AddRowPanel rowPanelEmail = new AddRowPanel(content);
                this.add(rowPanelEmail);
                break;
            case "Reference One":
                for (String text : User.getInstance().getReferenceOne())
                {
                    RowDataPanel panel = new RowDataPanel("Reference One",text);
                    this.add(panel);
                    this.rows.add(panel);
                }
                AddRowPanel rowPanelReferenceOne = new AddRowPanel(content);
                this.add(rowPanelReferenceOne);
                break;
            case "Reference Two":
                for (String text : User.getInstance().getReferenceTwo())
                {
                    RowDataPanel panel = new RowDataPanel("Reference Two",text);
                    this.add(panel);
                    this.rows.add(panel);
                }
                AddRowPanel rowPanelReferenceTwo  = new AddRowPanel(content);
                this.add(rowPanelReferenceTwo);
                break;
            default:
                break;
        }
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public ArrayList<RowDataPanel> getRowDataPanels() {
        return rowPanels;
    }

    public void setRowDataPanels(ArrayList<RowDataPanel> rowPanels) {
        this.rowPanels = rowPanels;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBorder(String title)
    {
        Border panelBorder = BorderFactory.createTitledBorder(title);
        this.setBorder(panelBorder);
    }

    public Component add(Component comp) {
        if (comp instanceof RowDataPanel)
        {
            RowDataPanel row = (RowDataPanel) comp;
            rowPanels.add(row);
            bg.add(row.getMainRadioButton());
        }
        return super.add(comp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    
    
}
