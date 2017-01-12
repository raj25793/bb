package org.test.falcon.constant;


/**
 * @author Rajeev Pandey
 * 
 */
public class ResponseErrorMessages {
    public static final String SOME_ERROR_OCCURED                  = "Some error occurred, please try again later";
    public static final String DATABASE_CONNECTION_ERROR           = "Database connection error";
    public static final String REQUEST_PARAM_CONVERSION_ERROR      = "request parameter is not valid";
    public static final String REQUEST_PARAM_INVALID               = "Request parameter is not valid";
    public static final String REQUEST_PARAM_INPUT_UNAVAILABLE     =
            "Request parameter is not received as output from previous api in the pipeline";
    public static final String INVALID_NAME_ATTRIBUTE              = "Invalid name attribute";
    public static final String DUPLICATE_NAME_RESOURCE             = "Resource with same name exist";
    public static final String DUPLICATE_RESOURCE                  = "Duplicate resource";
    public static final String SOLR_DOWN                           = "Solr Down, please bear with us";
    public static final String INVALID_CONTENT_TYPE                = "Invalid Content-Type in request header";
    public static final String INVALID_REQUEST_METHOD_URL_AND_BODY = "Invalid combination of request method, url and body";
    public static final String RESOURCE_ALREADY_EXIST              = "Resource already exist";
    public static final String INVALID_FORMAT_IN_REQUEST           = "Invalid format in request parameter value";
    public static final String LEAD_COULD_NOT_POST                 = "Lead could not post";
    public static final String MAIL_SENDING_ERROR                  = "Mail could not not be sent";
    public static final String BAD_REQUEST                         = "Bad Request";
    public static final String LOG_MESSAGE_ERROR                   = "Log message Empty or Log level invalid";

    public static final String CANT_COMPLETE_ACTION                = "Action cant be completed";
    public static final String INVALID_ASPECT_RATIO                = "Invalid Aspect Ratio";

    /**
     * User service related messages
     *
     */
    public static final class User {
        public static final String AUTHENTICATION_ERROR               = "Authentication error";
        public static final String UNAUTHORIZED                       = "Unauthorized";
        public static final String INVALID_USER_PREFERENCE            = "Invalid User Preference";
        public static final String BAD_CREDENTIAL                     = "Bad credentials";
        public static final String EMAIL_NOT_REGISTERED               = "Sorry, this email id is not registered with us.";
        public static final String PASSWORD_RECOVERY_MAIL_SENT        =
                "Please check your mail for password recovery details";
        public static final String CAPTCHA_REQUIRED                   = "Captcha Required";
        public static final String SESSION_EXPIRED_DUPLICATE_LOGIN    = "Session expired, duplicate login";
        public static final String OTP_REQUIRED                       =
                "Please enter OTP sent on your registered email and mobile number";
        public static final String WRONG_OTP                          = "Wrong OTP";
        public static final String OTP_VALIDATION_FAILED              = "OTP validation failed";
        public static final String OTP_EXPIRED                        = "OTP expired, check your mail for new OTP";
        public static final String NON_B2B_USER                       =
                "Invalid userid and password. Please send mail to datalabs@proptiger.com for verifying userid and password.";
        public static final String EXPIRED_PERMISSION_B2B_USER        =
                "Thanks for using our product. Validity of your subscription has expired. To continue using this service, please connect with your relationship manager or send us mail at datalabs@proptiger.com";
        public static final String ACCESS_DENIED                      = "Access is denied";
        public static final String NON_RMP_USER                       =
                "Thanks for using our product. If interested in this product please send mail to customer.service@proptiger.com ";
        public static final String INACTIVE_RMP_USER_COMPANY          =
                "Thanks for using our product, but your status is inactive. If interested please send mail to customer.service@proptiger.com";
        public static final String INVALID_PASSWORD                   = "Invalid password";
        public static final String OLD_PASSWORD_REQUIRED              = "Old password required";
        public static final String NEW_PASS_CONFIRM_PASS_NOT_MATCHED  = "New password and confirm password do not match";
        public static final String INVALID_USER_ID                    = "Invalid userId";
        public static final String INVALID_EMAIL                      = "Invalid email address";
        public static final String INVALID_COUNTRY                    = "Invalid country";
        public static final String INVALID_CONTACT_NUMBER             = "Invalid contact number";
        public static final String EMAIL_ALREADY_REGISTERED           = "Email already registered";
        public static final String PRIMARY_CONTACT_ALREADY_REGISTERED = "Primary Contact Number already registered";
        public static final String USER_NAME_PASSWORD_INCORRECT       = "User name or password not correct";

        public static final String TOKEN_INVALID                      = "Invalid token";
        public static final String TOKEN_EXPIRED                      = "Token expired";

        public static final String DAILY_DOWNLOAD_LIMIT_EXPIRED       = "Daily download limit expired";
        public static final String MONTHLY_DOWNLOAD_LIMIT_EXPIRED     = "Monthly download limit expired";
        public static final String INVALID_ATTRIBUTE_NAME             = "Invalid attribute name";
        public static final String INVALID_ATTRIBUTE_VALUE            = "Invalid attribute value";
        public static final String CONTACT_NOT_FOUND                  = "Contact not found";
        public static final String NEW_PRIMARY_EMAIL_REQUIRED         = "New Primary Email required";
        public static final String NEW_PRIMARY_CONTACT_REQUIRED       = "New Primary Contact required";
        public static final String INCOMPLETE_EMPLOYEE_DETAILS        = "Incomplete employee details";
        public static final String LIMIT_OF_COMPANY_USERS             =
                "Broker Company cannot have more than one Active Users";
        public static final String ADMIN_ROLE_REQUIRED                = "User should be logged in with Admin Role";
        public static final String INVALID_PRIMARY_NUMBER             = "Invalid primary number";
        public static final String INVALID_PRIMARY_EMAIL              = "Invalid primary email";
        public static final String USER_DETAILS_REQUIRED              = "User details are required";
        public static final String COMPANY_USER_ALREADY_REGISTERED    = "Company user already registered";
        public static final String COMPANY_USER_HAS_ACTIVE_CHILDREN   = "Company User has active children";


        public static final String INVALID_LISTING_CATEGORY_PRICE    = "Invalid Listing Category Price";
        public static final String INVALID_LISTING_PRICE_FROM_TO     = "From Price cannot be greater than To price";
        public static final String INVALID_SELLER_SCORE              = "Seller Score can't be negative";
        public static final String INVALID_SELLER_PRIORITY           = "Seller Priority can't be negative";
        public static final String INVALID_DATE                      = "Invalid Date";
        public static final String EXCEPTION_OCCURED                 = "Exception Occured";
        public static final String MARKETFORCE_CRO_ROLE_REQUIRED     = "User should be logged in with MarketforceCRO Role";
        public static final String INVALID_CITY                      = "Invalid city";
        public static final String ALREADY_SUBSCRIBED                = "You have already subscribed for free trial";
        public static final String INVALID_DOMAIN_ID                 = "Invalid domain Id";
        public static final String PRIMARY_NUMBER_NOT_VERIFIED       = "Primary Contact number not verified";
        public static final String TERMS_AND_CONDITION_NOT_ACCEPTED  = "Please accept terms and condition";
        public static final String ALREADY_SUBSCRIBED_TO_CITY        = "Already subscribed to a city";
        public static final String NOT_SUBSCRIBED_TO_CITY            = "Please subscribe to a city first";
        public static final String USER_STATUS_INVALID               = "User status is not Trial";
    }
}
