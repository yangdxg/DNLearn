package com.yangdxg.datastructure;

import android.util.Log;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSwap() {
        int a = 5;
        int b = 6;
        //1.可读性最好(不影响用户体验情况下，优先选择可读性最好的情况下)
        int t = a;
        a = b;
        b = t;
        //2.对象无法使用
        a = a + b;
        b = a - b;
        a = a - b;
        //3.性能最优(没有可读性，应用于无人机，跑步机，车载系统等要求性能高的情况下)
        // 异或相同去0，不同取1
        // a:101  b:110
        a = a ^ b;//a: 011
        b = a ^ b;//b：101
        a = a ^ b;//c: 110
        System.out.print("a=" + a + "  b=" + b);
    }

    //排序
    @Test
    public void testCards() {
        Cards[] cards = {
                new Cards(3, 9),
                new Cards(2, 7),
                new Cards(1, 1),
                new Cards(3, 3),
                new Cards(4, 4),
                new Cards(2, 5),
                new Cards(3, 6),
                new Cards(3, 7),
        };
        //效率很低，执行代码至少在一百行以上
//        Arrays.sort(cards);
        bubbleSort(cards);
        for (Cards card : cards) {
            System.out.println(card.toString());
        }
    }

    //冒泡排序
    //每次把最大值移到最后
    //执行n(n-1)/2次
    //时间复杂度n*(n-1)/2
    @Test
    public void testSort() {
        int array[] = {1, 2, 1, 4, 9, 8, 4, 3, 8};
        bubbleSort(array);
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    public static Cards[] bubbleSort(Cards[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Cards temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {//如果已经是最小的，不需要交换
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                System.out.println(index);
            }
            ArrayList
        }
    }

}