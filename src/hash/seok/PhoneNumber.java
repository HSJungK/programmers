package hash.seok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneNumber {
	
	 public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        
	        List<String> list = new ArrayList<String>();
	        Collections.addAll(list, phone_book);
	        
	        int max = 0;
	        
	        Collections.sort(list, (a, b) -> {
//	        	max = a.length() > max ? a.length() : max;
//	        	max = b.length() > max ? b.length() : max;
	        	return a.length() - b.length();
	        });
	        
	        for(int i = 0; i < list.size() - 1; i++) {
	        	String a = list.get(i);
	        	for(int j = i + 1; j < list.size(); j++) {
	                String b = list.get(j).substring(0, a.length());
	                if(b.equals(a)) {
	                	return false;
	                }
	        	}
	        }
	        
	        return answer;
	    }

}
