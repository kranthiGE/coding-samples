package com.kran.functional.streams;

import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public final class SummarizeClientsForLargeStore {
  public static void main(String[] args) {

    int totalQuarterlySpend = 0;
    double avgClientBudget = 0d;
    long nextExpiryClientId = 0l;

    Set<ZoneId> representedZoneIds = new HashSet<>();
    Map<Year, Long> contractsPerYear = new HashMap<>();

    ForkJoinPool pool = null;
    try {
    long time = System.currentTimeMillis();
      // create fork join pool
      pool = new ForkJoinPool();

      Future<Integer> totalQuarterlySpendFuture = pool
          .submit(() -> LargeClientStore.getClients().parallelStream().mapToInt(UdacisearchClient::getQuarterlyBudget).sum());
      totalQuarterlySpend = totalQuarterlySpendFuture.get();
    
      Future<Double> avgClientBudgetFuture = pool
          .submit(() -> LargeClientStore.getClients().parallelStream()
          .mapToInt(UdacisearchClient::getQuarterlyBudget)
          .average()
          .orElse(0d));
      avgClientBudget = avgClientBudgetFuture.get();
      
      Future<Long> nextExpiryClientIdFuture = pool
          .submit(() -> LargeClientStore.getClients().parallelStream()
          .min(Comparator.comparing(UdacisearchClient::getContractEnd))
          .map(UdacisearchClient::getId)
          .orElse(-1l));
      nextExpiryClientId = nextExpiryClientIdFuture.get();

      Future<Set<ZoneId>> representedZoneIdsFuture = pool
          .submit(() -> LargeClientStore.getClients().parallelStream()
          .flatMap(u -> u.getTimeZones().stream())
          .collect(Collectors.toSet()));
      representedZoneIds = representedZoneIdsFuture.get();
      
      contractsPerYear = LargeClientStore.getClients().parallelStream()
                      .collect(
                          Collectors.groupingByConcurrent(UdacisearchClient::getContractYear,
                          Collectors.counting()
                          )
                      );

      System.out.println("Using stream API ");
      System.out.println("Total quarterly spend: " + totalQuarterlySpend);
      System.out.println("Average budget: " + avgClientBudget);
      System.out.println("ID of next expiring contract: " + nextExpiryClientId);
      System.out.println("Client time zones: " + representedZoneIds);
      System.out.println("Contracts per year: " + contractsPerYear);

      System.out.println(System.currentTimeMillis() - time);

    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    finally{
      if(pool != null)
        pool.shutdown();
    }
  }
}
