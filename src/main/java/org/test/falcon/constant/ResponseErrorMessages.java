package org.test.falcon.constant;


/**
 * @author Rajeev Pandey
 * 
 */
public class ResponseErrorMessages {
    public static String SOME_ERROR_OCCURED                  = "Some error occurred, please try again later";
    public static String DATABASE_CONNECTION_ERROR           = "Database connection error";
    public static String REQUEST_PARAM_CONVERSION_ERROR      = "request parameter is not valid";
    public static String REQUEST_PARAM_INVALID               = "Request parameter is not valid";
    public static String REQUEST_PARAM_INPUT_UNAVAILABLE     =
            "Request parameter is not received as output from previous api in the pipeline";
    public static String INVALID_NAME_ATTRIBUTE              = "Invalid name attribute";
    public static String DUPLICATE_NAME_RESOURCE             = "Resource with same name exist";
    public static String DUPLICATE_RESOURCE                  = "Duplicate resource";
    public static String SOLR_DOWN                           = "Solr Down, please bear with us";
    public static String INVALID_CONTENT_TYPE                = "Invalid Content-Type in request header";
    public static String INVALID_REQUEST_METHOD_URL_AND_BODY = "Invalid combination of request method, url and body";
    public static String RESOURCE_ALREADY_EXIST              = "Resource already exist";
    public static String INVALID_FORMAT_IN_REQUEST           = "Invalid format in request parameter value";
    public static String LEAD_COULD_NOT_POST                 = "Lead could not post";
    public static String MAIL_SENDING_ERROR                  = "Mail could not not be sent";
    public static String BAD_REQUEST                         = "Bad Request";
    public static String LOG_MESSAGE_ERROR                   = "Log message Empty or Log level invalid";

    public static String CANT_COMPLETE_ACTION                = "Action cant be completed";
    public static String INVALID_ASPECT_RATIO                = "Invalid Aspect Ratio";

    /**
     * User service related messages
     *
     */
    public static class User {
        public static String AUTHENTICATION_ERROR               = "Authentication error";
        public static String UNAUTHORIZED                       = "Unauthorized";
        public static String INVALID_USER_PREFERENCE            = "Invalid User Preference";
        public static String BAD_CREDENTIAL                     = "Bad credentials";
        public static String EMAIL_NOT_REGISTERED               = "Sorry, this email id is not registered with us.";
        public static String PASSWORD_RECOVERY_MAIL_SENT        =
                "Please check your mail for password recovery details";
        public static String CAPTCHA_REQUIRED                   = "Captcha Required";
        public static String SESSION_EXPIRED_DUPLICATE_LOGIN    = "Session expired, duplicate login";
        public static String OTP_REQUIRED                       =
                "Please enter OTP sent on your registered email and mobile number";
        public static String WRONG_OTP                          = "Wrong OTP";
        public static String OTP_VALIDATION_FAILED              = "OTP validation failed";
        public static String OTP_EXPIRED                        = "OTP expired, check your mail for new OTP";
        public static String NON_B2B_USER                       =
                "Invalid userid and password. Please send mail to datalabs@proptiger.com for verifying userid and password.";
        public static String EXPIRED_PERMISSION_B2B_USER        =
                "Thanks for using our product. Validity of your subscription has expired. To continue using this service, please connect with your relationship manager or send us mail at datalabs@proptiger.com";
        public static String ACCESS_DENIED                      = "Access is denied";
        public static String NON_RMP_USER                       =
                "Thanks for using our product. If interested in this product please send mail to customer.service@proptiger.com ";
        public static String INACTIVE_RMP_USER_COMPANY          =
                "Thanks for using our product, but your status is inactive. If interested please send mail to customer.service@proptiger.com";
        public static String INVALID_PASSWORD                   = "Invalid password";
        public static String OLD_PASSWORD_REQUIRED              = "Old password required";
        public static String NEW_PASS_CONFIRM_PASS_NOT_MATCHED  = "New password and confirm password do not match";
        public static String INVALID_USER_ID                    = "Invalid userId";
        public static String INVALID_EMAIL                      = "Invalid email address";
        public static String INVALID_COUNTRY                    = "Invalid country";
        public static String INVALID_CONTACT_NUMBER             = "Invalid contact number";
        public static String EMAIL_ALREADY_REGISTERED           = "Email already registered";
        public static String PRIMARY_CONTACT_ALREADY_REGISTERED = "Primary Contact Number already registered";
        public static String USER_NAME_PASSWORD_INCORRECT       = "User name or password not correct";

        public static String TOKEN_INVALID                      = "Invalid token";
        public static String TOKEN_EXPIRED                      = "Token expired";

        public static String DAILY_DOWNLOAD_LIMIT_EXPIRED       = "Daily download limit expired";
        public static String MONTHLY_DOWNLOAD_LIMIT_EXPIRED     = "Monthly download limit expired";
        public static String INVALID_ATTRIBUTE_NAME             = "Invalid attribute name";
        public static String INVALID_ATTRIBUTE_VALUE            = "Invalid attribute value";
        public static String CONTACT_NOT_FOUND                  = "Contact not found";
        public static String NEW_PRIMARY_EMAIL_REQUIRED         = "New Primary Email required";
        public static String NEW_PRIMARY_CONTACT_REQUIRED       = "New Primary Contact required";
        public static String INCOMPLETE_EMPLOYEE_DETAILS        = "Incomplete employee details";
        public static String LIMIT_OF_COMPANY_USERS             =
                "Broker Company cannot have more than one Active Users";
        public static String ADMIN_ROLE_REQUIRED                = "User should be logged in with Admin Role";
        public static String INVALID_PRIMARY_NUMBER             = "Invalid primary number";
        public static String INVALID_PRIMARY_EMAIL              = "Invalid primary email";
        public static String USER_DETAILS_REQUIRED              = "User details are required";
        public static String COMPANY_USER_ALREADY_REGISTERED    = "Company user already registered";
        public static String COMPANY_USER_HAS_ACTIVE_CHILDREN   = "Company User has active children";


        public static String INVALID_LISTING_CATEGORY_PRICE    = "Invalid Listing Category Price";
        public static String INVALID_LISTING_PRICE_FROM_TO     = "From Price cannot be greater than To price";
        public static String INVALID_SELLER_SCORE              = "Seller Score can't be negative";
        public static String INVALID_SELLER_PRIORITY           = "Seller Priority can't be negative";
        public static String INVALID_DATE                      = "Invalid Date";
        public static String EXCEPTION_OCCURED                 = "Exception Occured";
        public static String MARKETFORCE_CRO_ROLE_REQUIRED     = "User should be logged in with MarketforceCRO Role";
        public static String INVALID_CITY                      = "Invalid city";
        public static String ALREADY_SUBSCRIBED                = "You have already subscribed for free trial";
        public static String INVALID_DOMAIN_ID                 = "Invalid domain Id";
        public static String PRIMARY_NUMBER_NOT_VERIFIED       = "Primary Contact number not verified";
        public static String TERMS_AND_CONDITION_NOT_ACCEPTED  = "Please accept terms and condition";
        public static String ALREADY_SUBSCRIBED_TO_CITY        = "Already subscribed to a city";
        public static String NOT_SUBSCRIBED_TO_CITY            = "Please subscribe to a city first";
        public static String USER_STATUS_INVALID               = "User status is not Trial";
    }
}
