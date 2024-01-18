package myorg.aggregator;

import myorg.aggregator.model.*;
import myorg.aggregator.view.View;
import myorg.aggregator.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class ModelTest {
    @Mock
    HabrCareerStrategy mockHABRCareerStrategy;
    @Mock
    HHStrategy mockHHStrategy;
    @Mock
    LinkedinStrategy mockLinkedinStrategy;
    @Mock
    SuperJobStrategy mockSuperJobStrategy;
    @Mock
    View mockView;
    List<Vacancy> hhVacancies;
    List<Vacancy> habrVacancies;
    List<Vacancy> liVacancies;
    List<Vacancy> sjVacancies;
    @BeforeEach
    void init() {
        hhVacancies = new ArrayList<>();
        habrVacancies = new ArrayList<>();
        liVacancies = new ArrayList<>();
        sjVacancies = new ArrayList<>();
        hhVacancies.add(new Vacancy("hh1","hh2","hh3", "hh4","hh5", "hh6"));
        habrVacancies.add(new Vacancy("habr1","habr2","habr3", "habr4","habr5", "habr6"));
        liVacancies.add(new Vacancy("li1","li2","li3", "li4","li5", "li6"));
        sjVacancies.add(new Vacancy("sj1","sj2","sj3", "sj4","sj5", "sj6"));
    }

    @Test
    @DisplayName("HHStrategy test")
    void hhModelTest() throws IOException {
        Document document = Jsoup.parse(new File("src/test/resources/HHStrategyTest.html"));
        try(MockedStatic<ModelDataLoader> mocked = Mockito.mockStatic(ModelDataLoader.class)) {
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.HH_URL_FORMAT, "Java", 0))).thenReturn(document);
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.HH_URL_FORMAT, "Java", 1))).thenReturn(Jsoup.parse(""));
            HHStrategy hhStrategy = new HHStrategy();
            List<Vacancy> vacancies = hhStrategy.getVacancies("Java");
            assertEquals(3, vacancies.size());
            assertEquals("TeamLead Backend (Python)",vacancies.get(0).getTitle());
            assertEquals("350 000 – 400 000 ₽",vacancies.get(0).getSalary());
            assertEquals("Москва",vacancies.get(0).getCity());
            assertEquals("Outlines Technologies",vacancies.get(0).getCompanyName());
            assertEquals("https://hh.ru", vacancies.get(0).getSiteName());
            assertEquals("https://hh.ru/vacancy/90456805?from=vacancy_search_list&hhtmFrom=vacancy_search_list&query=Java+developer", vacancies.get(0).getUrl());
        }

    }

    @Test
    @DisplayName("HabrCareerStrategy test")
    void habrModelTest() throws IOException {
        Document document= Jsoup.parse(new File("src/test/resources/HABRStrategyTest.html"));
        try(MockedStatic<ModelDataLoader> mocked = Mockito.mockStatic(ModelDataLoader.class)) {
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.HABR_URL_FORMAT, 1, "Java"))).thenReturn(document);
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.HABR_URL_FORMAT, 2, "Java"))).thenReturn(Jsoup.parse(""));
            HabrCareerStrategy habrStrategy = new HabrCareerStrategy();
            List<Vacancy> vacancies = habrStrategy.getVacancies("Java");
            assertEquals(4, vacancies.size());
            assertEquals("Android Developer AOSP",vacancies.get(0).getTitle());
            assertEquals("от 300 000 до 500 000 ₽",vacancies.get(0).getSalary());
            assertEquals("Санкт-Петербург",vacancies.get(0).getCity());
            assertEquals("1 CEO",vacancies.get(0).getCompanyName());
            assertEquals("https://career.habr.com", vacancies.get(0).getSiteName());
            assertEquals("https://career.habr.com/vacancies/1000135483", vacancies.get(0).getUrl());
        }
    }

    @Test
    @DisplayName("LinkedinStrategy test")
    void linkedInModelTest() throws IOException {
        Document document= Jsoup.parse(new File("src/test/resources/LinkedInStrategyTest.html"));
        try(MockedStatic<ModelDataLoader> mocked = Mockito.mockStatic(ModelDataLoader.class)) {
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.LINKEDIN_URL_FORMAT, "Java", 0))).thenReturn(document);
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.LINKEDIN_URL_FORMAT, "Java", 1))).thenReturn(Jsoup.parse(""));
            LinkedinStrategy strategy = new LinkedinStrategy();
            List<Vacancy> vacancies = strategy.getVacancies("Java");
            assertEquals(2, vacancies.size());
            assertEquals("Senior Java Developer - *Relocation to the UAE required!*",vacancies.get(0).getTitle());
            assertEquals("",vacancies.get(0).getSalary());
            assertEquals("Saint Petersburg Metropolitan Area",vacancies.get(0).getCity());
            assertEquals("Discovered MENA",vacancies.get(0).getCompanyName());
            assertEquals("https://www.linkedin.com", vacancies.get(0).getSiteName());
            assertEquals("https://ru.linkedin.com/jobs/view/senior-java-developer-relocation-to-the-uae-required%21-at-discovered-mena-3765422145?refId=lBNX%2BiE9ND4mnGE7Ki6EXw%3D%3D&trackingId=2e2vUwXkgJWtwRpslSymXg%3D%3D&position=1&pageNum=0&trk=public_jobs_jserp-result_search-card", vacancies.get(0).getUrl());
        }
    }
    @Test
    @DisplayName("SuperJobStrategy test")
    void superJobModelTest() throws IOException {
        Document document= Jsoup.parse(new File("src/test/resources/SuperJobStrategyTest.html"));
        try(MockedStatic<ModelDataLoader> mocked = Mockito.mockStatic(ModelDataLoader.class)) {
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.SUPERJOB_URL_FORMAT, "Java", 1))).thenReturn(document);
            mocked.when(() -> ModelDataLoader.getDocument(String.format(ModelConstants.SUPERJOB_URL_FORMAT, "Java", 2))).thenReturn(Jsoup.parse(""));
            SuperJobStrategy strategy = new SuperJobStrategy();
            List<Vacancy> vacancies = strategy.getVacancies("Java");
            assertEquals(6, vacancies.size());
            assertEquals("Java Senior разработчик",vacancies.get(0).getTitle());
            assertEquals("400 000 — 450 000 ₽/месяц",vacancies.get(0).getSalary());
            assertEquals("Москва Кутузовская",vacancies.get(0).getCity());
            assertEquals("ООО \"ЦИФРОВЫЕ ПРИВЫЧКИ\"",vacancies.get(0).getCompanyName());
            assertEquals("https://www.superjob.ru", vacancies.get(0).getSiteName());
            assertEquals("https://www.superjob.ru/vakansii/java-senior-razrabotchik-48044350.html", vacancies.get(0).getUrl());
        }
    }

    @Test
    @DisplayName("doSearch Model Test")
    void doSearchModelTest() {
        List<Vacancy> summaryVacancies = new ArrayList<>();
        summaryVacancies.addAll(hhVacancies);
        summaryVacancies.addAll(liVacancies);
        summaryVacancies.addAll(habrVacancies);
        summaryVacancies.addAll(sjVacancies);
        Mockito.when(mockHHStrategy.getVacancies(anyString())).thenReturn(hhVacancies);
        Mockito.when(mockHABRCareerStrategy.getVacancies(anyString())).thenReturn(habrVacancies);
        Mockito.when(mockLinkedinStrategy.getVacancies(anyString())).thenReturn(liVacancies);
        Mockito.when(mockSuperJobStrategy.getVacancies(anyString())).thenReturn(sjVacancies);
        Mockito.doNothing().when(mockView).update(anyList());
        Model testModel = new Model(mockView, mockHHStrategy, mockLinkedinStrategy, mockHABRCareerStrategy, mockSuperJobStrategy);
        testModel.doSearch("any Search");
        Mockito.verify(mockView, Mockito.times(1)).update(summaryVacancies);
    }

}
