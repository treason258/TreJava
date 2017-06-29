package com.mjiayou.trejava.module.uicalculator;

import java.util.regex.Pattern;

/**
 * Calculator 使用的计算工具类
 */
public class ComputeUtil {

    // calculate sqrt for number
    static public String Sqr(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;

        for (i = 0; i < X.length; i++) {
            if (X[i].startsWith("S")) {
                String XXX = X[i].substring(1, X[i].length());
                double result;
                double a = Double.parseDouble(XXX);
                result = Math.sqrt(a);
                newstring[M] = Double.toString(result);
                M++;
            } else {
                newstring[M] = X[i];
                M++;
            }
        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;
    }

    // calculate power of number
    static public String ostwo(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;

        for (i = 0; i < X.length; i++) {
            if (X[i].endsWith("^")) {
                String[] XX = X[i].split(Pattern.quote("^"));
                double result;
                double a = Double.parseDouble(XX[0]);
                result = a * a;
                if (X[i].startsWith("+"))
                    newstring[M] = "+" + Double.toString(result);
                else if (X[i].startsWith("-"))
                    newstring[M] = "+" + Double.toString(result);
                else
                    newstring[M] = Double.toString(result);
                M++;
            } else {
                newstring[M] = X[i];
                M++;
            }
        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;
    }

    // divide expression to array of string
    static public String[] divide(String m) {
        int ii = 0;

        // int x=1;
        char[] operations = new char[m.length()];
        String[] nums = new String[100];
        boolean mm = false;
        boolean mn = false;
        for (int i = 0; i < m.length(); i++) {

            operations[i] = m.charAt(i);
            if (operations[i] == '+' & mm == true) {
                nums[ii] = "-";
                mm = false;
            } else if (operations[i] == '-' & mm == true) {
                nums[ii] = "+";
                mm = false;
            } else if (operations[i] == '+' & mn == true) {
                nums[ii] = "+";
                mn = false;
            } else if (operations[i] == '-' & mn == true) {
                nums[ii] = "-";
                mn = false;
            } else if (operations[i] == '/') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "/";
                ii++;
            } else if (operations[i] == '(') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "(";
                ii++;
                mn = false;
                mm = false;
            } else if (operations[i] == ')') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = ")";
                ii++;
                mn = false;
                mm = false;
            } else if (operations[i] == '%') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "%";
                ii++;
            } else if (operations[i] == 'S') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "S";
            } else if (operations[i] == '*') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "*";
                ii++;
            } else if (operations[i] == '+') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "+";
                mn = true;
            } else if (operations[i] == '-') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "-";
                mm = true;
            } else {
                if (nums[ii] == null)
                    nums[ii] = "";
                nums[ii] += m.charAt(i);
                mm = false;
                mn = false;
            }
        }

        String[] newone = new String[ii + 1];
        for (int iii = 0; iii < ii + 1; iii++) {
            if (nums[iii] != null)
                newone[iii] = nums[iii];
        }

        return newone;
    }

    // divide two numbers
    static public String div(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];

        for (i = 1; i < X.length; i++) {
            if (X[i] == "/") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);

                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a / b);
                else if (X[i + 1].startsWith("-") & X[i - 1].startsWith("-"))
                    newstring[M] = "+" + Double.toString(a / b);
                else
                    newstring[M] = Double.toString(a / b);

                X[i + 1] = Double.toString(a / b);
                i++;
            } else {
                if (X[i] != "/" || X[i + 1] != "/")
                    M++;
                newstring[M] = X[i];
            }
        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;
    }

    //calculate modules
    static public String mod(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];

        for (i = 1; i < X.length; i++) {
            if (X[i] == "%") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);

                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a % b);
                else
                    newstring[M] = Double.toString(a % b);

                X[i + 1] = Double.toString(a % b);
                i++;
            } else {
                if (X[i] != "%" || X[i + 1] != "%")
                    M++;
                newstring[M] = X[i];
            }
        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;
    }

    //do operations from operation with highest priority
    static public String Dooperation(String X) {
        String XXXX = ostwo(divide(X));
        String XXX = Sqr(divide(XXXX));
        String XX = mod(divide(XXX));
        String C1 = div(divide(XX));
        String C = mul(divide(C1));
        String CCC = sumandsub(divide(C));
        return CCC;
    }

    //multiply two numbers
    static public String mul(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];
        for (i = 1; i < X.length; i++) {
            if (X[i] == "*") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);

                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a * b);
                else if (X[i + 1].startsWith("-") & X[i - 1].startsWith("-"))
                    newstring[M] = "+" + Double.toString(a * b);
                else
                    newstring[M] = Double.toString(a * b);

                X[i + 1] = Double.toString(a * b);
                i++;
            } else {
                if (X[i] != "*" || X[i + 1] != "*")
                    M++;
                newstring[M] = X[i];
            }
        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;
    }

    //sum and sub expression
    static public String sumandsub(String[] X) {
        double x = 0;
        double y = 0;
        for (int i = 0; i < X.length; i++) {
            if (X[i].startsWith("-"))
                x += Double.valueOf(X[i]);
                /*x+=Double.parseDouble(X[i]);*/
            else
                y += Double.valueOf(X[i]);
                /*y+=Double.parseDouble(X[i]);*/
        }

        double z = x + y;
        String pop = Double.toString(z);
        return pop;
    }

    // solve brackets if no found or finish and still expression go to dooperation
    static public String solve(String X) {
        int result;
        double result2;
        while (X.contains(Character.toString('(')) || X.contains(Character.toString(')'))) {
            for (int I = 0; I < X.length(); I++) {
                try {                                                        //i there is not sign
                    if ((X.charAt(I) == ')' || Character.isDigit(X.charAt(I))) //between separate brackets
                            && X.charAt(I + 1) == '(') {                         //or number and bracket,
                        X = X.substring(0, I + 1) + "*" + (X.substring(I + 1));        //it treat it as
                    }                                                       //a multiplication
                } catch (StringIndexOutOfBoundsException e) {
                }//ignore out of range ex
                if (X.charAt(I) == ')') {                                  //search for a closing bracket
                    for (int i = I; i >= 0; i--) {
                        if (X.charAt(i) == '(') {                          //search for a opening bracket
                            String newexp = X.substring(i + 1, I);
                            newexp = ComputeUtil.Dooperation(newexp);
                            X = X.substring(0, i) + newexp + X.substring(I + 1);
                            i = I = 0;
                        }
                    }
                }
            }
            if (X.contains(Character.toString('(')) || X.contains(Character.toString(')')) ||
                    X.contains(Character.toString('(')) || X.contains(Character.toString(')'))) {
                return "Error: incorrect brackets";
            }
        }

        try {
            X = ComputeUtil.Dooperation(X);
            result2 = Double.parseDouble(X);
            result = (int) result2;
            if (result == result2) {
                X = Integer.toString(result);
            }

        } catch (NumberFormatException ex) {
            X = "Erorr Expression ";
            ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex) {
            X = "Erorr Expression ";
            ex.printStackTrace();
        }

        // X=ComputeUtil.Dooperation(X);
        return X;
    }
}