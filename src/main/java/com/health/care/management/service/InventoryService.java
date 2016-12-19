package com.health.care.management.service;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.util.List;

public interface InventoryService {

    /**
     * @return
     */
    List<Inventory> getAllInventory();

    /**
     * @param inventory
     * @return
     */
    int updateInventory(Inventory inventory);

    /**
     * @param inventory
     * @return
     */
    int saveInventory(Inventory inventory);

    /**
     * @param status
     * @return
     */
    List<Bill> fetchAllDiagnoisedDetail(String status);

    /**
     * @param bill
     * @return
     */
    int saveBill(Bill bill);

    /**
     * @param selectedReportvalue
     * @return
     */
    String generateReport(int selectedReportvalue);
}
