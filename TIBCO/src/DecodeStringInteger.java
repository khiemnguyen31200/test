import java.util.Stack;

public class DecodeStringInteger {
public static String decode(String str)
{
    Stack<Integer> Interger = new Stack<>();
    Stack<Character> String = new Stack<>();
    String temp = "" ,result = "";
  
    // Traversing the string
    for (int i = 0; i < str.length(); i++)
    {
        int count = 0;
        // If number it is a number convert it into number and push it to Interger(Stack)
        if (Character.isDigit(str.charAt(i)))
        {
            while (Character.isDigit(str.charAt(i)))
            {
                // Convert to number 
                count = count * 10 + str.charAt(i) - '0';
                i++;
            }
            i--;
            Interger.push(count);
        }
        // If closing bracket ']', pop element until
        // '[' opening bracket is not found in the
        // character stack.
        else if (str.charAt(i) == ']')
        {
            temp = "";
            count = 0;
  
            if (!Interger.isEmpty())
            {
                count = Interger.peek();
                Interger.pop();
            }
  
            while (!String.isEmpty() && String.peek()!='[' )
            {
                temp = String.peek() + temp;
                String.pop();
            }
  
            if (!String.empty() && String.peek() == '[')
            String.pop();
  
            // Repeating the popped string 'temo' count
            // number of times.
            for (int j = 0; j < count; j++)
                result = result + temp;
  
            // Push it in the character stack.
            for (int j = 0; j < result.length(); j++)
            String.push(result.charAt(j));
  
            result = "";
        }
  
        // If '[' opening bracket, push it into character stack.
        else if (str.charAt(i) == '[')
        {
            if (Character.isDigit(str.charAt(i-1)))
            String.push(str.charAt(i));
  
            else
            {
                String.push(str.charAt(i));
                Interger.push(1);
            }
        }
  
        else
        String.push(str.charAt(i));
    }
  
    // Pop all the element, make a string and return.
    while (!String.isEmpty())
    {
        result = String.peek() + result;
        String.pop();
    }
    return result;
}


//Test method 
    public static void main(String[] args) throws Exception {
        String str = "3[a]";
        System.out.println(decode(str));
    }
}
