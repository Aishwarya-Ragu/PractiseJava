package stack;

import java.util.Stack;

public class ScoreParenthesis {
    public static void main(String[] args) {
        ScoreParenthesis sp = new ScoreParenthesis();
        int res = sp.scoreOfParentheses("(()(()))");
        System.out.println(res);
    }

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
