package com.gyan.Important;

import java.util.Stack;

public class BalancedParanthesis 
{
	public static void main(String[] args) {
		
		String string = "({[]})";
		Stack<Character> stack =new Stack<Character>();
		
		for(int i=0;i<string.length();i++)
		{
			
			if(string.charAt(i) =='{' || string.charAt(i) =='[' || string.charAt(i)=='(') 
			{
				/* If the current character is starting bracket,
	               then push them in a stack */
				stack.push(string.charAt(i));	
			}
			
		/*	Else, If the stack is not empty,
            And current character is a closing bracket
            and top character of a stack is matching open bracket
            then pop it. */
			else if (!stack.empty() && ((string.charAt(i) == ']' && stack.peek() == '[') || 
                    (string.charAt(i) == '}' && stack.peek() == '{') ||
                    (string.charAt(i) == ')' && stack.peek() == '('))) 
			{
				stack.pop();
			}
			else
			{
				stack.push(string.charAt(i));
			}
			
	}
		 if(stack.empty()) {
             System.out.println("Balanced");
        } else {
             System.out.println("Not balanced");
        }

}
}
