package ra.projectMD2.business.design;

import java.util.List;

public interface IGenericDesign<T, E> {
    void displayAll();

    T findById(E id);

    void addNew();

    void edit();

    void deleteById(E id);
}

