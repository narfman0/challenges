package algs;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int s1l = 0, s2l = 0, s3l = 0;
        if(s1.length() + s2.length() != s3.length())
            return false;

        while(s3l < s3.length()){
            if(s1l < s1.length() && s1.charAt(s1l) == s3.charAt(s3l) &&
                    s2l < s2.length() && s2.charAt(s2l) == s3.charAt(s3l)){
                // we need to split the call here, because it could go either way
                return isInterleave(s1.substring(s1l+1), s2.substring(s2l), s3.substring(s3l+1)) ||
                        isInterleave(s1.substring(s1l), s2.substring(s2l+1), s3.substring(s3l+1));
            }else if(s1l < s1.length() && s1.charAt(s1l) == s3.charAt(s3l)){
                s3l++;
                s1l++;
            }else if(s2l < s2.length() && s2.charAt(s2l) == s3.charAt(s3l)){
                s3l++;
                s2l++;
            }else
                return false;
        }
        return true;
    }
}
