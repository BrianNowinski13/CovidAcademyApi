package pl.sdaacademy.covidacademyapi.states_stats.repository;

import pl.sdaacademy.covidacademyapi.states_information.repository.StateInformation;

public interface CovidTrackingApi {

    StateCurrentStats[] getAllStatesCurrentStats();

    StateCurrentStats getSpecificStateOfStates(String state, String date);


}
