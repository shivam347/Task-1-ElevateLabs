import java.util.*;

/* Approach
 * I was thinking how to make a caculator which directly evaluate your expression and produce output
 * comes with infix expression where operator is used between two operands 
 * first think of directly evaluating the infix expression but that is very much complex
 * so comes with converting the infix expression to postfix expression 
 * Then evaluating the postfix expression 
 * This is what whole idea is involved.
 */

class ExpressionCalculator {

    /* This method actually return the precedence of the operators */
    public static int precedence(char op) {

        if (op == '+' || op == '-') {
            return 1;
        }

        if (op == '*' || op == '/') {

            return 2;
        }

        return -1;

    }

    public static List<String> infixToPostfix(String expr) {

        // create a list which store both numbers and the operators and this is the
        // final list to be return
        List<String> output = new ArrayList<>();

        // create a stack for check the precedence of the operators and according to
        // that push it into output list
        Stack<Character> stack = new Stack<>();

        // to add numbers we have to using stringbuilder for inserting multiple digits
        // like 89 or 99 as it is mutable
        StringBuilder num = new StringBuilder();

        // to perform the action i need a for loop over the entire expression
        for (int i = 0; i < expr.length(); i++) {

            char ch = expr.charAt(i);

            // check ch is digit or not but to support multiple digits like a number
            if (Character.isDigit(ch)) {

                num.append(ch);
            } else if (ch == ' ') {
                if (num.length() > 0) {
                    // num is not primitive data type so we can use toString method
                    output.add(num.toString());
                }

                num.setLength(0);
            } // using indexof simply checks ch from the string return 0 or more if found
              // otherwise return -1
            else if ("+-/*".indexOf(ch) != -1) {

                /*
                 * suppose any one who does not provide any space then when we encounter with
                 * any operator we have to push the previous number
                 */
                if (num.length() > 0) {
                    output.add(num.toString());

                    num.setLength(0);
                }

                // checking the precedence and also stack should not empty
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {

                    output.add(String.valueOf(stack.pop()));
                }

                stack.push(ch);

            }

        }

        // check if the last element is a number in a expression so there is no space or
        // operator to check
        if (num.length() > 0) {
            output.add(num.toString());

            num.setLength(0);
        }

        while (!stack.isEmpty()) {

            output.add(String.valueOf(stack.pop()));
        }

        return output;

    }

    /* Part 2 to evaluate the postfix expression */
    public static Double postEvaluation(List<String> output) {

        // create a stack for double type as final output can be double
        Stack<Double> stack = new Stack<>();

        // using for each loop
        for (String token : output) {

            // simply check if token is digit push it to stack
            if (token.matches("\\d+")) {

                stack.push(Double.parseDouble(token));
            } else {
                // done to add the a - b into negative number
                double b = stack.pop(); // second operand
                double a = stack.pop(); // first operand

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;

                    default:
                        System.out.println("Invalid Input");
                        return 0.0;
                }
            }

        }

        return stack.pop();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the expression like -> \"78 + 89 - 12 / 2 * 23 \".");

        System.out.print("Enter your expression: ");

        String expression = sc.nextLine();

        List<String> postfix = infixToPostfix(expression);

        double result = postEvaluation(postfix);

        System.out.print("The output: " + result);

    }

}