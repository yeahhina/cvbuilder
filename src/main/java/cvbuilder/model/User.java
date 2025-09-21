/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder.model;

import cvbuilder.view.MainViewer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author k2321719
 */
public class User {
    //set up attributes of class    
    private List<String> names = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private List<String> referenceOne = new ArrayList<>();
    String newLine = "%%%%";
    String comma = "////";
    private List<String> referenceTwo = new ArrayList<>();
    private String userName;
    public List<String> getReferenceOne() {
        return referenceOne;
    }

    public void setReferenceOne(List<String> referenceOne) {
        this.referenceOne = referenceOne;
    }

    public List<String> getReferenceTwo() {
        return referenceTwo;
    }

    public void setReferenceTwo(List<String> referenceTwo) {
        this.referenceTwo = referenceTwo;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
     public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getEmails() {
        return emails;
    }
    
    public void deleteInfo(String content, String value)
    {
        if ("Title".equals(content))
        {
            int index = this.titles.indexOf(value);
            this.titles.remove(index);
        }
        else if ("Name".equals(content))
        {
            int index = this.names.indexOf(value);
            this.names.remove(index);
        }
        else if("Email".equals(content))
        {
            int index = this.emails.indexOf(value);
            this.emails.remove(index);  
        }
        else if("Reference One".equals(content))
        {
            int index = this.referenceOne.indexOf(value);
            this.referenceOne.remove(index);  
        }
        else if("Reference Two".equals(content))
        {
            int index = this.referenceTwo.indexOf(value);           
            this.referenceTwo.remove(index);  

        }
    }
    public void editInfo(String content, String oldValue, String newValue)
    {
        if (content=="Title")
        {
            int index = this.titles.indexOf(oldValue);
            this.titles.set(index, newValue);
        }
        if (content=="Name")
        {
            int index = this.names.indexOf(oldValue);
            this.names.set(index,newValue);
        }
        if (content=="Email")
        {
            int index = this.emails.indexOf(oldValue);
            this.emails.set(index,newValue);  
        }
        if (content=="Reference One")
        {
            int index = this.referenceOne.indexOf(oldValue);
            this.referenceOne.set(index,newValue); 

            
        } 
        if (content=="Reference Two")
        {
            int index = this.referenceTwo.indexOf(oldValue);
            this.referenceTwo.set(index,newValue);  
        } 
    }
    public void addInfo(String content, String value)
    {
        if (content=="Title")
        {
            this.titles.add(value);
        }
        if (content=="Name")
        {
            this.names.add(value);
        }
        if (content=="Email")
        {
            this.emails.add(value);
        }
        if (content=="Reference One")
        {
            this.referenceOne.add(value);
        }
        if (content=="Reference Two")
        {
            this.referenceTwo.add(value);
                        
        }
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    public void readCSV(String filename)
    {
        try
        (
                BufferedReader br = new BufferedReader (new FileReader(filename));
        )
        {
            this.userName= "";
            this.names.clear();
            this.titles.clear();
            this.emails.clear();
            this.referenceOne.clear();
            this.referenceTwo.clear();
            while (br.ready())
            {
                String info = br.readLine();
                String[] values = info.split(",");
                //if statements to check if the line is about names, usernames or titles etc
                if (values[0].equals("User"))
                {
                    if (values[1].equals("Title"))
                    {
                        //convert array to arraylist
                        List<String> listValues = new ArrayList<>(Arrays.asList(values));
                        //remove first element
                        listValues.remove(0);
                        listValues.remove(0);
                        //save array in class
                        this.titles = listValues;
                    }
                    if (values[1].equals("Name"))
                    {
                        //convert array to arraylist
                        List<String> listValues = new ArrayList<>(Arrays.asList(values));
                        //remove first element
                        listValues.remove(0);
                        listValues.remove(0);
                        //save array in class
                        this.names = listValues;
                    }
                    if (values[1].equals("Email"))
                    {
                        //convert array to arraylist
                        List<String> listValues = new ArrayList<>(Arrays.asList(values));
                        //remove first element
                        listValues.remove(0);
                        listValues.remove(0);
                        //save array in class
                        this.emails = listValues;
                    }    
                }
                else if (values[0].equals("References"))
                {
                    if (values[1].equals("Referee 1"))
                    {
                        //convert array to arraylist
                        List<String> listValues = new ArrayList<>(Arrays.asList(values));
                        //remove first element
                        listValues.remove(0);
                        listValues.remove(0);
                        for (String rawValue : listValues)
                        {
                            String value = rawValue.replaceAll(newLine, System.lineSeparator()).replaceAll(comma, ",");
                            this.referenceOne.add(value);
                            
                        }
                    }
                    if (values[1].equals("Referee 2"))
                    {
                        //convert array to arraylist
                        List<String> listValues = new ArrayList<>(Arrays.asList(values));
                        //remove first element
                        listValues.remove(0);
                        listValues.remove(0);
                        for (String rawValue : listValues)
                        {
                            String value = rawValue.replaceAll(newLine, System.lineSeparator()).replaceAll(comma, ",");
                            this.referenceTwo.add(value);
                            
                        }
                    }
                }
            
            }
        }       
        catch (Exception e)
        {
        } 
    }
    public void createCSV(String filename)
    {
        try
            (
                BufferedWriter wr = new BufferedWriter (new FileWriter(filename))
            )
        {
            wr.write("User,Title,"+this.titles.toString().replace("[","").replace("]", ""));
            wr.newLine();
            wr.write("User,Name,"+this.names.toString().replace("[","").replace("]", ""));
            wr.newLine();
            wr.write("User,Email,"+this.emails.toString().replace("[","").replace("]", ""));
            wr.newLine();
            List<String> referenceOneCopy = new ArrayList<>(referenceOne);
            for (int i=0;i<referenceOneCopy.size();i++)
            {
                String reference = referenceOneCopy.get(i);
                String value = reference.replaceAll(",", comma);              
                value = value.replaceAll("\\R", newLine);
                referenceOneCopy.set(i,value);
            }
            wr.write("References,Referee 1,"+referenceOneCopy.toString().replace("[","").replace("]", ""));
            wr.newLine();
            List<String> referenceTwoCopy = new ArrayList<>(referenceTwo);
            for (int i=0;i<referenceTwoCopy.size();i++)
            {
                String reference = referenceTwoCopy.get(i);
                String value = reference.replaceAll(",", comma);
                value = value.replaceAll("\\R", newLine);
                referenceTwoCopy.set(i,value);
            }
            wr.write("References,Referee 2,"+referenceTwoCopy.toString().replace("[","").replace("]",""));
            wr.newLine();
        }
        catch (Exception e)
         {
             System.out.println(e);
         }
    } 
    public void createCSVForCV(String filename)
    {
        try
            (
                BufferedWriter wr = new BufferedWriter (new FileWriter(filename))
            )
        {
            wr.write(MainViewer.getInstance().getStringOfSelectedPanels());
        }
        catch (Exception e)
         {
             System.out.println(e);
         }
    } 
    //set up singleton pattern for class
    private static User instance;    
    public static User getInstance()
    {
        if (instance==null)
        {
            instance = new User();
        }
        return instance;
    }
    
    
}
