import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String str:participant){
            map.put(str, map.getOrDefault(str, 0 ) + 1);
        }

        for(String str:completion){
            map.put(str, map.get(str) - 1);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)it.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}