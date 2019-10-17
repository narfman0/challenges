package algs;

import java.util.HashMap;
import java.util.HashSet;

public class MinWindow {
    public static String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty())
            return "";
        HashSet<Character> tSet = new HashSet<>();
        HashMap<Character, Integer> used = new HashMap<>();
        for(int i=0; i<t.length(); i++)
            tSet.add(t.charAt(i));

        boolean minSet = false;
        int l=0, r=-1, minL=0, minR=0;
        while(r < s.length()){
            while(tSet.size() != used.size()){
                r++;
                if(r == s.length())
                    break;
                if(tSet.contains(s.charAt(r)))
                    used.put(s.charAt(r), r);
            }
            if(r == s.length())
                break;
            while(tSet.size() == used.size()){
                if(!minSet || minR-minL > r-l){
                    minSet = true;
                    minR = r;
                    minL = l;
                }
                Integer i = used.get(s.charAt(l));
                if(i != null && i == l)
                    used.remove(s.charAt(l));
                l++;
            }
        }
        return s.substring(minL, minR+1);
    }
}
