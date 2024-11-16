package repository;


public interface FactoryRepository {
    DaoRepository<?> createRepository(String entityType);
}