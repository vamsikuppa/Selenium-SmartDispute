Feature: To Test the Fraud Dispute Questionnaire Mapping flows

   # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: DQMappingsFixture.java
 # Description: Issuer initiates collaboration dispute and Checks for dispute questionnaire mappings

  Background: Issuer creates Collaboration case in backend and processes till VCR DQ Page
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                    |
      | ACCOUNT NUMBER   | 4921110214881232         |
      | Reference Number | 476119707406000810000810 |
    And user selects single transaction to create a single dispute
    And user process the qualify dispute screen for another issue and lands on VCR Dispute Questionnaire screen
      | Key            | Value                                      |
      | Dispute Reason | I have another issue with this transaction |

  @SD-Issuer-3 @TC-60
  Scenario: Process Fraud Questionnaire-Lost-Chip card-Yes-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value         |
      | Dispute category                       | Fraud         |
      | Fraud type                             | Lost          |
      | Card status                            | Lost          |
      | Is the card a PIN preferring chip card | Yes           |
      | Was a PIN pad present and working      | Yes           |
      | Notes                                  | [ACCEPTCLOSE] |
    And user logout from user portal

  @SD-Issuer-3 @TC-61
  Scenario: Process Fraud Questionnaire-Stolen-Chip card-No-Accept close
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value         |
      | Dispute category                       | Fraud         |
      | Fraud type                             | Stolen        |
      | Card status                            | Stolen        |
      | Is the card a PIN preferring chip card | No            |
      | Notes                                  | [ACCEPTCLOSE] |
    And user logout from user portal

  @SD-Issuer-3 @TC-62
  Scenario: Process Fraud Questionnaire-Card Not Received-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                             |
      | Dispute category                       | Fraud                             |
      | Fraud type                             | Card not received as Issued (NRI) |
      | Card status                            | Counterfeit                       |
      | Is the card a PIN preferring chip card | No                                |
      | Notes                                  | [INVALID DISPUTE]                 |
    And user logout from user portal

  @SD-Issuer-3 @TC-63
  Scenario: Process Fraud Questionnaire-Fraudulent Application-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                  |
      | Dispute category                       | Fraud                  |
      | Fraud type                             | Fraudulent application |
      | Card status                            | Counterfeit            |
      | Is the card a PIN preferring chip card | No                     |
      | Notes                                  | [INVALID DISPUTE]      |
    And user logout from user portal

  @SD-Issuer-3 @TC-64
  Scenario: Process Fraud Questionnaire-Fraudulent use of account number-Application-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                            |
      | Dispute category                       | Fraud                            |
      | Fraud type                             | Fraudulent use of account number |
      | Card status                            | Not Received                     |
      | Is the card a PIN preferring chip card | Yes                              |
      | Was a PIN pad present and working      | Yes                              |
      | Notes                                  | [ACCEPTCLOSE]                    |
    And user logout from user portal

  @SD-Issuer-3 @TC-65
  Scenario: Process Fraud Questionnaire-Issuer reported counterfeit-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                       |
      | Dispute category                       | Fraud                       |
      | Fraud type                             | Issuer-reported counterfeit |
      | Card status                            | Counterfeit                 |
      | Is the card a PIN preferring chip card | No                          |
      | Notes                                  | [INVALID DISPUTE]           |
    And user logout from user portal

  @SD-Issuer-3 @TC-66
  Scenario: Process Fraud Questionnaire-Miscellaneous/Account takeover-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                          |
      | Dispute category                       | Fraud                          |
      | Fraud type                             | Miscellaneous/Account takeover |
      | Card status                            | Other                          |
      | Is the card a PIN preferring chip card | Yes                            |
      | Was a PIN pad present and working      | Yes                            |
      | Notes                                  | [ACCEPTCLOSE]                  |
    And user logout from user portal

  @SD-Issuer-3 @TC-67
  Scenario: Process Fraud Questionnaire-Fraudulent use of account number-Counterfeit-No-Invalid Dispute
    And user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows
      | Key                                    | Value                            |
      | Dispute category                       | Fraud                            |
      | Fraud type                             | Fraudulent use of account number |
      | Card status                            | Not Received                     |
      | Is the card a PIN preferring chip card | No                               |
      | Notes                                  | [INVALID DISPUTE]                |
    And user logout from user portal
