import java.util.Arrays;


class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        int size = phone_book.length;

        for(int i=0; i<size-1; i++)
            if(phone_book[i+1].startsWith(phone_book[i]))
                answer = false;

        return answer;
    }
}