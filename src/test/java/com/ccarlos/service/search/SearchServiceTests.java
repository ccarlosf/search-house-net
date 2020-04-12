package com.ccarlos.service.search;

import com.ccarlos.SearchHouseNetApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SearchServiceTests extends SearchHouseNetApplicationTests {

    @Autowired
    private ISearchService searchService;

    @Test
    public void testIndex() {
        Long targetHouseId = 15L;
        searchService.index(targetHouseId);
    }

    @Test
    public void testRemove() {
        Long targetHouseId = 15L;
        searchService.remove(targetHouseId);
    }
}
