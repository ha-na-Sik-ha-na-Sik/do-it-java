package dongmoo.resolving;

import java.util.*;

public class MethodPractice {
    public static void main(String[] args) {
        char a = '0';
        System.out.println(String.valueOf(a));


        String b = "AAAAAAAAAAAAAAAA";
        int target = 10;
        b.substring(0,target+1);

        Math.max(1, 2);
        Math.min(1, 2);
        Math.sqrt(4);
        Math.abs(-4);
        Math.pow(2, 3); //2^3 -> a^b

        Queue<String> myQueue = new LinkedList<>();
        String poll = myQueue.poll();//피크값(가장 처음 들어온 것), 삭제
        String peek = myQueue.peek();//피크값, 삭제 x -> 없으면 null

        Stack<Integer> stack = new Stack<>();
        stack.push(1); //삽입
        stack.push(2); //삽입
        stack.pop();    // 피크값(가장 나중에 들어온것), 삭제
        stack.peek();   // 피크값, 삭제 x

        System.out.println(String.format("%-10s",b)); //뒤쪽 공백
        System.out.println(String.format("%10s",b)); //앞쪽 공백
        System.out.println(String.format("%,3d",123456789)); //사이 콤사 추가

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());


        Integer integer = list.stream().reduce(Integer::min).get();
        list.stream().reduce(Integer::max).get();
        list.stream().reduce(Integer::sum).get();

        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());

    }
}
