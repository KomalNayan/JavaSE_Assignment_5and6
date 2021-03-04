package com.komalnayangalla_c0779428_a56;


import javax.swing.*;

class Program{
    String firstName;
    String lastName;
    int packageB = 150;
    int packageA = 100;
    int hoursTaken;
    float servicesCost;
    float optionsCost;
    float itemsCost;
    float storageSmall = 8.0f;
    float storageLarge = 20.11f;
    float boxSmall = 2.50f;
    float boxLarge = 4.50f;
    int nSmallBoxes;
    int nLargeBoxes;
    char pkg;
    float totalCost;

    Program()
    {
        firstName = "Portgas D.";
        lastName = "Ace";
        hoursTaken = 24;
        pkg = 'A';
        nSmallBoxes = 10;
        nLargeBoxes = 10;
    }

    Program(String firstName, String lastName,int hoursTaken, char pkg, int nLargeBoxes, int nSmallBoxes)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setHoursTaken(hoursTaken);
        setnLargeBoxes(nLargeBoxes);
        setPkg(pkg);
        setnSmallBoxes(nSmallBoxes);
    }

    public float getItemsCost() {
        itemsCost = boxSmall * nSmallBoxes + boxLarge * nLargeBoxes;
        return itemsCost;
    }

    public float getOptionsCost() {
        optionsCost = (storageSmall + storageLarge) * hoursTaken/24;
        return optionsCost;
    }

    public float getServicesCost() {
        if(pkg == 'A')
            servicesCost = packageA * hoursTaken;
        if(pkg == 'B')
            servicesCost = packageB * hoursTaken;
        return servicesCost;
    }

    public float getTotalCost() {
        totalCost = getServicesCost() + getItemsCost() + getOptionsCost();
        return totalCost;
    }

    public void setHoursTaken(int hoursTaken) {
        this.hoursTaken = hoursTaken;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setnSmallBoxes(int nSmallBoxes) {
        this.nSmallBoxes = nSmallBoxes;
    }

    public void setnLargeBoxes(int nLargeBoxes) {
        this.nLargeBoxes = nLargeBoxes;
    }

    public void setPkg(char pkg) {
        this.pkg = pkg;
    }

    public String getInfo()
    {
        String s = "Customer Name : "+firstName+" "+lastName;
        s += "\n\nServices Cost : "+getServicesCost();
        s += "\nOptions Cost : "+getOptionsCost();
        s += "\nItems Cost : "+getItemsCost();
        s += "\n\nTotal Cost : "+getTotalCost();

        return  s;
    }



}

public class Main {

    public static void main(String[] args) {
	    String userName = "WillMovers";
	    String password = "born2beFree";
	    int tries = 1;
        String un = JOptionPane.showInputDialog("Enter Username :");
        String pass = JOptionPane.showInputDialog("Enter Password :");
        while( !(un.equals(userName) && pass.equals(password)) && tries < 3)
        {
            tries++;
            JOptionPane.showMessageDialog(null,"Incorrect Credentials!\nEnter Again..");
            un = JOptionPane.showInputDialog("Enter Username :");
            pass = JOptionPane.showInputDialog("Enter Password :");
        }
        if(tries >= 3)
        {
            JOptionPane.showMessageDialog(null,"You've exceeded your tries\nGood Bye!");
            System.exit(1);
        }

        try {
            String firstName = JOptionPane.showInputDialog("Enter the Customer's First Name : ");
            String lastName = JOptionPane.showInputDialog("Enter the Customer's Last Name : ");
            char pkg = Character.toUpperCase(JOptionPane.showInputDialog("Enter the package selected (A or B): \n").charAt(0));
            if(pkg!='A' && pkg!= 'B')
                throw new Exception();
            int hoursTaken = Integer.parseInt(JOptionPane.showInputDialog("Enter the hours taken : \n"));
            int nSmallBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of small boxes : \n"));
            int nLargeBoxes = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of large boxes : \n"));
            Program p = new Program(firstName,lastName,hoursTaken,pkg,nLargeBoxes,nSmallBoxes);
            JOptionPane.showMessageDialog(null,p.getInfo());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Entered wrong type of input\nRetry after Logging In!");
            main(args);
        }
    }
}
