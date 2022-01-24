package DAO.domain;

import java.util.List;
import java.util.Objects;

public class Page<T> {
    private final List<T> elements;
    private final List<String> numberOfPages;

    public Page(List<T> elements, List<String> numberOfPages) {
        this.elements = elements;
        this.numberOfPages = numberOfPages;
    }

    public List<T> getElements() {
        return elements;
    }

    public List<String> getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page<?> page = (Page<?>) o;

        if (!Objects.equals(elements, page.elements)) return false;
        return Objects.equals(numberOfPages, page.numberOfPages);
    }

    @Override
    public int hashCode() {
        int result = elements != null ? elements.hashCode() : 0;
        result = 31 * result + (numberOfPages != null ? numberOfPages.hashCode() : 0);
        return result;
    }
}
