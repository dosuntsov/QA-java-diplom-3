import static io.restassured.RestAssured.given;

public class User {
    private String token;
    UserJSON user;

    public User(String email, String password, String name) {
        user = new UserJSON(email, password, name);
    }

    public void createAUserViaAPI() {
        token = given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/register")
                .then()
                .extract()
                .path("accessToken");
        this.token = token;
    }

    public void deleteUserViaAPI(){
        if(token != null) {
            given()
                    .header("Content-type", "application/json")
                    .header("Authorization", token)
                    .delete("/api/auth/user");
        }
    }

    public void loginUserViaAPI() {
        token = given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/login")
                .then()
                .extract()
                .path("accessToken");
        this.token = token;
    }
}
