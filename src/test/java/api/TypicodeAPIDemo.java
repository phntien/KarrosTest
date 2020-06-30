package api;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import pages.api.TypicodeAPIPage;
import util.Config;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TypicodeAPIDemo {
    @Test
    public void getTypicode() {
//        TypicodeAPIPage typi =
//                given().
//                        when().get(Config.getProperty("urlAPI")).as(TypicodeAPIPage.class);
//        Assert.assertEquals(1, typi.getId());
        given().when().get(Config.getProperty("urlAPI"))
                .then()
                .statusCode(200)
                .and()
                .assertThat().contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("title", equalTo("Post 1"));
    }
}
