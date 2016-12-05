<<<<<<< HEAD
package com.example.sieunhan.github_client.api.service;

import com.example.sieunhan.github_client.api.PageIterator;
=======

package com.example.sieunhan.github_client.api.service;

import com.github.mobile.api.PageIterator;
>>>>>>> rebuilt-version

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

<<<<<<< HEAD
/**
 * Created by dannyle on 03/12/2016.
 */

=======
>>>>>>> rebuilt-version
public abstract class PaginationService<V> {
    public static final int ITEMS_PER_PAGE_DEFAULT = 30;
    public static final int ITEMS_PER_PAGE_MAX = 100;

<<<<<<< HEAD

    private final int initialPage;
    private final int itemsPerPage;


=======
    private final int initialPage;
    private final int itemsPerPage;

>>>>>>> rebuilt-version
    public PaginationService() {
        this.initialPage = 1;
        this.itemsPerPage = ITEMS_PER_PAGE_DEFAULT;
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    public PaginationService(int initialPage) {
        if (initialPage < 1) {
            this.initialPage = 1;
        } else {
            this.initialPage = initialPage;
        }

<<<<<<< HEAD

        this.itemsPerPage = ITEMS_PER_PAGE_DEFAULT;
    }


=======
        this.itemsPerPage = ITEMS_PER_PAGE_DEFAULT;
    }

>>>>>>> rebuilt-version
    public PaginationService(int initialPage, int itemsPerPage) {
        if (initialPage < 1) {
            this.initialPage = 1;
        } else {
            this.initialPage = initialPage;
        }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
        if (itemsPerPage <= 0) {
            this.itemsPerPage = ITEMS_PER_PAGE_DEFAULT;
        } else if (itemsPerPage > ITEMS_PER_PAGE_MAX) {
            this.itemsPerPage = ITEMS_PER_PAGE_MAX;
        } else {
            this.itemsPerPage = itemsPerPage;
        }
    }

<<<<<<< HEAD

    public abstract Collection<V> getSinglePage(int page, int itemsPerPage) throws IOException;


    public PageIterator getIterator() {
        return new PageIterator<V>(initialPage, itemsPerPage) {


=======
    public abstract Collection<V> getSinglePage(int page, int itemsPerPage) throws IOException;

    public PageIterator getIterator() {
        return new PageIterator<V>(initialPage, itemsPerPage) {

>>>>>>> rebuilt-version
            @Override
            protected Collection<V> getPage(int page, int itemsPerPage) {
                try {
                    return getSinglePage(page, itemsPerPage);
                } catch (IOException e) {
                    e.printStackTrace();
                }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
                return new ArrayList<>(0);
            }
        };
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    public Collection<V> getAll(PageIterator<V> iterator) {
        Collection<V> result = new ArrayList<>(itemsPerPage);
        while (iterator.hasNext()) {
            result.addAll(iterator.next());
        }
        return result;
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    public Collection<V> getAll() {
        return getAll(getIterator());
    }
}
<<<<<<< HEAD




=======
>>>>>>> rebuilt-version
