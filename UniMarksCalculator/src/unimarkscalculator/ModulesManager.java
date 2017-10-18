/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unimarkscalculator;

import java.util.ArrayList;

/**
 *
 * @author xxx
 */
public class ModulesManager 
{
    private static ModulesManager theManager;
    private String description;
    private ArrayList<Module> allUserModules;
    
    private ModulesManager()
    {
        this.description = "MODULES MANAGER";
        allUserModules = new ArrayList<Module>();
    }
    
    public static ModulesManager getInstance()
    {
        if(theManager == null)
        {
            theManager = new ModulesManager();
        }
        return theManager;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    public void addModule(String newYear, String newName, String newSemester, int newCredits)
    {
        Module tempModule = new Module(newYear, newName, newSemester, newCredits);
        allUserModules.add(tempModule);
    }
    
    public void removeModule(String name)
    {
        for(Module temp : allUserModules)
        {
            if(temp.getName().equals(name))
            {
                allUserModules.remove(temp);
                System.out.println("REMOVED");
            }
        }
    }
    
    public String getAllModules()
    {
        String s = "";
        for(Module temp : allUserModules)
        {
            s = s + temp.toString() + "\n";
        }
        return s;
    }
}