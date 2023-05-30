package hust.soict.dsai.lab01;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class NumberOfDays {
	static boolean checkValidYear(String strYear) {
		try {
			int year = Integer.parseInt(strYear);
			if (year < 0) {
				return(false);
			}
			else {
				return(true);
			}
		}
		catch (Exception e){
			return(false);
		}
	}
	
	static boolean checkLeapYear(Integer year) {
		if ((year % 100) != 0) {
			if ((year % 4) == 0) {
				return(true);
			}
			else {
				return(false);
			}
		}
		else {
			if ((year % 400) == 0) {
				return(true);
			}
			else {
				return(false);
			}
		}
	}
	
	static int DaysOfMonth(Integer month, Boolean leap) {
		
		switch(month) {
			case 1:
				return(31);
			case 2:
				if(leap = true) {
					return(29);
				}
				else {
					return(28);
				}
			case 3:
				return(31);
			case 4:
				return(30);
			case 5:
				return(31);
			case 6:
				return(30);
			case 7:
				return(31);
			case 8:
				return(31);
			case 9:
				return(30);
			case 10:
				return(31);
			case 11:
				return(30);
			case 12:
				return(31);
			default:
				return(0);
		}
	}
	public static void main(String[] args) {
        String strMonth, strYear;
        Integer month = 0, year, daysOfMonth;
        Boolean check = false;
        String strNotification = "";

        strMonth = JOptionPane.showInputDialog(null, "Please input the month (in full name, abbreviation, in 3 letters, or in number):","Input month", JOptionPane.INFORMATION_MESSAGE);
        
        String month_name[] = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String month_abb[] = new String[] {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        String month_3lt[] = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String month_num[] = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        
        
        while (check == false) {
	        if (Arrays.asList(month_name).contains(strMonth)) {
	        	check = true;
	        	month = Arrays.asList(month_name).indexOf(strMonth) + 1;
	        	continue;
	        }
	        else if (Arrays.asList(month_abb).contains(strMonth)) {
	        	check = true;
	        	month = Arrays.asList(month_abb).indexOf(strMonth) + 1;
	        	continue;
	        }
	        else if (Arrays.asList(month_3lt).contains(strMonth)) {
	        	check = true;
	        	month = Arrays.asList(month_3lt).indexOf(strMonth) + 1;
	        	continue;
	        }
	        else if (Arrays.asList(month_num).contains(strMonth)) {
	        	check = true;
	        	month = Arrays.asList(month_num).indexOf(strMonth) + 1;
	        	continue;
	        }
	        strMonth = JOptionPane.showInputDialog(null, "INVALID. \nPlease input the month (in full name, abbreviation, in 3 letters, or in number):","Input month", JOptionPane.INFORMATION_MESSAGE);
        }
                
        strYear = JOptionPane.showInputDialog(null, "Please input the year (in full digits):","Input year", JOptionPane.INFORMATION_MESSAGE);
        
        check = checkValidYear(strYear);
        
        while(check == false) {
        	strYear = JOptionPane.showInputDialog(null, "INVALID. Year must be a non-negative integer. \nPlease input the year (in full digits):","Input year", JOptionPane.INFORMATION_MESSAGE);
        	check = checkValidYear(strYear);
        }
        	
        year = Integer.parseInt(strYear);
        
        daysOfMonth = DaysOfMonth(month, checkLeapYear(year));
        
        strNotification = "The number of days in month " + strMonth + " of year " + Integer.toString(year) + " is: " + Integer.toString(daysOfMonth);
        
        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
	}	
}