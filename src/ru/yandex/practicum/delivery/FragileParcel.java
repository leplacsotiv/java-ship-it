package ru.yandex.practicum.delivery;


public class FragileParcel extends Parcel implements Trackable{

    private static final int baseRatio = 4;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description,weight,deliveryAddress,sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println(String.format("Посылка <<%s>> обёрнута в защитную плёнку",getDescription()));
        super.packageItem();
    }

    @Override
    public int getBaseRatio() {
        return baseRatio;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println(String.format("Хрупкая посылка <<%s>> изменила местоположение на %s",
                getDescription(),newLocation));
    }
}
