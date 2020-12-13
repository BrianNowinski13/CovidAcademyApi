package pl.sdaacademy.covidacademyapi.states_stats.repository;

public interface CovidTrackingApi {

    StateCurrentStats[] getAllStatesCurrentStats();
    StateCurrentStats[] getSpecificStateOfStates();
}
