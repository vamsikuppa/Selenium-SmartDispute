Feature: To Test the Miscellaneous flows for Allocation

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description:
  Background: Creating Fraud case from CSR
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160841 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user clicks on fraud workbasket and filters the claim

  @SD-Issuer-1 @TC-175284
  Scenario: RFC_Fulfillment
    And backend user validates the Fraud data and takes Initiate RFC action
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    Then backend validates RFC fulfillment message and validates tab details as follows
      | Key              | Value       |
      | Response         | Fulfillment |
      | Dispute category | Fraud       |
      | Fraud indicator  | Y           |
      | Status           | Open        |
    And user logout from user portal

  @SD-Issuer @TC-175287
  Scenario: RFC_NonFulfillment
    And backend user validates the Fraud data and takes Initiate RFC action
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    Then backend validates RFC fulfillment message and validates tab details as follows
      | Key              | Value           |
      | Response         | Non Fulfillment |
      | Dispute category | Fraud           |
      | Fraud indicator  | Y               |
      | Status           | Open            |
    And user logout from user portal

  @SD-Issuer @TC-175282
  Scenario: FraudReport-Edit-Modify
    Then backend user takes Submit Fraud Report action
    And backend user edits the fraud report and validates the fraud data and submits it
      | Key              | Value                             |
      | Dispute category | Fraud                             |
      | Action           | Modify                            |
      | Fraud type       | Card not received as Issued (NRI) |
      | Card Status      | Not Received                      |
      | CH Authorize     | No                                |
    And user logout from user portal

  @SD-Issuer @TC-180062
  Scenario: FraudReport-Edit-Delete
    Then backend user takes Submit Fraud Report action
    And backend user edits the fraud report and validates the fraud data and submits it
      | Key              | Value  |
      | Dispute category | Fraud  |
      | Action           | Delete |
      | Card Status      | Lost   |
      | CH Authorize     | No     |
    And user logout from user portal

  @SD-Issuer @TC-180088
  Scenario: FraudReport-Resolve Dispute
    Then backend user takes Submit Fraud Report action and closes the dispute
      | Key              | Value |
      | Dispute category | Fraud |
      | Action           | Close |
    And user logout from user portal


