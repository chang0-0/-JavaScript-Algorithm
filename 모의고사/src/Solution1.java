import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Solution1 { 
	public static void main(String[] args) {
		Solution1 t = new Solution1();
		String x = "12321";
		String y = "42531";
		
		System.out.println(t.solution(x, y));
	}// End of main
	
    public String solution(String X, String Y) {
    	char c1[] = X.toCharArray();
    	char c2[] = Y.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	HashMap<Character, Long> map1 = new HashMap<Character, Long>();
    	HashMap<Character, Long> map2 = new HashMap<Character, Long>();
    	List<Character> resultList  = new ArrayList<>();
    	
    	int len1 = c1.length;
    	for(int i=0; i<len1; i++) {
    		map1.put(c1[i], map1.getOrDefault(c1[i], (long) 0)+1);
    	}
    	
    	int len2 = c2.length;
    	for(int i=0; i<len2; i++) {
    		map2.put(c2[i], map2.getOrDefault(c2[i], (long) 0)+1);
    	}
    	
    	boolean check = true;
    	if(map1.size() > map2.size()) {
    		Iterator<Entry<Character, Long>> it = map1.entrySet().iterator();
    		while(it.hasNext()) {
    			Entry<Character, Long> entrySet = (Entry<Character, Long>)it.next();
    			char key = entrySet.getKey();
    			long value = entrySet.getValue();
    			
    			if( map2.containsKey(key) ) {
    				check = false; 
    				
    				// 만약 겹치는 수가 있다.
    				// 그 키에 해당하는 value를 찾아서 갯수를 비교하고 작은 쪽을 list에 삽입
    				long value2 = map2.get(key);
    				long min = Math.min(value, value2);
    				for(int i=0; i<min; i++) {
    					resultList.add(key);
    				}	
    			}	
    		}
    	} 
    	
		if(check == true) {
			return "-1";
		}
		
		if(resultList.isEmpty()) {
			return "-1";
		}
		
		Collections.sort(resultList, Collections.reverseOrder());		
		for(char c : resultList) {
			sb.append(c);			
		}
		
		if(Integer.parseInt(sb.toString()) == 0) {
			return "0";
		}
    	
        return sb.toString();
    }  // End of solution
} // End of Solution class