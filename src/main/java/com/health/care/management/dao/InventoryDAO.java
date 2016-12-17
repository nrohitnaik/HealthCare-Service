package com.health.care.management.dao;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.util.List;

public interface InventoryDAO {

    /**
     * @return  List<Inventory>
     * to fetch all the inventory
     */
    List<Inventory> fetchAllInventory();

    /**
     * @param inventory
     * @return rows updated
     * update inventory based on id
     */
    int updatedInventory(Inventory inventory);

    /**
     * @param inventory
     * @return
     * saves inventory
     */
    int addInventory(Inventory inventory);

    /**
     * @param bill
     * @return
     * saves bill
     */
    int saveBill(Bill bill);


}
