package pages.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import static io.restassured.RestAssured.given;
import static util.Config.getProperty;

@JsonPropertyOrder({"id", "title"})
public class TypicodeAPIPage {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
