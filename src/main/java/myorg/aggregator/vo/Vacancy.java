package myorg.aggregator.vo;

import myorg.aggregator.model.ModelConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vacancy {
    private static Logger logger = LoggerFactory.getLogger(Vacancy.class);
    private String title;
    private String salary;
    private String city;
    private String companyName;
    private String siteName;
    private String url;

    public Vacancy() {
    }

    public Vacancy(String title, String salary, String city, String companyName, String siteName, String url) {
        this.title = title;
        this.salary = salary;
        this.city = city;
        this.companyName = companyName;
        this.siteName = siteName;
        this.url = url;
        //logger.debug(ModelConstants.LOGGER_DEBUG_VACANCY_CONSTRUCTOR, this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        if (getTitle() != null ? !getTitle().equals(vacancy.getTitle()) : vacancy.getTitle() != null) return false;
        if (getSalary() != null ? !getSalary().equals(vacancy.getSalary()) : vacancy.getSalary() != null) return false;
        if (getCity() != null ? !getCity().equals(vacancy.getCity()) : vacancy.getCity() != null) return false;
        if (!getCompanyName().equals(vacancy.getCompanyName())) return false;
        if (getSiteName() != null ? !getSiteName().equals(vacancy.getSiteName()) : vacancy.getSiteName() != null)
            return false;
        return getUrl() != null ? getUrl().equals(vacancy.getUrl()) : vacancy.getUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getSalary() != null ? getSalary().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + getCompanyName().hashCode();
        result = 31 * result + (getSiteName() != null ? getSiteName().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", salary='" + salary + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
