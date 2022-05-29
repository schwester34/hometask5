package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestForJUnit5 {
   @BeforeAll
    static void beforeAll () {
       Configuration.baseUrl = "https://github.com";
       Configuration.browserSize = "1920x1080";
   }

    @Test
    void  pagesContentSoftAssertionsAndJUnit5(){
       // Открыть страницу github.com
        open("/selenide/selenide");
        // Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // В списке страниц ищем SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        // Кликаем по SoftAssertions
        $$(".filterable-active a").findBy(text("SoftAssertions")).click();
        // Ищем кусок кода для JUnit5
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
