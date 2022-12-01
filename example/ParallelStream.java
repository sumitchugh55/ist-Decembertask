package org.example;

//Parallel stream leverage multi-core processors,
// which increases its performance. Using parallel streams,
// our code gets divide into multiple streams which can be executed parallelly
// on separate cores of the system and the final result is shown as the combination
// of all the individual core’s outcomes. It is always not necessary that the whole
// program be parallelized, but at least some parts should be parallelized which handles the stream.
// The order of execution is not under our control and can give us unpredictably unordered results and
// like any other parallel programming, they are complex and error-prone.
// Java code to demonstrate
// ParallelStreams


import java.util.*;



class ParallelStream {
    public static void main(String[] args)
    {

        // create a list
        List<String> list = Arrays.asList("My name is ",
                "S", "u", "m", "i", "t");

        // using parallelStream()
        // method for parallel stream
        list.parallelStream().forEach(System.out::print);

    }
}

