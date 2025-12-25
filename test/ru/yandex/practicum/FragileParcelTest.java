package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.Parcel;

import static org.junit.jupiter.api.Assertions.*;

public class FragileParcelTest {

    @Test
    public void testCalculateDeliveryCost_Weight1() {
        Parcel parcel = new FragileParcel("Книга", 1, "Москва", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(4.0, cost, "Стоимость для веса 1 должна быть 1 * 4 = 4");
    }

    @Test
    public void testCalculateDeliveryCost_Weight5() {
        Parcel parcel = new FragileParcel("Ящик", 5, "СПб", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(20.0, cost, "Стоимость для веса 5 должна быть 5 * 4 = 20");
    }

    @Test
    public void testCalculateDeliveryCost_Weight0() {
        Parcel parcel = new FragileParcel("Пусто", 0, "Казань", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(0.0, cost, "Стоимость для веса 0 должна быть 0 * 2 = 0");
    }


}
