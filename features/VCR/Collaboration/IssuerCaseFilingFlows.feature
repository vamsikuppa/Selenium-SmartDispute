Feature: To test Arbitration Filing flows

  # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: AcqDeclinedFlowsFixture.java
 # Description: Issuer initiates arbitration and as per association ruling issuer takes respective actions

  Background: Check for the CSR Collaboration flows Issuer initiates Arbitration
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
    And backend user initiates arbitration in process acquirer response screen

  @SD-Issuer @TC-175257
  Scenario: C_Arbitration_IssuerLiable_WO

    Then backend user processes the association ruling as Issuer Liable and Write off to resolve the dispute and validates the tab details
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer @TC-175286
  Scenario: C_Arbitration_IssuerLiable_CH

    Then backend user processes the association ruling as Issuer Liable and cardholder liable action to resolve the dispute and validates the tab details
      | Key              | Value                     |
      | Dispute category | Processing Errors         |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |

    And user logout from user portal

  @SD-Issuer-2 @TC-175276
  Scenario: C_Arbitration_AcquirerLiable

    Then backend user processes the association ruling as Acquirer liable resolve the dispute and validates the tab details
      | Key              | Value                        |
      | Fraud indicator  | N                            |
      | Status           | Resolved-CaseFilingAcqLiable |
      | Dispute category | Processing Errors            |
    And user logout from user portal

  @SD-Issuer @TC-175296
  Scenario: C_ArbitrationWithdraw_CH
    Then backend user withdraws arbitration at awaiting acquirer response and resolves the dispute as CH Liable
      | Key              | Value                     |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
      | Dispute category | Processing Errors         |
    And user logout from user portal

  @SD-Issuer @TC-175246
  Scenario: C_ArbitrationWithdraw_WO
    Then backend user withdraws arbitration at awaiting acquirer response and resolves the dispute as Write off
      | Key              | Value             |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
      | Dispute category | Processing Errors |
    And user logout from user portal