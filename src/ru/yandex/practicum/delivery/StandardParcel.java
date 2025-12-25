package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    private static final int BASE_RATIO = 2;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBaseRatio() {
        return BASE_RATIO;
    }
}
