/**
 * Sort array such that all anagrams are next to each other
 */
public static sortAnagrams(String[] strings){
    // create a hashmap of the sorted string to list of anagrams
    HashMap<String, List<String>> anagramMap = new HashMap<>();
    for(String string : strings){
        String stringSorted = stringSort(string);
        List<String> anagrams = anagramMap.get(stringSorted);
        if(anagrams == null){
            anagrams = new LinkedList<>();
            anagramMap.put(stringSorted, anagrams);
        }
        anagrams.add(string);
    }
    int i = 0;
    for(List<String> anagrams : anagramMap.values()
        for(String anagram : anagrams)
            strings[i++] = anagram;
}

public static String stringSort(String string){
    return new String(Arrays.sort(string.toCharArray()));
}
