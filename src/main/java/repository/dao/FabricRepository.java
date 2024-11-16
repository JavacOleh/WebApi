package repository.dao;

import repository.DaoRepository;
import repository.FactoryRepository;
import services.logger.LogStrategy;

public class FabricRepository implements FactoryRepository {
    private final LogStrategy logStrategy;

    public FabricRepository(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    @Override
    public DaoRepository<?> createRepository(String entityType) {
        switch (entityType) {
            case "student" -> {
                logStrategy.log("created new class StudentRepository");
                return new StudentRepository();
            }
            case "teacher" -> {
                logStrategy.log("created new class TeacherRepository");
                return new TeacherRepository();
            }
            case "subject" -> {
                logStrategy.log("created new class SubjectRepository");
                return new SubjectRepository();
            }
            default -> throw new IllegalArgumentException("Unknown entity type");
        }
    }
}