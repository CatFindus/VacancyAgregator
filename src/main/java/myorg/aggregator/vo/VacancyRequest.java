package myorg.aggregator.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VacancyRequest {
    private String searchRequest;
    private boolean habrSearch;
    private boolean hhSearch;
    private boolean liSearch;
    private boolean rrSearch;
}
