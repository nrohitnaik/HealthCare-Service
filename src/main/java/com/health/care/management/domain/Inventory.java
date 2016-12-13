package com.health.care.management.domain;


public class Inventory {

    private int inventoryId;
    private String name;
    private String description;
    private int pricePerUnit;
    private String vendorContact;
    private String type;
    private int quantity;

    /**
     * @return the inventoryId
     */
    public int getInventoryId() {
        return this.inventoryId;
    }

    /**
     * @param inventoryId the inventoryId to set
     */
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pricePerUnit
     */
    public int getPricePerUnit() {
        return this.pricePerUnit;
    }

    /**
     * @param pricePerUnit the pricePerUnit to set
     */
    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * @return the vendorContact
     */
    public String getVendorContact() {
        return this.vendorContact;
    }

    /**
     * @param vendorContact the vendorContact to set
     */
    public void setVendorContact(String vendorContact) {
        this.vendorContact = vendorContact;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
