/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Covering {

    private Route route;
    private Trip trip;

    public Covering(Route route, Trip trip) {
        this.route = route;
        this.trip = trip;
    }

    public Covering() {
        this(null, null);
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
