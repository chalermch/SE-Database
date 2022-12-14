import java.text.SimpleDateFormat;
import java.util.Date;

import database.DatabaseHandler;
import model.Employee;
import model.EmployeeTable;
import model.Menu;
import model.MenuTable;
import model.SaleOrder;
import model.SaleOrderTable;
import model.Timestamp;
import model.TimestampTable;

public class App {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        String[] date = {"2013-07-22 15:35:07","2013-07-23 15:35:07"};
        Date logIn = dt.parse(date[0]);
        Date logOut = dt.parse(date[1]);
    
        DatabaseHandler dbHandler = new DatabaseHandler();
        //Employee emp = new Employee(2,"John", "Merry", "111", 12, "144/12", "0955049358", "work", 1);
        //EmployeeTable.insertEmployee(dbHandler, emp);
       // Menu menu = new Menu(2, "hee", 1500);
       // MenuTable.insertMenu(dbHandler, menu);
        SaleOrder order = new SaleOrder(1,10,15000,"work", 2, 2, logIn);
        SaleOrderTable.insertOrder(dbHandler, order);

        /*SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        String[] date = {"2013-07-22 15:35:07","2013-07-23 15:35:07"};
        Date logIn = dt.parse(date[0]);
        Date logOut = dt.parse(date[1]);
        System.out.println(logIn);
*/
        //Timestamp time = new Timestamp(2, logIn, logOut);
        //TimestampTable.insertTimestamp(dbHandler, time);
        
    }
}
