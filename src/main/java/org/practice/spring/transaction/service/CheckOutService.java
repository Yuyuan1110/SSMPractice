package org.practice.spring.transaction.service;

public interface CheckOutService {
    void checkOut(int[] bookIDs, int userID);
}
