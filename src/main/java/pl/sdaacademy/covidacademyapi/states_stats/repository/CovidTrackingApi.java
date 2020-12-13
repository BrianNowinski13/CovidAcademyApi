package pl.sdaacademy.covidacademyapi.states_stats.repository;

public interface CovidTrackingApi {
    StateInformation[] getAllStatesInformation();

    StateCurrentStats[] getAllStatesCurrentStats();

    StateCurrentStats getSpecificStateOfStates(String state, String date);
}
