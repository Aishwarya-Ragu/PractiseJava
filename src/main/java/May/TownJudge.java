package May;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TownJudge {
    public static void main(String args[]){
        int N = 3;
        int[][]trust = {{1,3},{2,3},{3,1}};
        Set<Integer> people =new HashSet<Integer>();
        Map<Integer,Integer> judge =new HashMap<Integer,Integer>();
        for(int i =0;i<trust.length;i++){
            people.add(trust[i][0]);
            judge.put(trust[i][1],judge.getOrDefault(trust[i][1],0)+1);
        }
        int townJudge =-1;
        for(Map.Entry<Integer,Integer> doubt:judge.entrySet()){
            if(!people.contains(doubt.getKey()) && doubt.getValue()== N-1)
                townJudge = doubt.getKey();
        }
        System.out.println(townJudge);


    }
}
