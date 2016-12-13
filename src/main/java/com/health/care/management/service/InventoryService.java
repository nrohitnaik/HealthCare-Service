package com.health.care.management.service;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventory();

    int updateInventory(Inventory inventory);

    int saveInventory(Inventory inventory);

    List<Bill> fetchAllDiagnoisedDetail(String status);

    int saveBill(Bill bill);
}
