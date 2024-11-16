package services.logger;

//Strategy + Decorator
public interface LogStrategy {
    void log(String message);
}