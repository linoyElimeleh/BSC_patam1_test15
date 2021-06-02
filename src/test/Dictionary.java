package test;

import java.util.*;

public class Dictionary {

    HashMap<Character, List<String>> dic;
    // you can add code here

    public Dictionary(String text) {
        HashMap<Character, HashSet<String>> map = new HashMap<Character, HashSet<String>>();
        Scanner s = new Scanner(text);
        while (s.hasNext()) {
            String oneWord = s.next();
            char c = oneWord.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new HashSet<>());
            }
            map.get(c).add(oneWord);
        }
        s.close();

        dic = new HashMap<>();
        for (char c : map.keySet()) {
            List<String> l = new ArrayList<>();
            l.addAll(map.get(c));
            Collections.sort(l);
            dic.put(c, l);

        }
        // you can add code here
    }

    public List<String> getList(char c) {
        // implement in O(1)
        if (dic.containsKey(c)) {
            return dic.get(c);
        }
        return new ArrayList<>();
    }
}
