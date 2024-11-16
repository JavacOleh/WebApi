package services;

import java.util.List;

public interface GroupService<T, E> {
    public List<T> getSubjects(E obj);
}
