package algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculatorII {
    public static int calculate(String s) {
        ArrayList<Object> p = parse(s);
        process(p, Arrays.asList('+', '-'));
        process(p, new LinkedList<>());
        return (Integer)p.get(0);
    }

    private static ArrayList<Object> parse(String s){
        ArrayList<Object> p = new ArrayList<>();
        StringBuilder b = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ic = s.charAt(i);
            boolean isOperand = ic == '*' || ic == '+' || ic == '-' || ic == '/';
            if(Character.isDigit(ic))
                b.append(ic);
            else if(b.length() > 0){
                p.add(Integer.parseInt(b.toString()));
                b.setLength(0);
            }
            if(isOperand)
                p.add(ic);
        }
        if(b.length() > 0)
            p.add(Integer.parseInt(b.toString()));
        return p;
    }

    private static void process(ArrayList<Object> p, List<Character> skip){
        for(int i=0; i<p.size(); i++){
            if(p.get(i) instanceof Character){
                Character o = (Character)p.get(i);
                if(skip.contains(o))
                    continue;
                Integer l = (Integer)p.get(i-1), r = (Integer)p.get(i+1);
                Integer result = doOperand(o, l, r);
                for(int j=0; j<3; j++)
                    p.remove(i-1);
                p.add(--i, result);
            }
        }
    }

    private static Integer doOperand(Character o, Integer l, Integer r){
        switch(o){
            case '+':
                return l+r;
            case '-':
                return l-r;
            case '*':
                return l*r;
            case '/':
                return l/r;
            default:
                return null;
        }
    }
}
