package com.health.care.management.dao.impl;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.InventoryDAO;
import com.health.care.management.domain.Bill;
import com.health.care.management.domain.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class InventoryDAOImpl implements InventoryDAO {

    private JdbcTemplate jdbcTemplate;

    public InventoryDAOImpl() {
        super();
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    @Override
    public List<Inventory> fetchAllInventory() {
        return jdbcTemplate.query(Constant.FETCH_ALL_INVENTORIES, new InventoryRowMapper());
    }

    @Override
    public int updatedInventory(Inventory inventory) {
        return jdbcTemplate.update(Constant.UPDATE_INVENTORY,
                new Object[] { inventory.getName(), inventory.getDescription(), inventory.getQuantity(), inventory.getPricePerUnit(), inventory.getVendorContact(),
                        inventory.getType(), inventory.getInventoryId() });

    }

    @Override
    public int addInventory(Inventory inventory) {
        return jdbcTemplate.update(Constant.SAVE_INVENTORY, new Object[] { inventory.getName(),
                inventory.getDescription(), inventory.getQuantity(), inventory.getPricePerUnit(), inventory.getVendorContact(), inventory.getType() });
    }

    @Override
    public int saveBill(Bill bill) {
        return jdbcTemplate.update(Constant.SAVE_BILL, new Object[] {
                bill.getPatientName(), bill.getDoctorName(), bill.getBillAmount(), bill.getComment(), bill.getComment(), bill.getDiagnosisId(), bill.getPatientId() });

    }

    private class InventoryRowMapper implements RowMapper<Inventory> {

        @Override
        public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
            Inventory inventory = new Inventory();
            inventory.setInventoryId(rs.getInt("inventory_id"));
            inventory.setName(rs.getString("name"));
            inventory.setDescription(rs.getString("description"));
            inventory.setPricePerUnit(rs.getInt("price_per_unit"));
            inventory.setVendorContact(rs.getString("vendor_contact"));
            inventory.setType(rs.getString("type"));
            inventory.setQuantity(rs.getInt("quantity"));
            return inventory;
        }

    }

}
