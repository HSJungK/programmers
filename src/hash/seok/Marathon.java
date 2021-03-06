package hash.seok;

import java.util.HashMap;
import java.util.Map;

public class Marathon {
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> mc = new HashMap<String, Integer>();
        for(String c : completion) {
            Integer count = mc.get(c);
            count = count == null ? 1 : ++count;
            mc.put(c, count);
        }
        
        for(String p : participant) {
            Integer count = mc.get(p);
            count = count == null ? -1 : --count;
            
            if(count == -1) {
                answer = p;
                break;
            }
            mc.put(p, count);
        }
        
        return answer;
    }

}
