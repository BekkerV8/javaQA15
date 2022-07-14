package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketsManager manager = new TicketsManager();
    private Ticket ticket1 = new Ticket(1, 1000, "SEA", "HNL",100);
    private Ticket ticket2 = new Ticket(2, 2000, "SEA", "HNL",100);
    private Ticket ticket3 = new Ticket(3, 3000, "NYC", "SEA",100);
    private Ticket ticket4 = new Ticket(4, 3000, "NYC", "SEA",100);
    private Ticket ticket5 = new Ticket(5, 3500, "NYC", "SEA",100);
    private Ticket ticket6 = new Ticket(6, 3500, "SEA", "HNL",100);

    @BeforeEach
    public void set() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldSortByCost() {
        Ticket[] actual = manager.findAll("SEA", "HNL");
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket6};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByEqualCost() {
        Ticket[] actual = manager.findAll("NYC", "SEA");
        Ticket[] expected = new Ticket[]{ticket3, ticket4, ticket5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByCostWithDifferent() {
        Ticket[] actual = manager.findAll("SEA", "NYC");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotFound() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("DOM", "NYC");

        assertArrayEquals(expected, actual);
    }


}
