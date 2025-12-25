package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParcelTest {

    @Test
    public void testCalculateDeliveryCost_Weight1() {
        StandardParcel parcel = new StandardParcel("Книга", 1, "Москва", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(2.0, cost, "Стоимость для веса 1 должна быть 1 * 2 = 2");
    }

    @Test
    public void testCalculateDeliveryCost_Weight5() {
        StandardParcel parcel = new StandardParcel("Ящик", 5, "СПб", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(10.0, cost, "Стоимость для веса 5 должна быть 5 * 2 = 10");
    }

    @Test
    public void testCalculateDeliveryCost_Weight0() {
        StandardParcel parcel = new StandardParcel("Пусто", 0, "Казань", 1);

        double cost = parcel.calculateDeliveryCost();
        
        assertEquals(0.0, cost, "Стоимость для веса 0 должна быть 0 * 2 = 0");
    }


}
