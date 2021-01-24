package hash.woo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Marathon {
	
	
	/*
	문제 설명
	수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

	제한사항
	마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	completion의 길이는 participant의 길이보다 1 작습니다.
	참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	참가자 중에는 동명이인이 있을 수 있습니다.
	입출력 예
	participant	completion	return
	[leo, kiki, eden]	[eden, kiki]	leo
	[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
	[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
	입출력 예 설명
	예제 #1
	leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

	예제 #2
	vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

	예제 #3
	mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
	*/
	
	
	public static void main(String[] args) {
		
		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		
		System.out.println(solution(participant, completion));
	
	}
	/*첫번째답*/
	 public static String solution(String[] participant, String[] completion) {
		 
		 String answer = "";
		 
		 Map<String, Integer> participantMap = new HashMap<>();
		 
		 for (String participantKey : participant) {
			 
			 int cnt = participantMap.get(participantKey)==null?1:participantMap.get(participantKey)+1;			 
			 
			 participantMap.put(participantKey,cnt);			
		 }
		 
		 for(String completionKey:completion) {
			
			 
			int cnt = participantMap.get(completionKey)-1;
					
			if(cnt==0) {
				
				participantMap.remove(completionKey);
				continue;
				
			}
				
			participantMap.put(completionKey,cnt);
			
			
			 
		 }
		 
		 
		 List<String> keyList = participantMap.keySet().stream()
			        .collect(Collectors.toCollection(ArrayList::new));
		 
		 for(String key:keyList) {
			 
			 answer = key;
			 
		 }
		 
	     return answer;
	        
	        
	 }
	 
	 /*프로그래머스 풀이*/
	 public static String bestSolution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> hm = new HashMap<>();
	        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
	        for (String player : completion) hm.put(player, hm.get(player) - 1);

	        for (String key : hm.keySet()) {
	            if (hm.get(key) != 0){
	                answer = key;
	            }
	        }
	        return answer;
	    }
	 
	 

}
