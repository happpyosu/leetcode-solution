package others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 加油站
public class GasStation {

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int circuit = g.canCompleteCircuit(gas, cost);

        System.out.println(circuit);

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> diff = IntStream
                .range(0, gas.length)
                .map(i -> gas[i] - cost[i])
                .boxed()
                .collect(Collectors.toList());

        int sum = diff.stream().mapToInt(i -> i).sum();
        if(sum < 0) return -1;

        int total = 0; int start = 0; int toCur = 0;
        for(int i=0; i<diff.size(); i++){
            int v = diff.get(i);
            total += v;
            toCur += v;

            if(toCur < 0){
                start = i+1;
                toCur = 0;
            }
        }

        if(total >= 0) return start;
        else return -1;


    }


}
