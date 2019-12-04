/***
 * Program to print a truth table of an boolean expression
 * For sample input and output refer readme.md file 
 */

import javax.script.*;
import java.util.*;

//Convertion of operaters into computer understandable operators
class ExpressionConverter {
    String convertExpression(char[] string, int length) {

        int i;
        char symbol;

        for (i = 0; i < length; i++) {
            symbol = string[i];

            switch (symbol) {
            case '~':
                string[i] = '~';
                break;
            case 'T':
                string[i] = '1';
                break;
            case 'F':
                string[i] = '0';
                break;
            case '^':
                string[i] = '&';
                break;
            case 'v':
            case 'V':
                string[i] = '|';
                break;
            }
        }
        return String.valueOf(string);
    }
}

//To assaign value to each clommn 
class TruthTable {
    int rows, value;
    int[][] t;

    void basicColumn(char[] var, int length) {

        rows = (int) Math.pow(2, length);
        t = new int[length][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = length - 1; j >= 0; j--) {
                value = (i / (int) Math.pow(2, j)) % 2;

                t[j][i] = value;
            }

        }
    }
}

//prints the truth table
class Result extends TruthTable {
    String str1, str2;
    int i, j, k, l;
    boolean flag = true;

    boolean evaluate(String expressionLhs, String expressionRhs, int length, char[] var) {

        System.out.println("\nTruth Table : ");
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("javascript");

            //It displays a heading of table
            for (i = 0; i < length; i++) {
                System.out.print(String.format("%5s %5s", var[i], "|"));
            }
            System.out.println(
                    String.format("%5s %-25s %s %5s %-18s %3s", " ", expressionLhs, "|", " ", expressionRhs, "|"));
            for (i = 0; i < length; i++) {
                System.out.print(String.format("%s", "----------"));
            }
            System.out
                    .println(String.format("%s", "-----------------------------------------------------------------"));

            //prints valus of each cell
            for (i = 0; i < rows; i++) {
                k = 0;
                str1 = expressionLhs;
                str2 = expressionRhs;
                for (int j = length - 1; j >= 0; j--) {
                    System.out.print(String.format("%5d %5s", t[j][i], "|"));
                    if (t[j][i] == 1) {
                        str1 = str1.replace(var[k], '1');
                        str2 = str2.replace(var[k], '1');
                    } else {
                        str1 = str1.replace(var[k], '0');
                        str2 = str2.replace(var[k], '0');
                    }
                    k++;
                }
                System.out.println(String.format("%7s %-23d %s %7s %-16d %3s", " ", engine.eval(str1), "|", " ",
                        engine.eval(str2), "|"));
                if (!(engine.eval(str1).equals(engine.eval(str2)))) {
                    flag = false;
                }
                System.out.println();
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }

        return flag;
    }
}

//Main class block
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpressionConverter convert = new ExpressionConverter();
        Result result = new Result();

        boolean flag = true;
        char[] chLhs, chRhs;
        String expression;
        int length, n, index1, index2, l1, l2;
        char[] var;
        String strLhs, strRhs;

        System.out.print("\nEnter the Valid expression which only consists of logic gates AND,OR,T,F \n give the expression in the form ex:- a^b <=> b^a \n ^ -> AND \n v ->OR \n ~ ->NOT \n T -> Toutology \n F->Contriduction \n" + "Expression = ");
        expression = sc.nextLine();
        length = expression.length();
        var = new char[length];

        System.out.print("\nEnter the number of variables used = ");
        n = sc.nextInt();

        System.out.println("Enter the variable used = ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "th variable  ");
            var[i] = sc.next().charAt(0);
        }
        System.out.println();
        result.basicColumn(var, n);   //calls truth table class

        index1 = expression.indexOf('<');       //To saperate LHS and RHS part of a expression for evaluation
        index2 = expression.indexOf('>');
        strLhs = expression.substring(0, index1);
        strRhs = expression.substring(index2 + 1, length);
        strLhs = strLhs.trim();
        strRhs = strRhs.trim();

        chLhs = strLhs.toCharArray();
        chRhs = strRhs.toCharArray();

        l1 = chLhs.length;
        l2 = chRhs.length;

        strLhs = convert.convertExpression(chLhs, l1);
        strRhs = convert.convertExpression(chRhs, l2);

        try {
            flag = result.evaluate(strLhs, strRhs, n, var);
        } catch (Exception e) {
        }

        //Chaeks for the expression validity
        if (flag == false) {
            System.out.println("The expression is invalid ");
        } else {
                System.out.println("The expression is valid\n");

        }
        sc.close();
    }
}