package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
            
public class EmployeeFileReader {
    private static List<EmployeeData> employees = new ArrayList<>();
    
    public static void main(String[] args){
        String fileName = ("C:\\Users\\MACKY\\Documents\\NetBeansProjects\\MotortPH System\\src\\MainPackage\\EmployeeListData.txt");

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");
                
                if (data.length != 19) {
                    System.out.println("Invalid number of fields for employee " + data[0].trim() + ": expected 19, found " + data.length);
                    continue;
                }
                
                try {
                    EmployeeData employee = new EmployeeData(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim(), data[9].trim(), data[10].trim(), data[11].trim(), data[12].trim(),
                            Double.parseDouble(data[13].trim()), Double.parseDouble(data[14].trim()), Double.parseDouble(data[15].trim()), Double.parseDouble(data[16].trim()), Double.parseDouble(data[17].trim()), Double.parseDouble(data[18].trim()));

                    employees.add(employee);
                } catch (NumberFormatException e) {
                    // Ignore invalid number formats and continue to the next line
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<EmployeeData> getEmployees() {
        return employees;
    }
}

