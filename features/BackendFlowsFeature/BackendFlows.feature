Feature: To Test the Backend Flows

  # author: Vamsi Krishna Kuppa
  # written on: 06-02-2017
  # step_def file: NA
  @SD-Issuer-2 @TC-1
  Scenario: Check for Collboration Flow Write Off
    Given a user is logged into application with as "anand.bullock@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   |        4752999999999991 |
      | Reference Number | 24610432650004020160853 |
    And user selects single transaction to create a single dispute
    #And user process the duplicates assignment if exists
    And user process the qualify dispute screen for paid by other means as follows and lands on VCR Dispute Questionnaire screen
      | Key               | Value                                 |
      | Dispute Reason    | I paid for this item by another means |
      | Payment method    | Cash                                  |
      | Contact Method    | Telephone                             |
      | Contact Name      | John                                  |
      | Merchant Response | Not helpful                           |
    And user validates the data in VCR Dispute Questionnaire assignment as follows
      | Key                                          | Value               |
      | Dispute category                             | Processing Errors   |
      | Dispute Reason                               | Paid by other means |
      | Are both transactions on same account number | Y                   |
      | Payment method                               | Cash payment        |
    And user takes writeoff action in process acquirer response screen to resolve the dispute
    And user validates the information on Interview tab as follows
      | Key                                          | Value                                 |
      | Dispute category                             | Processing Errors                     |
      | Dispute Reason                               | I paid for this item by another means |
      | Payment method                               | Cash                                  |
      | Did you attempt to resolve with the merchant | Yes                                   |
      | Contact Method                               | Telephone                             |
      | Contact Name                                 | John                                  |
      | Merchant Response                            | Not helpful                           |
      | Do you have proof of payment                 | Yes                                   |
      | Are both transactions on same account number | Yes                                   |
    And user validates the information on Overview tab as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
    And user validates the information on VCR tab as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
    And user logout from user portal
