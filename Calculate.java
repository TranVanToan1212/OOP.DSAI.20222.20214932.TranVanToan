
import javax.swing.JOptionPane;

public class Calculate {
	public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double division = 0;
        boolean division_check = true;

        if (num2 != 0) {
            division = num1 / num2;
        }
        else{
            division_check = false;
        }

        if (division_check == true){
            strNotification = "The sum, difference, product, division respectively are " + String.valueOf(sum) + " , " + String.valueOf(difference) + " , " + String.valueOf(product) + " , " + String.valueOf(division);
        }
        else{
            strNotification = "2nd number is 0, so no division. The sum, difference, product respectively are " + String.valueOf(sum) + " , " + String.valueOf(difference) + " , " + String.valueOf(product);
        }

        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
