Feature: To Test Pre Arb flows Acquirer liable

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case, Visa gives response as Acquirer liable. Then Acquirer initiates the Pre Arb and Issuer Accepts it then Take Write-off action
  @SD-Issuer @TC-175248

  Scenario: A_AcqLiable_PreArb_AcceptFull_WO
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160843 |
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
    And backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information
    Then backend user Accepts fully the Pre Arb response and then takes Write-off action
    And user logout from user portal

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case, Visa gives response as Acquirer liable. Then Acquirer initiates the Pre Arb and Issuer Accepts it then Take Cardholder liable action
  @SD-Issuer @TC-175290
  Scenario:A_AcqLiable_PreArb_AcceptFull_CH
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160843 |
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
    And backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information
    Then backend user Accepts fully the Pre Arb response and then takes Cardholder liable action
    And user logout from user portal

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case, Visa gives response as Acquirer liable. Then Acquirer intiates the Pre Arb and Issuer Accepts partially it then Take Write-off action
  @SD-Issuer-1 @TC-175262
  Scenario: A_AcqLiable_PreArb_Acceptpartial_WO
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160843 |
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
    And backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information
    Then backend user Accepts partially the Pre Arb response and then takes Write-off action
    And user logout from user portal

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case, Visa gives response as Acquirer liable. Then Acquirer initiates the Pre Arb and Issuer Accepts partially it then Take Cardholder liable action
  @SD-Issuer-1 @TC-175298
  Scenario: A_AcqLiable_PreArb_Acceptpartial_CH
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160843 |
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
    And backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information
    Then backend user Accepts partially the Pre Arb response and then takes cardholder liable action
    And user logout from user portal

  # author: Vamsi Kuppa
  # written on: 28-02-2017
  # step_def file: NA
  # Description: Issuer creates Allocation case, Visa gives response as Acquirer liable. Then Acquirer initiates the Pre Arb and Issuer Declines
  @SD-Issuer @TC-175261
  Scenario: A_AcqLiable_PreArb_Declined
    Given a user is logged into application as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   | 4752999999999991        |
      | Reference Number | 24610432650004020160843 |
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
    And backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information
    Then backend user Declines the Pre Arb response
    And user logout from user portal
