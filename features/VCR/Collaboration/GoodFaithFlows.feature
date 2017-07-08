Feature: To Test the Good Faith flows

   # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: GoodFaithFLowsFixture.java
 # Description: Issuer initiates collaboration dispute and initiates good faith

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
    Then backend user takes initiate good faith action

  @SD-Issuer-2 @TC-175280
  Scenario: Collaboration_Good Faith_AcceptFull
    And backend resolves the good faith as Acquirer Liable
      | Key              | Value              |
      | Response         | Accept full        |
      | Status           | Resolved-GoodFaith |
      | Fraud indicator  | N                  |
      | Dispute category | Processing Errors  |
    And user logout from user portal


  @SD-Issuer @TC-175252
  Scenario: Collaboration_Good Faith_Decline_CH
    And backend resolves the good faith as CH Liable Issuer liable
      | Key      | Value   |
      | Response | Decline |
    And user logout from user portal

  @SD-Issuer @TC-175245
  Scenario: Collaboration_Good Faith_Decline_ContinueDispute_ChLiable
    And backend continues the dispute as response is declined and takes CHLiable action
      | Key      | Value   |
      | Response | Decline |
    And user logout from user portal


  @SD-Issuer @TC-175249
  Scenario: Collaboration_Good Faith_Decline_WO
    And backend resolves the good faith as Write off Issuer liable
      | Key      | Value   |
      | Response | Decline |
    And user logout from user portal

  @SD-Issuer-2 @TC-175271
  Scenario: Collaboration_Inquiry_NMI
    And backend user process good faith with more info
      | Key      | Value          |
      | Response | Need more info |
  And user logout from user portal

  @SD-Issuer @TC-180061
  Scenario: Collaboration_Good Faith_Decline_ContinueDispute_WO
    And backend continues the dispute as response is declined and takes WO action
      | Key      | Value   |
      | Response | Decline |
    And user logout from user portal