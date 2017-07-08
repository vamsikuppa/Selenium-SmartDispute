Feature: To Test the Recall flows for collaboration flows

  # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: RecallFlowsFixture.java
 # Description: Issuer recalls the Dispute, Pre Arbitration flows

  Background: CSR-Issuer initiates collaboration dispute
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160853 |
    And csr selects single transaction to create a single dispute
    And csr process the qualify dispute screen for duplicate as follows
      | Key                                                | Value                        |
      | Dispute Reason                                     | I was charged more than once |
      | Did you attempt to resolve with the merchant?      | Yes                          |
      | Contact Method                                     | Telephone                    |
      | Contact Name                                       | John                         |
      | Merchant Response                                  | Not helpful                  |
      | Are both transactions on the same account number   | Y                            |
      | Acquirer reference number of the first transaction | 246104326500040201608551     |
      | Transaction ID                                     | 1234                         |
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When backend user clicks on customer initiated workbasket and filters the dispute
    And backend user validates the data in VCR Dispute Questionnaire assignment for Duplicates dispute reason as follows
      | Key                                                | Value                    |
      | Dispute category                                   | Processing Errors        |
      | Dispute Reason                                     | Duplicate                |
      | Are both transactions on the same account number   | Yes                      |
      | Acquirer reference number of the first transaction | 246104326500040201608551 |
      | Transaction ID                                     | 1234                     |

  @SD-Issuer @TC-175250
  Scenario: RecallDispute_WO

    Then backend user recalls the dispute and takes write off action validates the tab details after successful dispute recall as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer @TC-175240
  Scenario: RecallDispute_CH

    Then backend user recalls the dispute and takes cardholder liable action validates the tab details after successful dispute recall as follows
      | Key              | Value                     |
      | Dispute category | Processing Errors         |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer @TC-175293
  Scenario: Recall pre arbitration

    Then backend user initiates pre arbitration in process acquirer response screen and recalls pre arbitration
    And backend user validates the tab details after successful pre arb recall
      | Key              | Value                       |
      | Dispute category | Processing Errors           |
      | Fraud indicator  | N                           |
      | Status           | Open-RecalledPrearbitration |
    And user logout from user portal


