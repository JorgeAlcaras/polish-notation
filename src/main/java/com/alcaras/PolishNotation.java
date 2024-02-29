package com.alcaras;

public class PolishNotation {
    public static void main(String[] args) {
        //Stack stack = new Stack();
        //String expression = "3 4 + 5 * 6 -";
        String postfixExpression = fromInfixToPostfix("3+4*(5-6)-(7+8)+9");
        System.out.println(postfixExpression);
        //String[] elements = expression.split(" ");
    }

    public static String fromInfixToPostfix(String expression) {
        String postfixExpression = "";
        Stack stack = new Stack();
        for (char character : expression.toCharArray()) {
            if (Character.isDigit(character)) {
                postfixExpression += character + " ";
            } else if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while (!stack.isEmpty() && (char) stack.peek().data != '(') {
                    postfixExpression += stack.pop().data + " ";
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(character) <= precedence((char) stack.peek().data)) {
                    postfixExpression += stack.pop().data + " ";
                }
                stack.push(character);
            }
        }
        while (!stack.isEmpty()) {
            postfixExpression += stack.pop().data;
        }
        return postfixExpression;
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
}