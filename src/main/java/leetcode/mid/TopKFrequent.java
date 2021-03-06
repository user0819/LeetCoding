package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *  
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * @author wangxiang
 * @since 2021/5/20 15:46
 */
public class TopKFrequent {
    public static void main(String[] args) {
        List<String> result = topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        List<String> result2 = topKFrequent2(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(result);
        System.out.println(result2);
    }

    // 借助对象，笨重！
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Word> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                Word word = map.get(s);
                word.setTimes(word.getTimes() + 1);
            } else {
                Word word = new Word();
                word.setWord(s);
                map.put(s, word);
            }
        }

        List<Word> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> {
            if (o1.getTimes() == o2.getTimes()) {
                return o2.getWord().compareTo(o1.getWord());
            }
            return o1.getTimes() - o2.getTimes();
        });

        List<String> result = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < k; i++) {
            result.add(list.get(size - 1 - i).getWord());
        }
        return result;
    }

    static class Word {
        String word;
        int times;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

    }

    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
           map.put(s, map.getOrDefault(s,0) + 1);
        }

        List<String> wordList = new ArrayList<>(map.keySet());
        wordList.sort((o1, o2) ->  map.get(o1) == map.get(o2) ? o1.compareTo(o2): map.get(o2) - map.get(o1));

        return wordList.subList(0, k);
    }
}
