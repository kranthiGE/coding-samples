package com.kran.concurrency.synchronization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class VotingApp {
    
    private static final int MAX_FUTURES = 10000;

    public void vote(){

        // create a map to store votes
        Map<String, Integer> votes = new HashMap<>();

        // add votes for a user concurrently
        ExecutorService pool = Executors.newFixedThreadPool(12);
        List<Future<?>> futures = new ArrayList<>(MAX_FUTURES);

        // create reentrant lock
        final Lock lock = new ReentrantLock();

        for(int i = 0; i < MAX_FUTURES; i++){
            futures.add(
                pool.submit(() -> {
                    lock.lock();
                    try{
                        votes.compute("kiran", (k, v) -> (v == null) ? 1 : v + 1);
                    } finally {
                        lock.unlock();
                    }
                }));
        }

        futures.stream().forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();

        System.out.println(votes);
    }

    public void concurrentVote(){
        // create a map to store votes
        Map<String, Integer> votes = new ConcurrentHashMap<>();

        // add votes for a user concurrently
        ExecutorService pool = Executors.newFixedThreadPool(12);
        List<Future<?>> futures = new ArrayList<>(MAX_FUTURES);

        for(int i = 0; i < MAX_FUTURES; i++){
            futures.add(
                pool.submit(() -> {
                    votes.compute("kiran", (k, v) -> (v == null) ? 1 : v + 1);
                }));
        }

        futures.stream().forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();

        System.out.println(votes);
    }

    public static void main(String[] args) {
        // using hashmap
        VotingApp votingApp = new VotingApp();
        votingApp.vote();
        votingApp.concurrentVote();
    }
}
