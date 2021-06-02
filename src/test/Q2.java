package test;


import java.io.*;
import java.util.*;

public class Q2 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void writeWords(String source, String destination) {
        readingFromFile(source);

        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());
        list = orderList(list);

        writingToFile(destination, list);
    }

    private static List<String> orderList(List<String> list) {
        if (list != null) {
            list.sort((s1, s2) -> {
                int x = map.get(s2) - map.get(s1);
                if (x == 0)
                    x = s1.compareTo(s2);
                return x;
            });
        }
        return list;

    }

    private static void readingFromFile(String fileName) {
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (s.hasNext()) {
                String w = s.next();
                if (!map.containsKey(w))
                    map.put(w, 1);
                else
                    map.put(w, map.get(w) + 1);
            }
            s.close();
        } catch (IOException e) {
        }
    }

    private static void writingToFile(String fileName, List<String> list) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            for (String oneItem : list) {
                out.println(oneItem);
            }
            out.close();
        } catch (IOException e) {
        }
    }
}
