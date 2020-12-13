package pl.sdaacademy.covidacademyapi.states_information.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_information.service.StatesInformationService;

import java.util.List;


@RequestMapping("/states")
@RestController
public class StatesInformationController {

    private final StatesInformationService statesInformationService;

    public StatesInformationController(StatesInformationService statesInformationService) {
        this.statesInformationService = statesInformationService;
    }

    @GetMapping("/information")
    public List<StateInformation> getCurrentStateInformation() {
        return statesInformationService.getAllStatesInformation();
    }


}
