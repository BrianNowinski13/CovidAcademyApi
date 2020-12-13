package pl.sdaacademy.covidacademyapi.states_stats.web;

import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

@RequestMapping("/states")
@RestController
public class StatsOfSpecificStateController {

    private final StatsOfSpecificStateController statsOfSpecificStateController;


    public StatsOfSpecificStateController(StatsOfSpecificStateController statsOfSpecificStateController) {
        this.statsOfSpecificStateController = statsOfSpecificStateController;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{state}/{date}")
    @ResponseBody
    public StateCurrentStats getCurrentState(@PathVariable String state, @PathVariable String date) {
        return statsOfSpecificStateController.getCurrentState(state, date);
    }


    @GetMapping
    public StateCurrentStats[] getCurrentStateStats() {
        return statsOfSpecificStateController.getCurrentStateStats();
    }
}
