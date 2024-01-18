package myorg.aggregator;

import myorg.aggregator.controller.Controller;
import myorg.aggregator.model.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    @Mock
    Model mockModel;


    @Test
    void doSearch() {
        Controller controller = new Controller(mockModel);
        controller.doSearch("test searching string");
        Mockito.verify(mockModel, Mockito.times(1)).doSearch("test searching string");
    }
}