package repository;

import java.util.List;

public interface DaoRepositoryImpl<T> {
    void save(T t);
    void delete(T t);
    T getById(int id);
    T getByString(String strParam, String strLookParam);
    List<T> getList();

}
