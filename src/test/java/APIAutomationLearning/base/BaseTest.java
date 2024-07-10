package APIAutomationLearning.base;

import APIAutomationLearning.actions.AssertActions;
import APIAutomationLearning.endpoints.APIConstants;
import APIAutomationLearning.modules.PayloadManager;
//import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;

    @BeforeTest
    public void setConfig(){
        System.out.println("BeforeTest");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.Base_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }

    public String getToken(){
        return null;
    }


}
