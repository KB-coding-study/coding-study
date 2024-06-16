import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class BJ_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        for(Integer key : keys) {
            Integer count = map.get(key);

            for(int m=0; m<count; m++) {
                System.out.print(key + " ");
            }
        }



    }


}
