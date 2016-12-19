package com.health.care.management.dao;

import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.util.List;

public interface InventoryDAO {

	/**
	 * to fetch all the inventory
	 * 
	 * @return List<Inventory>
	 */
	List<Inventory> fetchAllInventory();

	/**
	 * update inventory based on id
	 * 
	 * @param inventory
	 * @return rows updated
	 */
	int updatedInventory(Inventory inventory);

	/**
	 * saves inventory
	 * 
	 * @param inventory
	 * @return
	 * 
	 */
	int addInventory(Inventory inventory);

	/**
	 * saves bill
	 * 
	 * @param bill
	 * @return
	 * 
	 */
	int saveBill(Bill bill);

}
