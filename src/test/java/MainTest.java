import controllers.ControllerTest;
import controllers.ControllerTestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {
    ControllerTestRepository controllerTestRepository;

    @BeforeEach
    public void init() throws MalformedURLException {
        controllerTestRepository = new ControllerTestRepository();
        controllerTestRepository.registerTest(new ControllerTest(
                new URL("http://localhost:8080/webApi/viewStudentByParams?param=lastName&lookParam=Vasylevych"),
                "GET",
                "\"Student(id=1, lastName=Vasylevych, firstName=Oleh, subjectIds=[1, 2, 3, 4])\""));
        controllerTestRepository.registerTest(new ControllerTest(
                new URL("http://localhost:8080/webApi/viewTeacherByParams?param=lastName&lookParam=Sergiivna"),
                "GET",
                "\"Teacher(id=3, lastName=Sergiivna, firstName=Natalia, subjectIds=[3])\""));
        controllerTestRepository.registerTest(new ControllerTest(
                new URL("http://localhost:8080/webApi/viewStSj?id=1"),
                "GET",
                "[{\"id\":1,\"name\":\"AKM\"},{\"id\":2,\"name\":\"Java Programming\"},{\"id\":3,\"name\":\"GOF Patterns\"},{\"id\":4,\"name\":\"Front-end Development\"}]"));
        controllerTestRepository.registerTest(new ControllerTest(
                new URL("http://localhost:8080/webApi/viewTrSj?id=1"),
                "GET",
                "[{\"id\":2,\"name\":\"Java Programming\"}]"));
    }
    @Test
    public void test() throws Exception {
        controllerTestRepository.toTests();
    }
}
