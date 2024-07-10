package APIAutomationLearning.tests.crud;

import APIAutomationLearning.base.BaseTest;
import APIAutomationLearning.endpoints.APIConstants;
import APIAutomationLearning.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class testCreateBookingPOST extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Shweta")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be created")
    public void testCreateBooking(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse =response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);

        // validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // DeSer
        BookingResponse bookingResponse = payloadManager.BookingResponseJava(response.asString());

        //Assert J
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotEmpty().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Savi");

        // TestNG Assertions
        assertActions.verifyStatusCodeValidReq(response,200);

    }
}
