package hash.seok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	public int[] solution(String[] genres, int[] plays) {
        Map<String, HashMap<Integer, Integer>> map = new HashMap<String, HashMap<Integer, Integer>>();
        
        for(int i = 0; i < genres.length; i++) {
        	HashMap<Integer, Integer> m = map.containsKey(genres[i]) ?
        			map.get(genres[i]) : new HashMap<Integer, Integer>();
        	m.put(i, plays[i]);
        	map.put(genres[i], m);
        }
        
        List<String> list = new ArrayList<String>(map.keySet());
        
        Collections.sort(list, (a, b) -> {
        	HashMap<Integer, Integer> map1 = map.get(a);
        	int sum1 = map1.keySet().stream().mapToInt(key -> map1.get(key)).sum();

        	HashMap<Integer, Integer> map2 = map.get(b);
        	int sum2 = map2.keySet().stream().mapToInt(key -> map2.get(key)).sum();
        	
        	return sum2 - sum1;
        });

        List<Integer> idx = new ArrayList<Integer>();
        
        for(String key : list) {
        	HashMap<Integer, Integer> m = map.get(key);

            List<Integer> l = new ArrayList<Integer>(m.keySet());
        	
        	Collections.sort(l, (a, b) -> {
            	return m.get(b) - m.get(a);
            });
        	
        	idx.addAll(l.subList(0, l.size() > 1 ? 2 : 1));
        }
        
        
        int[] answer = new int[idx.size()];

        int size=0;

        for(int temp : idx){

        	answer[size++] = temp;

        }
        
        return answer;
    }
	

}
