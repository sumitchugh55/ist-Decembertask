package org.example;

// system hence it never takes the advantage of the multi-core system even though the underlying
// system supports parallel execution. Sequential stream performs operation one by one.
import java.util.*;

import static org.example.CommonUtil.stopWatch;


class SequentialStream{

    public static void main(String[] args)

    {  stopWatch.start();
        // create a list
        List<String> list = Arrays.asList( "My name is ",
                "S", "u", "m", "i", "t");

        // we are using stream() method
        // for sequential stream
        // Iterate and print each element
        // of the stream
        list.stream().forEach(System.out::print);
    }
}


