import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length*5;
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i< cities.length; i++){
            String s = cities[i].toUpperCase(); //대소문자 구분이 없기 때문에 다 대문자로 바꿔서 비교
            if(cache.remove(s)){ //해당 값이 있으면 true 없으면 false 리턴
                answer += 1;
                cache.add(s);//지워졌기 때문에 다시 캐시에 넣어줌
                
            }else{
                answer += 5;
                if(cache.size() >= cacheSize){
                    cache.remove(0); //현재 캐시 상태가 기준 캐시보다 크거나 같으면 제일 첫번째 LRU에 의해 지워줌
                }
                cache.add(s);
            }
        }
        return answer;
    }
}