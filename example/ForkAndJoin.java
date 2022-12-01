package org.example;
//The fork/join framework is an implementation of the ExecutorService interface
// that helps you take advantage of multiple processors. It is designed for work that
// can be broken into smaller pieces recursively. The goal is to use all the available
// processing power to enhance the performance of your application.


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//import static com.learnjava.forkjoin.ForkJoinUsingRecursion.addNameLengthTransform;
//import static com.learnjava.util.CommonUtil.stopWatch;
import static org.example.CommonUtil.delay;
import static org.example.CommonUtil.stopWatch;

public class ForkAndJoin extends RecursiveTask<List<String>> {

    public ForkAndJoin(List<String> inputList) {
        this.inputList = inputList;
    }
    public static String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }

    private List<String> inputList;


    public static void main(String[] args) {
        stopWatch.start();
        List<String> finalList = new ArrayList<>();
        List<String> nameList = List.of("Chetan", "Sumit", "Prabjot", "Dixit");

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkAndJoin forkJoinUsingRecursion = new ForkAndJoin(nameList);
        finalList = forkJoinPool.invoke(forkJoinUsingRecursion);

        stopWatch.stop();
        System.out.println(("Final List : " + finalList));
        System.out.println(("Total Time Taken : " + stopWatch.getTime()));
    }

    @Override
    protected List<String> compute() {
        if (inputList.size() <= 1) {
            List<String> resultList = new ArrayList<>();
            inputList.forEach(name -> resultList.add(addNameLengthTransform(name)));
            return resultList;
        }
        int midpoint = inputList.size()/2;
        ForkJoinTask<List<String>> leftInputList =  new ForkAndJoin(inputList.subList(0,midpoint)).fork();
        inputList = inputList.subList(midpoint,inputList.size());
        List<String> rightResult =  compute(); // recursion will happen here
        List<String> leftResult =  leftInputList.join();
        leftResult.addAll(rightResult);
        return leftResult;
    }
}