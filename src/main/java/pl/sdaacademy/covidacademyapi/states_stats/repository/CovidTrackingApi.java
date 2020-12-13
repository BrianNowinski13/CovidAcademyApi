package pl.sdaacademy.covidacademyapi.states_stats.repository;

import java.util.Date;

public interface CovidTrackingApi {

    StateCurrentStats[] getAllStatesCurrentStats();
    StateCurrentStats getSpecificStateOfStates(String state, String date);
}
