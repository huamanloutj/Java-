package DataStructure.Heap;

import java.util.Comparator;

import java.util.PriorityQueue;

import java.util.Queue;

import java.util.Random;



public class PriorityQueueE {



    public static void main(String[] args) {



        //优先队列自然排序示例

        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);

        Random rand = new Random();

        for(int i=0;i<7;i++){

            integerPriorityQueue.add(new Integer(rand.nextInt(100)));

        }
        System.out.println(integerPriorityQueue);
        for(int i=0;i<7;i++){

            Integer in = integerPriorityQueue.poll();

            System.out.println("Processing Integer:"+in);

        }



        //优先队列使用示例





    }



    //匿名Comparator实现





    //用于往队列增加数据的通用方法




}