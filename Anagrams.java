import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        ArrayList<String> results = new ArrayList<String>();
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);
            if (list.size() > 1) {
                for (String word : list)
                    results.add(word);
            }
        }
        return results;
    }
}
