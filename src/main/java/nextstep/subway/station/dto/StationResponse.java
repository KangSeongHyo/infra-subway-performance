package nextstep.subway.station.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.subway.station.domain.Station;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class StationResponse implements Serializable {
    private static final long serialVersionUID = 4473542076182413388L;

    private Long id;
    private String name;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime modifiedDate;

    public static StationResponse of(Station station) {
        return new StationResponse(station.getId(), station.getName(), station.getCreatedDate(), station.getModifiedDate());
    }

    public static Page<StationResponse> ofListToPage(Page<Station> stations) {
        List<StationResponse> stationResponses = stations.getContent().stream()
                                                            .map(StationResponse::of)
                                                            .collect(Collectors.toList());
        return new PageImpl<>(stationResponses, stations.getPageable(), stations.getTotalElements());
    }


    public StationResponse() {
    }

    public StationResponse(Long id, String name, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
