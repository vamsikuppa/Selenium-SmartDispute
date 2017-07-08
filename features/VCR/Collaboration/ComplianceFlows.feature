Feature: To Test the Pre Compliance and Compliance flows

  # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: PreComplianceFlowsFixture.java
 # Description: Issuer initiates disputes and raises pre compliance and acquirer taking respective actions

  Background: Issuer created collaboration dispute and initiates pre compliance
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160853 |
    And csr selects single transaction to create a single dispute
    And csr process the qualify dispute screen for paid by other means as follows
      | Key                       | Value                                 |
      | Dispute Reason            | I paid for this item by another means |
      | Payment method            | Cash                                  |
      | Contact Method            | Telephone                             |
      | Contact Name              | John                                  |
      | Merchant Response         | Not helpful                           |
      | Payment method            | Other Payment Card                    |
      | Acquirer reference number | 246104326500040201608551              |
      | Transaction Id            | 1234                                  |
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When backend user clicks on customer initiated workbasket and filters the dispute
    And backend user validates the data in VCR Dispute Questionnaire assignment for Paid by other means dispute reason as follows
      | Key                                          | Value                    |
      | Dispute category                             | Processing Errors        |
      | Dispute Reason                               | Paid by other means      |
      | Are both transactions on same account number | N                        |
      | Payment method                               | Other card               |
      | Acquirer reference number                    | 246104326500040201608551 |
      | Transaction Id                               | 1234                     |
    And backend user takes initiate pre compliance flow action and processes the initiate pre compliance as follows
      | Key                       | Value                                        |
      | Primary Violation         | Account and Transaction Information Security |
      | Secondary Violation       | Payment of Existing Debt                     |
      | Additional Violation      | Surcharges and Taxes                         |
      | Reason for pre compliance | Visa rules are violated                      |

  @SD-Issuer-2 @TC-175237
  Scenario: PreComp_AcqAcceptedFull

    Then backend user resolves the pre compliance as acquirer liable and validates the tab details as follows
      | Key               | Value                  |
      | Acquirer response | Accept full            |
      | Dispute category  | Processing Errors      |
      | Fraud indicator   | N                      |
      | Status            | Resolved-Precompliance |
    And user logout from user portal

  @SD-Issuer @TC-175299
  Scenario: PreComp_AcqDeclined_CH
    Then backend user resolves the dispute as Issuer liable by taking Cardholder liable action and validates the tab details as follows
      | Key               | Value                     |
      | Acquirer response | Declined                  |
      | Dispute category  | Processing Errors         |
      | Fraud indicator   | N                         |
      | Status            | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer @TC-175273
  Scenario: PreComp_AcqDeclined_WO
    Then backend user resolved the dispute as Issuer liable by taking Write off action and validates the tab details as follows
      | Key               | Value             |
      | Acquirer response | Declined          |
      | Dispute category  | Processing Errors |
      | Fraud indicator   | N                 |
      | Status            | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer-1 @TC-175259
  Scenario: CompFromPartial_AcquirerLiable
    Then backend user initiates compliance and association ruling is given as acquirer liable and validates the tab details as follows
      | Key               | Value                        |
      | Acquirer response | Declined                     |
      | Action            | Initiates Compliance         |
      | Dispute category  | Processing Errors            |
      | Fraud indicator   | N                            |
      | Status            | Resolved-CaseFilingAcqLiable |
    And user logout from user portal

  @SD-Issuer @TC-175266
  Scenario: CompFromDeclined_IssuerLiable_CH
    Then backend user initiates compliance and association ruling is given as Issuer liable and Issuer selects the Cardholder liable and validates the tab details as follows
      | Key               | Value                     |
      | Acquirer response | Declined                  |
      | Action            | Initiates Compliance      |
      | Dispute category  | Processing Errors         |
      | Fraud indicator   | N                         |
      | Status            | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer @TC-180058
  Scenario: CompFromDeclined_IssuerLiable_WO
    Then backend user initiates compliance and association ruling is given as Issuer liable and Issuer selects the Write off and validates the tab details as follows
      | Key               | Value                |
      | Acquirer response | Declined             |
      | Action            | Initiates Compliance |
      | Dispute category  | Processing Errors    |
      | Fraud indicator   | N                    |
      | Status            | Resolved-WriteOff    |
    And user logout from user portal

  @SD-Issuer-1 @TC-24
  Scenario: PreComp_AcqPartial_CH
    Then backend user resolved the dispute by taking Writeoff action for the partial amount and validates the tab details as follows
      | Key               | Value                     |
      | Acquirer response | Accept partial            |
      | Dispute category  | Processing Errors         |
      | Fraud indicator   | N                         |
      | Status            | Resolved-CardholderLiable |
    And user logout from user portal


  @SD-Issuer-1 @TC-175283
  Scenario: PreComp_AcqPartial_WO
    Then backend user resolved the dispute by taking Cardholder liable action for the partial amount and validates the tab details as follows
      | Key               | Value             |
      | Acquirer response | Accept partial    |
      | Dispute category  | Processing Errors |
      | Fraud indicator   | N                 |
      | Status            | Resolved-WriteOff |
    And user logout from user portal


  @SD-Issuer-1 @TC-175242
  Scenario: CompFromPartial_IssuerLiable_WO
    Then backend user initiates compliance for the issuer liable amount and association ruling is Issuer liable and taking write off action and validates tab details as follows
      | Key               | Value             |
      | Acquirer response | Accept partial    |
      | Dispute category  | Processing Errors |
      | Fraud indicator   | N                 |
      | Status            | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer-1 @TC-180059
  Scenario: CompFromPartial_IssuerLiable_CH
    Then backend user initiates compliance for the issuer liable amount and association ruling is Issuer liable and taking Cardholder liable action and validates tab details as follows
      | Key               | Value                     |
      | Acquirer response | Accept partial            |
      | Dispute category  | Processing Errors         |
      | Fraud indicator   | N                         |
      | Status            | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer-1 @TC-175259
  Scenario: CompFromPartial_AcquirerLiable
    Then backend user initiates compliance for the issuer liable amount and association ruling is Acquirer liable and resolving the dispute and validates tab details as follows
      | Key               | Value                        |
      | Acquirer response | Accept partial               |
      | Dispute category  | Processing Errors            |
      | Fraud indicator   | N                            |
      | Status            | Resolved-CaseFilingAcqLiable |
    And user logout from user portal

  @SD-Issuer @TC-175243
  Scenario: RecallPrecompliance
    Then backend recalls precompliance and resolves the dispute
      | Key              | Value                      |
      | Dispute category | Processing Errors          |
      | Fraud indicator  | N                          |
      | Status           | Open-RecalledPrecompliance |
    And user logout from user portal

  @SD-Issuer @TC-175239
  Scenario: CompFromDeclined_WithDraw_CH
    Then backend user initiates compliance and withdraws compliance and takes Cardholder liable action
      | Key              | Value                     |
      | Dispute category | Processing Errors         |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer @TC-175264
  Scenario: CompFromDeclined_WithDraw_WO
    Then backend user initiates compliance and withdraws compliance and takes Write off action
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
    And user logout from user portal