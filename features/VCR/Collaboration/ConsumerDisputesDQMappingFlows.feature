Feature: To Test the Dispute Questionnaire Mapping flows for Processing Errors

   # author: Vamsi Krishna Kuppa
  # written on: 05-03-2017
  # step_def file: GoodFaithFLowsFixture.java
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

  @SD-Issuer-3 @TC-181702
  Scenario: Dispute Questionnaire Mapping for CD-NR-Merchandise
    Then user enters the data in VCR Dispute Questionnaire assignment for CD-Merchandise Not Received Reason as follows
      | Key                                   | Value                   |
      | Dispute category                      | Processing Errors       |
      | Dispute reason                        | Duplicate               |
      | Both transactions same account number | Yes                     |
      | Duplicate Tran Id                     | 307066130580511         |
      | Duplicate ARN                         | 74761197066000030005598 |
      | Notes                                 | [INVALID DISPUTE]       |