package myorg.aggregator.vo;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    private static Logger logger = LoggerFactory.getLogger(Vacancy.class);
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;
}
