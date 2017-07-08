Feature: To test the Dispute Response flows

  # author: Vamsi Krishna Kuppa
  # written on: 26-02-2017
  # step_def file: DisputeResponseFlowsFixture.java
 # Description: Issuer creates Collaboration case and Acquirer provides the response as part of Dipsute response then Issuer takes respective action

  Background: Issuer creates Collab case and processes till VCR DQ Page
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And csr enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160853 |
    And csr selects single transaction to create a single dispute
    And csr process the qualify dispute screen for paid by other means as follows
      | Key               | Value                                 |
      | Dispute Reason    | I paid for this item by another means |
      | Payment method    | Cash                                  |
      | Contact Method    | Telephone                             |
      | Contact Name      | John                                  |
      | Merchant Response | Not helpful                           |
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When backend user clicks on customer initiated workbasket and filters the dispute
    And backend user validates the data in VCR Dispute Questionnaire assignment for Paid by other means dispute reason as follows
      | Key              | Value               |
      | Dispute category | Processing Errors   |
      | Dispute Reason   | Paid by other means |
      | Payment method   | Cash payment        |

  @SD-Issuer @TC-175260
  Scenario: C_Acq_Declined_WO
    And backend user takes writeoff action in process acquirer response screen to resolve the dispute and validates the tab details
      | Key              | Value             |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
      | Dispute category | Processing Errors |
    And user logout from user portal

  @SD-Issuer @TC-175255
  Scenario: C_Acq_Declined_CH

    And backend user takes cardholder liable action in process acquirer response screen to resolve the dispute and validates tab details
      | Key              | Value                     |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
      | Dispute category | Processing Errors         |
    And user logout from user portal

  @SD-Issuer-2 @TC-175263
  Scenario: C_Acq_AcceptedFull
    Then backend user resolves the dispute as Acquirer liable and validates the tab details as follows
      | Key               | Value                     |
      | Dispute category  | Processing Errors         |
      | Acquirer response | Accepted full             |
      | Status            | Resolved-AcquirerAccepted |
      | Fraud indicator   | N                         |
    Then user logout from user portal

  @SD-Issuer-1 @TC-175267
  Scenario: C_Acq_AcceptedPartial_CH
    Then backend takes cardholder liable for partial amount liable and resolves the dispute
      | Key               | Value                     |
      | Dispute category  | Processing Errors         |
      | Acquirer response | Accepted partial          |
      | Status            | Resolved-CardholderLiable |
      | Fraud indicator   | N                         |
    Then user logout from user portal


  @SD-Issuer-1 @TC-175295
  Scenario: C_Acq_AcceptedPartial_WO
    Then backend writes off for partial amount liable and resolves the dispute
      | Key               | Value             |
      | Dispute category  | Processing Errors |
      | Acquirer response | Accepted partial  |
      | Status            | Resolved-WriteOff |
      | Fraud indicator   | N                 |
    Then user logout from user portal



