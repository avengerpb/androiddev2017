<<<<<<< HEAD
package com.example.sieunhan.github_client.api;

=======

package com.example.sieunhan.github_client.api;
>>>>>>> rebuilt-version
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

<<<<<<< HEAD
/**
 * Created by dannyle on 03/12/2016.
 */

public abstract class PageIterator<V> implements Iterator<Collection<V>> {
    private final int itemsPerPage;


    private int nextPage;


=======
public abstract class PageIterator<V> implements Iterator<Collection<V>> {
    private final int itemsPerPage;

    private int nextPage;

>>>>>>> rebuilt-version
    public PageIterator(int initialPage, int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        this.nextPage = initialPage;
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    @Override
    public boolean hasNext() {
        return this.nextPage != -1;
    }

<<<<<<< HEAD

=======
>>>>>>> rebuilt-version
    @Override
    public Collection<V> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

<<<<<<< HEAD

        Collection<V> resources = getPage(nextPage, itemsPerPage);


=======
        Collection<V> resources = getPage(nextPage, itemsPerPage);

>>>>>>> rebuilt-version
        if (resources.size() == 0) {
            nextPage = -1;
        } else {
            ++nextPage;
        }

<<<<<<< HEAD

        return resources;
    }


=======
        return resources;
    }

>>>>>>> rebuilt-version
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

<<<<<<< HEAD

    protected abstract Collection<V> getPage(int page, int itemsPerPage);
}





=======
    protected abstract Collection<V> getPage(int page, int itemsPerPage);
}
>>>>>>> rebuilt-version
