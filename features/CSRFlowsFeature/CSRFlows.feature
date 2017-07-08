Feature: To Test the CSR Flows

  # author: Vamsi Krishna Kuppa
  # written on: 26-02-2017
  # step_def file: NA
  @SD-Issuer-2 @TC-2
  Scenario: Check for CSR Collaboration Flow Processing Errors Write Off
    Given a user is logged into application with as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   |        4752999999999991 |
      | Reference Number | 24610432650004020160853 |
    And csr selects single transaction to create a single dispute
    And user process the csr qualify dispute screen as follows
      | Key               | Value                                 |
      | Dispute Reason    | I paid for this item by another means |
      | Payment method    | Cash                                  |
      | Contact Method    | Telephone                             |
      | Contact Name      | John                                  |
      | Merchant Response | Not helpful                           |
    And user logout from user portal
    Given a user is logged into application with as "anand.bullock@fsi.com" and "install"
    When backend user clicks on customer initiated workbasket and filters the dispute
    And backend user validates the data in VCR Dispute Questionnaire assignment as follows
      | Key                                          | Value               |
      | Dispute category                             | Processing Errors   |
      | Dispute Reason                               | Paid by other means |
      | Are both transactions on same account number | Y                   |
      | Payment method                               | Cash payment        |
    And backend user takes writeoff action in process acquirer response screen to resolve the dispute
    And backend user validates the information on Interview tab as follows
      | Key                                          | Value                                 |
      | Dispute category                             | Processing Errors                     |
      | Dispute Reason                               | I paid for this item by another means |
      | Payment method                               | Cash                                  |
      | Did you attempt to resolve with the merchant | Yes                                   |
      | Contact Method                               | Telephone                             |
      | Contact Name                                 | John                                  |
      | Merchant Response                            | Not helpful                           |
      | Do you have proof of payment                 | Yes                                   |
      | Are both transactions on same account number | Yes                                   |
    And backend user validates the information on Overview tab as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
      | Fraud indicator  | N                 |
      | Status           | Resolved-WriteOff |
    And backend user validates the information on VCR tab as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
    And user logout from user portal

  @SD-Issuer-1 @TC-3
  Scenario: Check for CSR Collaboration Flow Processing Errors Cardholder liable
    Given a user is logged into application with as "kelly.goodhue@fsi.com" and "install"
    When Claim is initiated from Create Menu
    And user enters Transaction information as follows and clicks on search
      | Key              | Value                   |
      | ACCOUNT NUMBER   |        4752999999999991 |
      | Reference Number | 24610432650004020160853 |
    And csr selects single transaction to create a single dispute
    And user process the csr qualify dispute screen as follows
      | Key               | Value                                 |
      | Dispute Reason    | I paid for this item by another means |
      | Payment method    | Cash                                  |
      | Contact Method    | Telephone                             |
      | Contact Name      | John                                  |
      | Merchant Response | Not helpful                           |
    And user logout from user portal
    Given a user is logged into application with as "anand.bullock@fsi.com" and "install"
    When backend user clicks on customer initiated workbasket and filters the dispute
    And backend user validates the data in VCR Dispute Questionnaire assignment as follows
      | Key                                          | Value               |
      | Dispute category                             | Processing Errors   |
      | Dispute Reason                               | Paid by other means |
      | Are both transactions on same account number | Y                   |
      | Payment method                               | Cash payment        |
    And backend user takes cardholder liable action in process acquirer response screen to resolve the dispute
    And backend user validates the information on Interview tab as follows
      | Key                                          | Value                                 |
      | Dispute category                             | Processing Errors                     |
      | Dispute Reason                               | I paid for this item by another means |
      | Payment method                               | Cash                                  |
      | Did you attempt to resolve with the merchant | Yes                                   |
      | Contact Method                               | Telephone                             |
      | Contact Name                                 | John                                  |
      | Merchant Response                            | Not helpful                           |
      | Do you have proof of payment                 | Yes                                   |
      | Are both transactions on same account number | Yes                                   |
    And backend user validates the information on Overview tab as follows
      | Key              | Value                     |
      | Dispute category | Processing Errors         |
      | Fraud indicator  | N                         |
      | Status           | Resolved-CardholderLiable |
    And backend user validates the information on VCR tab as follows
      | Key              | Value             |
      | Dispute category | Processing Errors |
    And user logout from user portal

