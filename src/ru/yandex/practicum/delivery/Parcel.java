package ru.yandex.practicum.delivery;

public abstract class Parcel {

    private String description;
    private double weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem(){
        System.out.printf("Посылка <<%s>> упакована%n",description);
    };

    public void deliver(){
        System.out.printf("Посылка <<%s1>> доставлена по адресу %s2%n",description,deliveryAddress);
    };

    public double calculateDeliveryCost(){
        return weight * getBaseRatio();
    };


    abstract int getBaseRatio();


    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

}
