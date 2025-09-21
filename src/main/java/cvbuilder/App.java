/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvbuilder;

import cvbuilder.model.User;
import cvbuilder.view.MainViewer;

/**
 *
 * @author hinay
 */
public class App {
    public static void main (String[] args)
    {
        User.getInstance().readCSV("user.csv");
        MainViewer.getInstance();
    }
    
}
