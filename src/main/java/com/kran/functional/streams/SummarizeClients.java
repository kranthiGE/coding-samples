package com.kran.functional.streams;

import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class SummarizeClients {
  public static void main(String[] args) {

    long time = System.currentTimeMillis();

    int numClients = 0;
    int totalQuarterlySpend = 0;
    UdacisearchClient nextExpiration = null;
    Set<ZoneId> representedZoneIds = new HashSet<>();
    Map<Year, Long> contractsPerYear = new HashMap<>();
    
    totalQuarterlySpend = ClientStore.getClients().stream()
                            .mapToInt(UdacisearchClient::getQuarterlyBudget)
                            .sum();

        int totalNumOfEmp = ClientStore.getClients().stream()
                                .filter(u -> u.getNumEmployees() > 5)
                                .mapToInt(UdacisearchClient::getQuarterlyBudget)
                                .sum();

    System.out.println("Avg number of employee");

    double avgClientBudget = ClientStore.getClients().stream()
                    .mapToInt(UdacisearchClient::getQuarterlyBudget)
                    .average()
                    .orElse(0d);
    
    long nextExpiryClientId = ClientStore.getClients().stream()
                    .min(Comparator.comparing(UdacisearchClient::getContractEnd))
                    .map(UdacisearchClient::getId)
                    .orElse(-1l);

    representedZoneIds = ClientStore.getClients().stream()
                    .flatMap(u -> u.getTimeZones().stream())
                    .collect(Collectors.toSet());
    
    contractsPerYear = ClientStore.getClients().stream()
                    .collect(
                        Collectors.groupingBy(UdacisearchClient::getContractYear,
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
  }
}
