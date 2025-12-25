package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int BASE_RATIO = 3;
    private int timeToLive;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive < currentDay;
    }

    @Override
    public int getBaseRatio() {
        return BASE_RATIO;
    }


}
