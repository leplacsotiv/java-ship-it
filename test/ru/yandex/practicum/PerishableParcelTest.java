package ru.yandex.practicum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerishableParcelTest {

    private PerishableParcel createParcel() {
        return new PerishableParcel("Торт", 2, "Москва", 1, 5);
    }

    @Test
    public void TestCalculateDeliveryCost_Weight1(){
        Parcel parcel = new PerishableParcel("Селёдка",1.0,
                "Магадан", 1, 5);
        double cost = parcel.calculateDeliveryCost();
        assertEquals(3,cost,"Стоимость для веса 1 должна быть 1 * 3 = 3");
    }

    @Test
    public void testCalculateDeliveryCost_Weight0() {
        Parcel parcel = new PerishableParcel("Книга", 0.0,
                "Москва", 1,5);
        double cost = parcel.calculateDeliveryCost();
        assertEquals(0.0, cost, "Стоимость для веса 0 должна быть 0 * 3 = 0");
    }

    @Test
    public void testCalculateDeliveryCostWeight10() {
        Parcel parcel = new PerishableParcel("Книга", 10.0,
                "Москва", 1,5);
        double cost = parcel.calculateDeliveryCost();
        assertEquals(30, cost, "Стоимость для веса 10 должна быть 10 * 3 = 30");
    }

    @Test
    void testNotExpired() {
        PerishableParcel parcel = createParcel();
        assertFalse(parcel.isExpired(3));
    }

    @Test
    void testOnBoundary() {
        PerishableParcel parcel = createParcel();
        assertFalse(parcel.isExpired(6));
    }

    @Test
    void testExpired() {
        PerishableParcel parcel = createParcel();
        assertTrue(parcel.isExpired(10));
    }
}



