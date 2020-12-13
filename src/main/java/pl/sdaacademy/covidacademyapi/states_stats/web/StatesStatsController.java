package pl.sdaacademy.covidacademyapi.states_stats.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;
import pl.sdaacademy.covidacademyapi.states_stats.service.StatesStatsService;

@RequestMapping("/states")
@RestController
public class StatesStatsController {

    private final StatesStatsService statesStatsService;

    public StatesStatsController(StatesStatsService statesStatsService) {
        this.statesStatsService = statesStatsService;
    }

    @GetMapping
    public StateCurrentStats[] getCurrentStateStats() {
        return statesStatsService.getAllStatesCurrentStats();
    }

    @GetMapping("/{state}/{date}")
    public StateCurrentStats getCurrentState(@PathVariable String state, @PathVariable String date) {
        return statesStatsService.getCurrentState(state, date);
    }


}
