Feature: To Test the Dispute Questionnaire Mapping flows for Processing Errors

   # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: GoodFaithFLowsFixture.java
 # Description: Issuer initiates collaboration dispute and Checks for dispute questionnaire mappings

  Background: Issuer creates Collaboration case in backend and processes till VCR DQ Page
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4921110006923523        |
      | Reference Number | 24302517067000050006905 |
    And user selects single transaction to create a single dispute
    And user process the qualify dispute screen for another issue and lands on VCR Dispute Questionnaire screen
      | Key            | Value                                      |
      | Dispute Reason | I have another issue with this transaction |

  @SD-Issuer-3 @TC-181262
  Scenario: Dispute Questionnaire Mapping for PE-Duplicate-Same account number
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Duplicate Reason as follows
      | Key                                   | Value                   |
      | Dispute category                      | Processing Errors       |
      | Dispute reason                        | Duplicate               |
      | Both transactions same account number | Yes                     |
      | Duplicate Tran Id                     | 307066130580511         |
      | Duplicate ARN                         | 74761197066000030005598 |
      | Notes                                 | [INVALID DISPUTE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-181354
  Scenario: DQ Mappings for PE-Duplicate-Different A.C Number
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Duplicate Reason as follows
      | Key                                   | Value                   |
      | Dispute category                      | Processing Errors       |
      | Dispute reason                        | Duplicate               |
      | Both transactions same account number | No                      |
      | Duplicate Tran Id                     | 307066130580511         |
      | Duplicate ARN                         | 74761197066000030005598 |
      | Notes                                 | [INVALID DISPUTE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-181261
  Scenario: Dispute Questionnaire for Processing Errors-Incorrect Currency
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect currency Reason as follows
      | Key              | Value                                                                       |
      | Dispute category | Processing Errors                                                           |
      | Correct currency | NZD                                                                         |
      | DCC option       | The cardholder was not advised that dynamic currency conversion would occur |
      | Notes            | [INVALID DISPUTE]                                                           |
    And user logout from user portal

  @SD-Issuer-3 @TC-181260
  Scenario: Dispute Questionnaire for PE-Incorrect Account Number
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect account number Reason as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Notes            | [ACCEPTCLOSE]     |
    And user logout from user portal

  @SD-Issuer-3 @TC-181258
  Scenario: Dispute Questionnaire for Processing Errors-Incorrect Amount
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect Amount Reason as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Notes            | [ACCEPTCLOSE]     |
    And user logout from user portal

  @SD-Issuer-3 @TC-181257
  Scenario: Dispute Questionnaire for PE-Incorrect Transaction code
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect Transaction code Reason as follows
      | Key                          | Value                   |
      | Dispute category             | Processing Errors       |
      | Transaction Incorrect reason | Cash posted as purchase |
      | Notes                        | [INVALID DISPUTE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-181263
  Scenario: Dispute Questionnaire for Processing Errors-Late Presentment
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Late Presentment Reason as follows
      | Key                          | Value                   |
      | Dispute category             | Processing Errors       |
      | Transaction Incorrect reason | Cash posted as purchase |
      | Notes                        | [INVALID DISPUTE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-181259
  Scenario: DQ Mappings for PE-Paid by Other Means-Same account number
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Paid by other means Reason as follows
      | Key                                   | Value                   |
      | Dispute category                      | Processing Errors       |
      | Dispute reason                        | Paid by other means     |
      | Both transactions same account number | Yes                     |
      | Duplicate Tran Id                     | 307066130580511         |
      | Duplicate ARN                         | 74761197066000030005598 |
      | Payment proof                         | Cheque                  |
      | Notes                                 | [INVALID DISPUTE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-181355
  Scenario: DQ Mappings for PE-Paid by other means-Different A.C number
    Then user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Paid by other means Reason as follows
      | Key                                   | Value                   |
      | Dispute category                      | Processing Errors       |
      | Dispute reason                        | Paid by other means     |
      | Both transactions same account number | No                      |
      | Duplicate Tran Id                     | 307066130580511         |
      | Duplicate ARN                         | 74761197066000030005598 |
      | Payment proof                         | Cheque                  |
      | Notes                                 | [INVALID DISPUTE]       |
    And user logout from user portal
