package com.alcaras;

import java.util.Scanner;

public class PolishNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();
        System.out.println("Postfix expression: " + fromInfixToPostfix(infixExpression));
        System.out.println("Result: " + evaluatePostfix(fromInfixToPostfix(infixExpression)));
    }

    public static String fromInfixToPostfix(String expression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] charArray = expression.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char character = charArray[i];
            if (Character.isDigit(character)) {
                if (i + 1 < charArrayLength && Character.isDigit(charArray[i + 1])) {
                    postfixExpression.append(character);
                } else {
                    postfixExpression.append(character).append(" ");
                }
            } else if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while (!stack.isEmpty() && stack.peek().data != '(') {
                    postfixExpression.append(stack.pop().data).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(character) <= precedence(stack.peek().data)) {
                    postfixExpression.append(stack.pop().data).append(" ");
                }
                stack.push(character);
            }
        }

        // Pop the remaining operators from the stack
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop().data).append(" ");
        }

        return postfixExpression.toString().trim();
    }

    public static int precedence(char symbol) {
        int precedence = 0;
        switch (symbol) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
            default:
                break;
        }
        return precedence;

    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(new Node<>(Double.parseDouble(token)));
            } else {
                Double operand2 = stack.pop().data;
                Double operand1 = stack.pop().data;
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
                    default:
                        System.out.println(token);
                        break;
                }
            }
        }
        System.out.println(stack);
        return stack.pop().data;
    }
}