package com.example.demo.controllers;

import com.example.demo.TestUtils;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.repositories.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemControllerTest {

    private ItemController itemController;
    private ItemRepository itemRepository = mock(ItemRepository.class);

    @Before
    public void setUp() {
        itemController = new ItemController();
        TestUtils.injectObjects(itemController, "itemRepository", itemRepository);
    }

    @Test
    public void get_all_items_happy_path() {
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setName("Round gadget");
        items.add(item);
        when(itemRepository.findAll()).thenReturn(items);

        ResponseEntity response = itemController.getItems();
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}
