package nextstep.subway.map.dto;

import java.io.Serializable;
import nextstep.subway.station.dto.StationResponse;

import java.util.List;

public class PathResponse implements Serializable {

    private static final long serialVersionUID = 4584953709074560634L;

    private List<StationResponse> stations;
    private int distance;

    public PathResponse() {
    }

    public PathResponse(List<StationResponse> stations, int distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }
}
