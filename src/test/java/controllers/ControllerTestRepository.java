package controllers;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ControllerTestRepository {
    private List<ControllerTest> controllerTests = new ArrayList<>();

    public void registerTest(ControllerTest test) {
        controllerTests.add(test);
    }

    public void toTests() throws Exception {
        for (ControllerTest controllerTest : controllerTests) {
            controllerTest.toTest();
        }
    }
}
