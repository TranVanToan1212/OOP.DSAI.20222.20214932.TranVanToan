
import javax.swing.JOptionPane;

public class EquationsSolver {
    public static void main(String[] args){
        String strNumofVar, strNumofDeg;
        int NumofVar, NumofDeg;
        String strNotification = "";

        strNumofDeg = JOptionPane.showInputDialog(null,
                "Please input the degree of your equation(s) (1 or 2): ",
                "Input degree",
                JOptionPane.INFORMATION_MESSAGE);
        NumofDeg = Integer.parseInt(strNumofDeg);
        
        switch (NumofDeg) {
            case 1:
                strNumofVar = JOptionPane.showInputDialog(null,
                        "Please input the number of your equation(s)'s variables (1 or 2): ",
                        "Input number of variables",
                        JOptionPane.INFORMATION_MESSAGE);
                NumofVar = Integer.parseInt(strNumofVar);
                
                switch (NumofVar) {
                    case 1:
                        String stra, strb;
                        double a, b, sol;

                        stra = JOptionPane.showInputDialog(null,
                                "Please input the first coefficient (a in ax + b = 0): ",
                                "Input a",
                                JOptionPane.INFORMATION_MESSAGE);
                        strb =  JOptionPane.showInputDialog(null,
                                "Please input the second coefficient (b in ax + b = 0): ",
                                "Input b",
                                JOptionPane.INFORMATION_MESSAGE);
                        
                        a = Double.parseDouble(stra);
                        b = Double.parseDouble(strb);

                        if (a == 0) {
                            if (b != 0){
                                strNotification = "No solution";
                            }
                            else{
                                strNotification = "Every real x satisfies the equation";
                            }
                        }
                        else {
                            sol = - b/a;
                            strNotification = "The solution is: x = " + Double.toString(sol);
                        }
                        break;

                    case 2:       
                        String stra_1, strb_1, strc_1, stra_2, strb_2, strc_2;
                        double a_1, b_1, c_1, a_2, b_2, c_2, D, D_1, D_2, x_1, x_2;
                        
                        stra_1 = JOptionPane.showInputDialog(null,
                                "Input a_1 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input a_1",
                                JOptionPane.INFORMATION_MESSAGE);
                        strb_1 = JOptionPane.showInputDialog(null,
                                "Input b_1 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input b_1",
                                JOptionPane.INFORMATION_MESSAGE);
                        strc_1 = JOptionPane.showInputDialog(null,
                                "Input c_1 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input c_1",
                                JOptionPane.INFORMATION_MESSAGE);
                        stra_2 = JOptionPane.showInputDialog(null,
                                "Input a_2 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input a_2",
                                JOptionPane.INFORMATION_MESSAGE);
                        strb_2 = JOptionPane.showInputDialog(null,
                                "Input b_2 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input b_2",
                                JOptionPane.INFORMATION_MESSAGE);
                        strc_2 = JOptionPane.showInputDialog(null,
                                "Input c_2 in (a_1x + b_1y = c_1 and a_2x + b_2y = c_2): ",
                                "Input c_2",
                                JOptionPane.INFORMATION_MESSAGE);
                        
                        a_1 = Double.parseDouble(stra_1);
                        b_1 = Double.parseDouble(strb_1);
                        c_1 = Double.parseDouble(strc_1);
                        a_2 = Double.parseDouble(stra_2);
                        b_2 = Double.parseDouble(strb_2);
                        c_2 = Double.parseDouble(strc_2);

                        D = a_1*b_2 - a_2*b_1;
                        D_1 = c_1*b_2 - c_2*b_1;
                        D_2 = c_2*a_1 - a_2*c_1;

                        if ((D == 0 && D_1 != 0) || (D == 0 && D_2 != 0)) {
                            strNotification = "No solution";
                        }
                        else {
                            if (D == 0) {
                                strNotification = "Every pair of real x, y satisfies the system";
                            }
                            else {
                                x_1 = D_1/D;
                                x_2 = D_2/D;
                                strNotification = "Solution to the system: x = " + Double.toString(x_1)
                                        + " y = " + Double.toString(x_2);
                            }
                        }
                        break;
                    }
                break;

            case 2:
                NumofVar = 1;
                double a, b, c, delta, sqrtdelta, x_1, x_2;
                String stra, strb, strc;
                stra = JOptionPane.showInputDialog(null,
                        "Input a (!= 0) in (ax^2 + bx + c = 0): ",
                        "Input a",
                        JOptionPane.INFORMATION_MESSAGE);
                strb = JOptionPane.showInputDialog(null,
                        "Input b in (ax^2 + bx + c = 0): ",
                        "Input b",
                        JOptionPane.INFORMATION_MESSAGE);
                strc = JOptionPane.showInputDialog(null,
                        "Input c in (ax^2 + bx + c = 0): ",
                        "Input c",
                        JOptionPane.INFORMATION_MESSAGE);
                
                a = Double.parseDouble(stra);
                b = Double.parseDouble(strb);
                c = Double.parseDouble(strc);
                
                delta = b*b - 4*a*c;
                
                if (a == 0){
                    strNotification = "a is equal to 0! Use linear equation solver instead";
                }
                else {
                    if (delta < 0) {
                        strNotification = "No real roots";
                    }
                    else if (delta == 0) {
                        x_1 = - b/(2*a);
                        strNotification = "Double root: x = " + Double.toString(x_1);
                    }
                    else {
                        sqrtdelta = Math.pow(delta, 0.5);
                        x_1 = (-b - sqrtdelta) / (2*a);
                        x_2 = (-b + sqrtdelta) / (2*a);
                        strNotification = "Two distinct roots: x_1 = " + Double.toString(x_1) 
                                + " x_2 = " + Double.toString(x_2);
                    }
                }
                break;
        }
        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
    }   
}