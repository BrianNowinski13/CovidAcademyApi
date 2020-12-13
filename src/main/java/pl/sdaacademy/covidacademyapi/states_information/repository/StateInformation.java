package pl.sdaacademy.covidacademyapi.states_information.repository;

public class StateInformation {

    private String state;
    private String name;
    private String covid19Site;
    private String twitter;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCovid19Site() {
        return covid19Site;
    }

    public void setCovid19Site(String covid19Site) {
        this.covid19Site = covid19Site;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
