package com.petpals.entity;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, String itemType) {
        super(donorName, 0); // item donation = no cash
        this.itemType = itemType;
    }

    public String getItemType() { return itemType; }

    @Override
    public void recordDonation() {
        System.out.println("Item Donation: " + donorName + " - Item: " + itemType);
    }
}
