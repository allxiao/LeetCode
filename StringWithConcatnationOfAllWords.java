import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String s, String[] l) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (l.length == 0) {
            for (int i = 0, ie = s.length(); i < ie; i++)
                results.add(i);
            return results;
        }
        int wlen = l[0].length();
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        for (String word : l) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
            else {
                wordsCount.put(word, 1);
            }
        }
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        OUTER:
        for (int i = 0, ie = s.length() - l.length * wlen; i <= ie; i++) {
            found.clear();
            for (int j = 0; j < l.length; j++) {
                int start = i + j * wlen;
                String key = s.substring(start, start + wlen);
                if (!wordsCount.containsKey(key))
                    continue OUTER;
                int count = found.containsKey(key) ? found.get(key) + 1 : 1;
                if (count > wordsCount.get(key))
                    continue OUTER;
                found.put(key, count);
            }
            results.add(i);
        }

        return results;
    }
}
