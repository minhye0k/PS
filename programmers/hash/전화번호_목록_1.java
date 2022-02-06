import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        int size = phone_book.length;

        for(int i=0; i<size; i++)
            map.put(phone_book[i], i);

        for(int i=0; i<size; i++)
            for(int j=0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j)))
                    answer = false;
            }

        return answer;
    }
}