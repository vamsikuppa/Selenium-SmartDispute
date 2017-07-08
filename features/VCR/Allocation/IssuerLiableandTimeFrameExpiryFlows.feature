Feature: Issuer Liable and Time Frame Expiry flows for Allocation Flow

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case and association gives response as Issuer liable and takes appropriate Action

  @SD-Issuer @TC-180056
  Scenario: A_IssuerLiable_WO
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
    And backend user validates the Fraud data in VCR Dispute Questionnaire Page as follows
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    And backend user takes writeoff action in process Issuer Liability assignment and validates tab details as follows
      | Key              | Value             |
      | Dispute category | Fraud             |
      | Fraud indicator  | Y                 |
      | Status           | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer @TC-182534
  Scenario: A_IssuerLiable_CH
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
    And backend user validates the Fraud data in VCR Dispute Questionnaire Page as follows
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    And backend user takes Cardholder liable action in process Issuer Liability assignment and validates tab details as follows
      | Key              | Value                     |
      | Dispute category | Fraud                     |
      | Fraud indicator  | Y                         |
      | Status           | Resolved-CardholderLiable |
    And user logout from user portal

  @SD-Issuer @TC-187170
  Scenario: Fraud_Issuer Liable_Multi pronged
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
    And backend user validates the Fraud data in VCR Dispute Questionnaire Page as follows
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    Then user selects multipronged option in process issuer liability assignment and selects "Cardholder liable" and "Write off" action
      | Key                      | Value |
      | Writeoff amount          | 36    |
      | Cardholder liable amount | 800   |
    And user validates the tab details after multi pronged in process issuer liability
      | Key              | Value             |
      | Dispute category | Fraud             |
      | Fraud indicator  | Y                 |
      | Status           | Resolved-WriteOff |
    And user logout from user portal

  @SD-Issuer @TC-187158
  Scenario: Fraud_Issuer Liable_Exception
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
    And backend user validates the Fraud data in VCR Dispute Questionnaire Page as follows
      | Key              | Value |
      | Dispute category | Fraud |
      | Card Status      | Lost  |
      | CH Authorize     | No    |
    Then user clicks on exceptions radio in process issuer liability and validates tab details
      | Key              | Value              |
      | Dispute category | Fraud              |
      | Fraud indicator  | Y                  |
      | Status           | Resolved-Exception |
    And user logout from user portal


  @SD-Issuer @TC-187121
  Scenario: Time frame expiry_No Exception
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then Exception radio button should not be displayed in time frame expiry flow assignment
    And user logout from user portal

  @SD-Issuer @TC-187140
  Scenario: Time frame expiry_Good faith-WO
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then user initiates good faith at time frame expiry flow
    Then user takes write off action at good faith response and validates tab details
      | Key               | Value   |
      | Acquirer response | Decline |
    And user logout from user portal

  @SD-Issuer @TC-187144
  Scenario: Time frame expiry_Good faith-CH Liable
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then user initiates good faith at time frame expiry flow
    Then user takes cardholder liable off action at good faith response and validates tab details
      | Key               | Value   |
      | Acquirer response | Decline |
    And user logout from user portal

  @SD-Issuer @TC-187146
  Scenario: Time frame expiry_cardholder liable
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then user selects cardholder liable in Time Frame Expiry Flow and resolves the dispute
    And user logout from user portal

  @SD-Issuer @TC-187155
  Scenario: Time frame expiry_write off
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then user selects write off in Time Frame Expiry Flow and resolves the dispute
    And user logout from user portal

  @SD-Issuer @TC-187156
  Scenario: Time frame expiry_MP
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160852 |
    And csr selects transaction to create a fraud claim
    And user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry
    And user logout from user portal
    Given a user is logged into application as "anand.bullock@fsi.com" and "install"
    When user filters the claim from fraud wb and lands on time frame expiry assignment
    Then user selects multipronged option and selects "Cardholder liable" and "Write off" action
      | Key                      | Value |
      | Writeoff amount          | 499   |
      | Cardholder liable amount | 1000  |
    And user logout from user portal

