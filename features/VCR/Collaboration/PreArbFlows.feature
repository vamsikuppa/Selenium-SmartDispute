Feature: To Test the Pre Arbitration and its response flows

  # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: AcqDeclinedFlowsFixture.java
 # Description: Issuer initiates pre arbitration and acquirer declines pre arbitration and issuer taking respective actions

  Background: Issuer initiates pre arbitration
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
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
      | Key                                          | Value               |
      | Dispute category                             | Processing Errors   |
      | Dispute Reason                               | Paid by other means |
      | Are both transactions on same account number | N                   |
      | Payment method                               | Cash payment        |
    And backend user initiates pre arbitration in process acquirer response screen

  @SD-Issuer @TC-175278
  Scenario: C_PreArbFromDeclined_AcqDeclined_WO

    And backend user takes write off action at process pre arb response screen to resolve the dispute and validates the tab details
      | Key              | Value             |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
      | Dispute category | Processing Errors |
    And user logout from user portal

  @SD-Issuer @TC-175300
  Scenario: C_PreArbFromDeclined_AcqDeclined_CH

    Then backend user takes cardholder liable action at process pre arb response screen to resolve the dispute and validates the tab details
      | Key              | Value                     |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
      | Dispute category | Processing Errors         |
    And user logout from user portal

  @SD-Issuer-2 @TC-175244
  Scenario: C_PreArbFromDeclined_AcqAcceptedFull

    Then backend user resolves the dispute as Acquirer liable and validates the tab details
      | Key               | Value                     |
      | Acquirer response | Accept fully              |
      | Fraud indicator   | N                         |
      | Status            | Resolved-Pre-Arb-Accepted |
      | Dispute category  | Processing Errors         |
    And user logout from user portal

  @SD-Issuer-2 @TC-175294
  Scenario: C_PreArbFromDeclined_AcqAcceptedPart_CH


    Then backend user resolves the dispute as cardholder liable for partial amount
      | Key               | Value                     |
      | Acquirer response | Accept partially          |
      | Fraud indicator   | N                         |
      | Status            | Resolved-CardholderLiable |
      | Dispute category  | Processing Errors         |
    And user logout from user portal

  @SD-Issuer-2 @TC-175277
  Scenario: C_PreArbFromDeclined_AcqAcceptedPart_WO

    Then backend user resolves the dispute as write off for partial amount
      | Key               | Value             |
      | Acquirer response | Accept partially  |
      | Fraud indicator   | N                 |
      | Status            | Resolved-WriteOff |
      | Dispute category  | Processing Errors |
    And user logout from user portal


