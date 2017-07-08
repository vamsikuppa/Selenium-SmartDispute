Feature: To Test the Authorization Errors Dispute Questionnaire Mapping flows

   # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: DQMappingsFixture.java
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


  @SD-Issuer-3 @TC-47
  Scenario: Authorization errors-Asia Pacific-Yes-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | Yes                 |
      | Explain invalid reason        | test                |
      | Notes                         | [ACCEPTCLOSE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-48
  Scenario: Authorization errors-Asia Pacific-No-Invalid Data-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | No                  |
      | Authorization applied         | Invalid data        |
      | Notes                         | [ACCEPTCLOSE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-49
  Scenario: Authorization errors-Asia Pacific-No-Others-Accept Close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | No                  |
      | Authorization applied         | Other               |
      | More Details                  | test                |
      | Notes                         | [ACCEPTCLOSE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-50
  Scenario: Authorization errors-Asia Pacific-Yes-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | Yes                 |
      | Explain invalid reason        | test                |
      | Notes                         | [INVALID DISPUTE]   |
    And user logout from user portal

  @SD-Issuer-3 @TC-51
  Scenario: Authorization errors-Asia Pacific-No-Invalid Data-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | No                  |
      | Authorization applied         | Invalid data        |
      | Notes                         | [INVALID DISPUTE]   |
    And user logout from user portal

  @SD-Issuer-3 @TC-52
  Scenario: Authorization errors-Asia Pacific-No-Others-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Asia Pacific (AP)   |
      | Authorization obtained        | No                  |
      | Authorization applied         | Other               |
      | More Details                  | test                |
      | Notes                         | [INVALID DISPUTE]   |
    And user logout from user portal

  @SD-Issuer-3 @TC-53
  Scenario: Authorization errors-CEMEA-Yes-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | CEMEA               |
      | Authorization obtained        | Yes                 |
      | Explain invalid reason        | test                |
      | Notes                         | [ACCEPTCLOSE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-54
  Scenario: Authorization errors-Canada-No-Invalid Data-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Canada              |
      | Authorization obtained        | No                  |
      | Authorization applied         | Invalid data        |
      | Notes                         | [ACCEPTCLOSE]       |
    And user logout from user portal

  @SD-Issuer-3 @TC-55
  Scenario: Authorization errors-NCRB-No-Others-Accept Close
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value                                                                            |
      | Dispute category              | Authorization Error                                                              |
      | Exception file listing region | Countries associated with the National Card Recovery Bulletin (NCRB) information |
      | Authorization obtained        | No                                                                               |
      | Authorization applied         | Other                                                                            |
      | More Details                  | test                                                                             |
      | Notes                         | [ACCEPTCLOSE]                                                                    |
    And user logout from user portal

  @SD-Issuer-3 @TC-56
  Scenario: Authorization errors-Visa Europe-Yes-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | Visa Europe         |
      | Authorization obtained        | Yes                 |
      | Explain invalid reason        | test                |
      | Notes                         | [INVALID DISPUTE]   |
    And user logout from user portal

  @SD-Issuer-3 @TC-57
  Scenario: Authorization errors-LAC-No-Invalid Data-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value                             |
      | Dispute category              | Authorization Error               |
      | Exception file listing region | Latin America and Caribbean (LAC) |
      | Authorization obtained        | No                                |
      | Authorization applied         | Invalid data                      |
      | Notes                         | [INVALID DISPUTE]                 |
    And user logout from user portal

  @SD-Issuer-3 @TC-58
  Scenario: Authorization errors-ALL-No-Others-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value               |
      | Dispute category              | Authorization Error |
      | Exception file listing region | All                 |
      | Authorization obtained        | No                  |
      | Authorization applied         | Other               |
      | More Details                  | test                |
      | Notes                         | [INVALID DISPUTE]   |
    And user logout from user portal

  @SD-Issuer-3 @TC-59
  Scenario: Authorization errors-NCRF-No-Others-INVALID DISPUTE
    And user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows
      | Key                           | Value                                                          |
      | Dispute category              | Authorization Error                                            |
      | Exception file listing region | Do not list in any Card Recovery Bulletin (Listed on the NCRF) |
      | Authorization obtained        | No                                                             |
      | Authorization applied         | Other                                                          |
      | More Details                  | test                                                           |
      | Notes                         | [INVALID DISPUTE]                                              |
    And user logout from user portal