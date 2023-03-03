package com.javatunes.catalog;


import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    // findRockBottom Test
    @Test
    public void findRockBottom_should_when() {
    }

    @Test
    public void findSelfTitle_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        // size should be two, ids are 6 and 7 in that order
        assertEquals(2,items.size());

        // I need to extract (get) the first one and make sure its id is 6, then the 2nd one
        List<MusicItem> itemList = new ArrayList<>(items);
        itemList.sort(null);  // sorts by natural order (MusicItem's natural order is id)
        // now you can say itemslIST.GET(0) AND check its id for 6
        assertEquals(6L, itemList.get(0).getId().longValue());
        assertEquals(7L, itemList.get(1).getId().longValue());

    }

    // getAll Test
    @Test(expected=UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear();  // should trigger unsupportedOperationException
    }

    // findByCategory Test
    @Test
    public void findByCategory_shouldReturnCollection_whenSuppliedGenre() {
        Collection<MusicItem> result = catalog.findByCategory(MusicCategory.ROCK);
        assertEquals(6,result.size());
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_whenGenreNotSupplied() {
        Collection<MusicItem> result = catalog.findByCategory(null);
        assertTrue(result.isEmpty());
    }

    // findByKeyword Test
    @Test
    public void findByKeyword_shouldReturnCollection_whenKeywordMatch() {
        Collection<MusicItem> result = catalog.findByKeyword("Diva");
        assertEquals(1,result.size());
    }

    @Test
    public void findByKeyword_shouldReturnEmptyCollection_whenKeywordNotMatch() {
        Collection<MusicItem> result = catalog.findByKeyword("park");
        assertTrue(result.isEmpty());
    }

    // findById Test
    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_whenIdFound() {
        MusicItem item = catalog.findById(12L);
        // extract long primitive from long wrapper
        assertEquals(12L,item.getId().longValue());  // assertEquals(Object, Object)
        assertTrue(12 == item.getId());
    }

}