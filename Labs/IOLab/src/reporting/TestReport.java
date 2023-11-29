/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import data.DataSource;
import domain.*;
import java.io.IOException;

/**
 *
 * @author alexa
 */
public class TestReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Bank myBank = Bank.getBank();
        
        if (args.length!=1)
        {
            System.out.println("USAGE: java TestReport <dataFilePath>");
            System.exit(0);
        }
        String dataFilePath=args[0];
        
        try {
            System.out.println("Reading data file: "+dataFilePath);
            DataSource datasource = new DataSource(dataFilePath);
            datasource.loadData();
            
            System.out.println(myBank);
        }
        catch (IOException ioe)
        {
            System.out.println("Could not load the data file...");
            System.out.println(ioe.getMessage());
//            ioe.printStackTrace(System.err);
        }
        
       
        

    }

}
