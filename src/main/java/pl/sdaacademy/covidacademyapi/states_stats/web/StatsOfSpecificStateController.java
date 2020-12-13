package pl.sdaacademy.covidacademyapi.states_stats.web;

import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

import java.util.Date;

@RequestMapping("/states")
@RestController
public class StatsOfSpecificStateController {

    private final StatsOfSpecificStateController statsOfSpecificStateController;


    public StatsOfSpecificStateController(StatsOfSpecificStateController statsOfSpecificStateController) {
        this.statsOfSpecificStateController = statsOfSpecificStateController;
    }
    @RequestMapping(method = RequestMethod.GET,path = "/{state}")
    @ResponseBody
    public StateCurrentStats[] getCurrentState(@PathVariable(name = "state")final String state ) {
        return statsOfSpecificStateController.getCurrentState(state);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/state/{date}")
    @ResponseBody
    public StateCurrentStats[] getCurrentState(@PathVariable(name = "date")final Date date ) {
        return statsOfSpecificStateController.getCurrentState(date);
    }



    @GetMapping
    public StateCurrentStats[] getCurrentStateStats() {
        return statsOfSpecificStateController.getCurrentStateStats();
    }
}
