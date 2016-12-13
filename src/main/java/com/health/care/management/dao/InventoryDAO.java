package com.health.care.management.dao;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.util.List;

public interface InventoryDAO {

    // to fetch all the inventory
    List<Inventory> fetchAllInventory();

    // update inventory based on id
    int updatedInventory(Inventory inventory);

    int addInventory(Inventory inventory);

    int saveBill(Bill bill);


}
