package sortingparks;

/**
 * Created by danawacomputer on 2017-04-19.
 */
public class Park {
    private String park_key;
    private String park_name;
    private String park_alias;
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "Park{" +
                "park_key='" + park_key + '\'' +
                ", park_name='" + park_name + '\'' +
                ", park_alias='" + park_alias + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Park(String park_key, String park_name, String park_alias,
                String city, String state, String country) {
        this.park_key = park_key;
        this.park_name = park_name;
        this.park_alias = park_alias;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getPark_key() {
        return park_key;
    }

    public void setPark_key(String park_key) {
        this.park_key = park_key;
    }

    public String getPark_name() {
        return park_name;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public String getPark_alias() {
        return park_alias;
    }

    public void setPark_alias(String park_alias) {
        this.park_alias = park_alias;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
