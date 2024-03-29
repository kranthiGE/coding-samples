package com.kran.concurrency.synchronization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VotingAppOpen {
    
    private final Map<String, Integer> votes = new HashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(12);
    private final Integer MAX_FUTURES = 10000;

    public void cast(String candidate) 
        throws InterruptedException, ExecutionException{
        List<Future<?>> futures = new ArrayList<>(MAX_FUTURES);
        for(int i = 0; i < MAX_FUTURES; i++){
            futures.add(
                executorService.submit(() -> {
                    votes.compute(candidate, (k, v) -> (v == null) ? 1 : v + 1);
          }));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        executorService.shutdown();

        System.out.println(votes);
    }

    public static void main(String[] args){
        VotingAppOpen votingAppOpen = new VotingAppOpen();
        try {
            votingAppOpen.cast("kiran");
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
