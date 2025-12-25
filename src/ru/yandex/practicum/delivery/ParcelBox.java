package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels;
    private double maxWeight;

    public ParcelBox(double maxWeight) {
        parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        if (maxWeight >= parcel.getWeight()) {
            maxWeight -= parcel.getWeight();
            return parcels.add(parcel);
        }
        System.out.println("В коробке не хватает места (веса) для вашей посылки.");
        return false;
    }

    public List<T> getAllParcels() {
        return parcels;
    }

}
