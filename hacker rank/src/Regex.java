import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println(checkMessage("()[]{}{"));
    }
    //cách 1:
    public static boolean checkMessage(String name) {
        String regex = "([(][)]|\\[\\]|[{][}])+";
        return Pattern.matches(regex, name);
    }
    //cách 2
      public  static boolean solution(String s) {
            char[] ch=s.toCharArray();
            for (int i = 0; i < ch.length; i+=2) {
                if ((ch[i] == '(' && ch[i+1] ==')') || (ch[i] == '{' && ch[i+1] =='}') || (ch[i] == '[' && ch[i+1] ==']')) {
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }

