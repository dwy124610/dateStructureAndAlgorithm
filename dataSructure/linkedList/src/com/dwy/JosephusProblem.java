package com.dwy;

/** 已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。从编号为1的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，数到m的那个人又出列
 * ；依此规律重复下去，直到圆桌周围的人全部出列。（也类似于变态杀人狂问题）通常解决这类问题时我们把编号从0~n-1，最后结果+1即为原问题的解

 * @Author: DongWenYu
 * @Date: 2021/6/15 17:09
 */
public class JosephusProblem {
    public static void main(String[] args) {
        //总共有10个人
        int num = 10;
        //数到3出列
        int number = 3;
        System.out.println(Solution(num,number));
    }
    public static String Solution(int num , int number){
        //出去顺序结果
        String result = "";
        //计数器,达到number就离开队列
        int count = 1;
        //初始化容量为num
        int size = num;
        //当前位置
        int cur = 0;
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList();
        for (int i = 1 ; i <= num ; i++){
            circleLinkedList.add(i);
        }
        while (size > 1){
            if (count % number == 0){
                result = result.concat(",").concat(String.valueOf(circleLinkedList.get(cur)));
                size--;
                circleLinkedList.remove(cur);
                cur --;
            }
            count++;
            cur++;
            if (cur == size ){
                cur = 0;
            }
        }
        return result;
    }
}
