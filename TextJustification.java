public class Solution {
    public ArrayList<String> fullJustify(String[] words, int l) {
        ArrayList<String> results = new ArrayList<String>();
        int linelen = 0;
        int wordslen = 0;
        int start = 0;
        int index = 0;
        while (index < words.length) {
            int wlen = words[index].length();
            int newlen = (linelen == 0) ? wlen : (linelen + wlen + 1);
            int newwordslen = wordslen + wlen;
            if (newlen > l) {
                results.add(layoutFull(words, l, linelen, wordslen, start, index));
                linelen = 0;
                wordslen = 0;
                start = index;
            }
            else if (index == words.length - 1) {
                results.add(layoutLastLine(words, l, newlen, start));
                break;
            }
            else {
                linelen = newlen;
                wordslen = newwordslen;
                index++;
            }
        }
        return results;
    }

    private String layoutFull(String[] words, int l, int linelen, int wordslen, int start, int end) {
        int wordscount = end - start;
        StringBuffer sb = new StringBuffer();
        if (wordscount == 1) {
            sb.append(words[start]);
            for (int i = l - words[start].length(); i > 0; i--)
                sb.append(' ');
        }
        else {
            int spaces = l - wordslen;
            int spaceEach = spaces / (wordscount - 1);
            int spaceOneMore = spaces - spaceEach * (wordscount - 1);
            sb.append(words[start]);
            for (int i = start + 1; i < end; i++) {
                for (int j = 0; j < spaceEach; j++)
                    sb.append(' ');
                if (spaceOneMore > 0) {
                    sb.append(' ');
                    spaceOneMore--;
                }
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }

    private String layoutLastLine(String[] words, int l, int linelen, int start) {
        StringBuffer sb = new StringBuffer();
        sb.append(words[start]);
        for (int i = start + 1; i < words.length; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        for (int i = l - linelen; i > 0; i--)
            sb.append(' ');
        return sb.toString();
    }
}
