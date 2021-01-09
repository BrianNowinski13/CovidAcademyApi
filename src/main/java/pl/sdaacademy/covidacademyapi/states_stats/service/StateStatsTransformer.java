package pl.sdaacademy.covidacademyapi.states_stats.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;
import pl.sdaacademy.covidacademyapi.states_stats.repository.StateCurrentStats;

@Component
public class StateStatsTransformer {

    public StateStatsDTO stateStatsDTO(StateCurrentStats stateCurrentStats, StateInformation stateInformation) {
        StateStatsDTO stateStatsDTO = new StateStatsDTO();
        stateStatsDTO.setStateInformation(stateInformation);
        stateStatsDTO.setNegative(stateCurrentStats.getNegative());
        stateStatsDTO.setPositive(stateCurrentStats.getPositive());
        stateStatsDTO.setRecovered(stateCurrentStats.getRecovered());
        stateStatsDTO.setDeathConfirmed(stateCurrentStats.getDeathConfirmed());
        return stateStatsDTO;
    }

}
