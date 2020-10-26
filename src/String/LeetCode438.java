package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
题解:https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/
 */
public class LeetCode438 {
    static List<Integer> res;
   public List<Integer> findAnagrams(String s, String p){

        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for (char c : p.toCharArray())
            need.put(c, need.getOrDefault(c,0) + 1);
        //System.out.println(need);
        int left = 0 ,right = 0;
        int valid = 0;
        while (right < s.length()){
            char cs = s.charAt(right);
            right ++;
            if (p.contains(Character.toString(cs))) {
                //window.get(cs) ++;
                //window[cs - 'a']++;
                //if (window[cs - 'a'] == need[cs - 'a'])
                window.put(cs,window.getOrDefault(cs,0) + 1);
                if (window.get(cs) == need.get(cs))
                    valid ++;
            }
            //System.out.println(need.length);
            while (right - left >= p.length()){
                System.out.println(left + " " + right);
                if (valid == need.size())
                    res.add(left);
                /*一直在操作s,思想方式固定一个另一个不变*/
                char cp = s.charAt(left);
                left ++;
                if (p.contains(Character.toString(cp))) {
                    if (window.get(cp) == need.get(cp))
                    //if (window[cp - 'a'] == need[cp - 'a'])
                        valid--;
                    window.put(cp,window.get(cp) - 1);
                }
            }
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args){
        res = new ArrayList<>();
        String s = "baa";
        String p = "aa";
        new LeetCode438().findAnagrams(s,p);
    }
}
