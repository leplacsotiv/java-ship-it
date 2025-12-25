package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    private StandardParcel createParcel(int weight) {
        return new StandardParcel("Тест", weight, "Москва", 1);
    }

    @Test
    public void testAddParcel_BelowMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        boolean added = box.addParcel(createParcel(3));

        assertTrue(added, "Посылка должна добавляться, если вес не превышает лимит");
        assertEquals(1, box.getAllParcels().size(), "В коробке должна быть 1 посылка");
    }

    @Test
    public void testAddParcel_ExactlyMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        boolean added1 = box.addParcel(createParcel(6));
        boolean added2 = box.addParcel(createParcel(4));

        assertTrue(added1, "Первая посылка должна добавиться");
        assertTrue(added2, "Вторая должна добавиться, т.к. суммарный вес ровно maxWeight");
        assertEquals(2, box.getAllParcels().size(), "В коробке должно быть 2 посылки");
    }

    @Test
    public void testAddParcel_OverMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        boolean added1 = box.addParcel(createParcel(7));
        boolean added2 = box.addParcel(createParcel(5));

        assertTrue(added1, "Первая посылка должна добавиться");
        assertFalse(added2, "Вторая не должна добавляться при превышении лимита");
        assertEquals(1, box.getAllParcels().size(), "В коробке должна остаться только 1 посылка");
    }
}
