package unimarkscalculator.mainClasses;

import java.util.*;

/**
 *
 * @author Lukasz Bol
 */
public class Module 
{
    private String level;
    private String name;
    private String semester;
    private int credits;
    private double grade;
    private double totalAssignmentsWeight;
    private ArrayList<Assignment> listAssignments; 
    
    public Module(String newLevel, String newName, String newSemester, int newCredits)
    {
        this.level = newLevel;
        this.name = newName;
        this.semester = newSemester;
        this.credits = newCredits;
        this.totalAssignmentsWeight = 0;
        listAssignments = new ArrayList<Assignment>();
    }
    
    public void addAssignment(String name, String type, double result, double weight)
    {
        double newTotalWeight = getTotalAssignmentsWeight() + weight;
        setTotalAssignmentsWeight(newTotalWeight);
        Assignment tempAssignment = new Assignment(name, type, result, weight);
        listAssignments.add(tempAssignment);
    }
    
    public void removeAssignment(String nameOfAssignmentToBeRemoved)
    {
        for(Assignment tempAssignment : listAssignments)
        {
            if((tempAssignment.getTitle()).equals(nameOfAssignmentToBeRemoved))
            {
                double newTotalWeight = getTotalAssignmentsWeight() - tempAssignment.getWeightPercent();
                setTotalAssignmentsWeight(newTotalWeight);
                listAssignments.remove(tempAssignment);
                break;
            }
        }
    }
    
    public void updateAssignment(String oldTitle, String newTitle, String newType, double newResult, double newWeight)
    {
        for(Assignment tempAssignment : listAssignments)
        {
            if((tempAssignment.getTitle()).equals(oldTitle))
            {
                double newTotalWeight = (getTotalAssignmentsWeight() - tempAssignment.getWeightPercent()) + newWeight;
                setTotalAssignmentsWeight(newTotalWeight);
                tempAssignment.setTitle(newTitle);
                tempAssignment.setType(newType);
                tempAssignment.setResult(newResult);
                tempAssignment.setWeightPercentage(newWeight);
                break;
            }
        }
    }
    
    public String listAllAssignments()
    {
        String existingAssignmentsInfo = "";
        if(!listAssignments.isEmpty())
        {
            for(Assignment tempAssignment : listAssignments)
            {
                existingAssignmentsInfo = existingAssignmentsInfo + tempAssignment.toString() + "\n";
            }
        }
        return existingAssignmentsInfo;
    }
    
    public Assignment getAssignment(String nameOfassignmentToBeRetrieved)
    {
        Assignment returnedAssignment = null;
        for(Assignment tempAssignment : listAssignments)
        {
            if((tempAssignment.getTitle()).equals(nameOfassignmentToBeRetrieved))
            {
                return returnedAssignment = tempAssignment;
            }
        }
        return returnedAssignment;
    }
    
    public ArrayList<Assignment> getAllAssignments()
    {
        return listAssignments;
    }
    
    public void calculateAndSetGrade()
    {
        ArrayList<Assignment> currentAssignments = getAllAssignments();
        double newResult = 0;
        for(Assignment tempAssignment : currentAssignments)
        {
            newResult = newResult + (tempAssignment.getResult() * (tempAssignment.getWeightPercent() * 0.01));
        }       
        setGrade(newResult);
    }

    public String getLevel() 
    {
        return level;
    }

    public String getSemester() 
    {
        return semester;
    }

    public int getCredits() 
    {
        return credits;
    }

    public void setLevel(String level) 
    {
        this.level = level;
    }

    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public void setCredits(int newCredits) 
    {
        this.credits = newCredits;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String newName) 
    {
        this.name = newName;
    }

    public double getGrade() 
    {
        return grade;
    }

    public void setGrade(double newGrade) 
    {
        this.grade = newGrade;
    }
    
    public void updateModuleInfo(String newLevel, String newName, String newSemester, int newCredits)
    {
        setLevel(newLevel);
        setName(newName);
        setSemester(newSemester);
        setCredits(newCredits);
    }
    
    public boolean checkAssignmentExists(String assignmentName)
    {
        boolean assignmentExists = false;
        for(Assignment tempAssignment : listAssignments)
        {
            if(((tempAssignment.getTitle()).toLowerCase()).equals(assignmentName.toLowerCase()))
            {
                assignmentExists = true;
                break;
            }
        }
        return assignmentExists;
    }

    public double getTotalAssignmentsWeight() 
    {
        return totalAssignmentsWeight;
    }

    public void setTotalAssignmentsWeight(double newTotalAssignmentsWeight) 
    {
        this.totalAssignmentsWeight = newTotalAssignmentsWeight;
    }
    
    public String toString()
    {
        String moduleInfo = "***** MODULE INFO *****" + 
                   "\nModule: " + name + 
                   "\nLevel: " + level + 
                   "\nSemester: " + semester + 
                   "\nCredits: " + credits + 
                   "\nGrade: " + grade;
        for(Assignment tempAssignment : listAssignments)
        {
            moduleInfo = moduleInfo + "\nAssignment: " + tempAssignment.toString();
        }
        return moduleInfo;
    }
}