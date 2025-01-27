package nextstep.subway.line.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LineRepository extends JpaRepository<Line, Long> {

    @Query("select l from Line l where l.id >= :startId")
    Page<Line> findAll(long startId, Pageable pageable);
}
