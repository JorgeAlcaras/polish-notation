package com.alcaras;

import java.util.Scanner;

public class PolishNotation {

    /**
     * Terminal user interface for the calculator.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();
        System.out.println("Postfix expression: " + fromInfixToPostfix(infixExpression));
        System.out.println("Result: " + evaluatePostfix(fromInfixToPostfix(infixExpression)));
    }

    /**
     * Converts infix expression into postfix expressions.
     *
     * @param expression Infix expression.
     * @return Postfix expression.
     */
    public static String fromInfixToPostfix(String expression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] tokens = expression.toCharArray();

        // Iterate over each character in the infix expression.
        for (int i = 0; i < tokens.length; i++) {
            char character = tokens[i];
            if (Character.isDigit(character)) {
                // If the character is a digit, append it to the postfix expression.
                if (i + 1 < tokens.length && Character.isDigit(tokens[i + 1])) {
                    // If the next character is a digit, append the digit without a space.
                    postfixExpression.append(character);
                } else {
                    // If the next character is not a digit, append a space after the digit.
                    postfixExpression.append(character).append(" ");
                }
            } else if (character == '(') {
                // If the character is an opening parenthesis, push it to the stack.
                stack.push(character);
            } else if (character == ')') {
                // If the character is a closing parenthesis, pop the operators from the stack until the opening parenthesis is found.
                while (!stack.isEmpty() && stack.peek().getData() != '(') {
                    postfixExpression.append(stack.pop().getData()).append(" ");
                }
                // Pop the opening parenthesis from the stack.
                stack.pop();
            } else {
                // If the character is an operator, pop the operators from the stack until the precedence is lower than the current operator.
                while (!stack.isEmpty() && precedence(character) <= precedence(stack.peek().getData())) {
                    postfixExpression.append(stack.pop().getData()).append(" ");
                }
                // Push the current operator to the stack.
                stack.push(character);
            }
        }

        // Pop the remaining operators from the stack
        while (!stack.isEmpty()) {
            // Append the operator to the postfix expression.
            postfixExpression.append(stack.pop().getData()).append(" ");
        }

        // Return the postfix expression.
        return postfixExpression.toString().trim();
    }

    /**
     * Returns the precedence of an operator.
     *
     * @param symbol operator
     * @return precedence
     */
    public static int precedence(char symbol) {
        int precedence = 0;
        switch (symbol) {
            case '+':
            case '-':
                // Precedence of + or - is 1
                precedence = 1;
                break;
            case '*':
            case '/':
                // Precedence of * or / is 2
                precedence = 2;
                break;
            case '^':
                // Precedence of ^ is 3
                precedence = 3;
                break;
            default:
                break;
        }
        return precedence;
    }

    /**
     * Evaluate a postfix expression.
     *
     * @param expression postfix expression.
     * @return result of the calculus.
     */
    public static double evaluatePostfix(String expression) {
        // Create a stack to store the numbers.
        Stack<Double> stack = new Stack<>();
        // Split the expression into tokens.
        String[] tokens = expression.split(" ");
        // Iterate over each token in the postfix expression.
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                // If the token is a number, push it to the stack.
                stack.push(new Node<>(Double.parseDouble(token)));
            } else {
                // If the token is an operator, pop the last two numbers from the stack and apply the operation.
                Double operand2 = stack.pop().getData();
                Double operand1 = stack.pop().getData();

                // Apply the operation and push the result to the stack.
                switch (token) {
                    case "+":
                        stack.push(new Node<>(operand1 + operand2));
                        break;
                    case "-":
                        stack.push(new Node<>(operand1 - operand2));
                        break;
                    case "*":
                        stack.push(new Node<>(operand1 * operand2));
                        break;
                    case "/":
                        stack.push(new Node<>(operand1 / operand2));
                        break;
                    case "^":
                        stack.push(new Node<>(Math.pow(operand1, operand2)));
                        break;
                    default:
                        // If the token is not a valid operator, throw an exception.
                        throw new IllegalArgumentException("Invalid operator");
                }
            }
        }

        // Return the result of the calculus.
        return stack.pop().getData();
    }
}